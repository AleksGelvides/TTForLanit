package com.gelvides.ttforlanit.services;

import com.gelvides.ttforlanit.domain.PersonDto;
import com.gelvides.ttforlanit.jpa.domain.Person;
import com.gelvides.ttforlanit.jpa.repositories.PersonRepository;
import com.gelvides.ttforlanit.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService implements ServicesApi<PersonDto> {

    private final PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(PersonDto personDto) throws Exception {
        var newPerson = PersonMapper.INSTANCE.toPersonJpa(personDto);
        validator.valid(newPerson);
        repository.save(PersonMapper.INSTANCE.toPersonJpa(personDto));
    }

    public List<PersonDto> getAll() {
        return repository.findAll().stream()
                .map(PersonMapper.INSTANCE::toPersonDto)
                .collect(Collectors.toList());
    }

    @Override
    public PersonDto getEntity(long id) throws Exception {
        var personJpa = repository.findById(id)
                .orElseThrow(() -> new Exception("Пользователя с таким ID не существует"));
        return PersonMapper.INSTANCE.toPersonDto(personJpa);
    }

    public void deleteAll(){
        repository.deleteAll();
    }

    Validator<Person> validator = new Validator<>() {
        @Override
        public void valid(Person person) throws Exception {
            if(!repository.findById(person.getId()).isEmpty())
                throw new Exception("Этот пользователь уже существует");
            if(person.getBirthdate().after(new Date()))
                throw new Exception("Дата рождения пользователя не может быть сегодня");
        }
    };
}

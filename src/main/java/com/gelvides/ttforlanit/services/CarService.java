package com.gelvides.ttforlanit.services;

import com.gelvides.ttforlanit.domain.CarDto;
import com.gelvides.ttforlanit.jpa.domain.Car;
import com.gelvides.ttforlanit.jpa.repositories.CarRepository;
import com.gelvides.ttforlanit.mapper.CarMapper;
import com.gelvides.ttforlanit.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class CarService implements ServicesApi<CarDto>{
    private final CarRepository repository;
    private final PersonService personService;

    @Autowired
    public CarService(CarRepository repository, PersonService personService) {
        this.repository = repository;
        this.personService = personService;
    }

    @Override
    public void save(CarDto carDto) throws Exception {
        var newCar = CarMapper.INSTANCE.toCarJpa(carDto);
        newCar.setPerson(PersonMapper.INSTANCE.toPersonJpa(personService.getEntity(carDto.getOwnerid())));
        validator.valid(newCar);
        repository.save(newCar);
    }

    @Override
    public CarDto getEntity(long id) {
        return null;
    }
    Validator<Car> validator = new Validator<>() {
        @Override
        public void valid(Car car) throws Exception {
            // Проверка Horse Power
            if(car.getHorsepower() <= 0)
                throw new Exception("Horse power не может быть 0 или меньше");

            // Проверка ДР пользователя
            Date personBirthday = car.getPerson().getBirthdate();
            Calendar needDate = Calendar.getInstance();
            needDate.setTime(personBirthday);
            needDate.add(Calendar.YEAR, 18);
            if(needDate.getTime().after(new Date()))
                throw new Exception("Владелец не может быть младше 18 лет");

            // Проверка существования такого ID
            if(!repository.findById(car.getId()).isEmpty())
                throw new Exception("Автомобиль уже зарегистрирован");
        }
    };
}

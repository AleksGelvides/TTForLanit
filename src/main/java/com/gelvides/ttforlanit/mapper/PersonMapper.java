package com.gelvides.ttforlanit.mapper;

import com.gelvides.ttforlanit.domain.CarDto;
import com.gelvides.ttforlanit.domain.PersonDto;
import com.gelvides.ttforlanit.jpa.domain.Car;
import com.gelvides.ttforlanit.jpa.domain.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    //Этот метод нужен для маппинга коллекции автомобилей.
    @Mapping(target = "ownerid", expression = "java(car.getOwnerid())")
    @Mapping(target = "model", expression = "java(car.getFullName())")
    CarDto toCarDto(Car car);

    //Маппинг из JPA в DTO
    PersonDto toPersonDto(Person person);
    //Маппинг из DTO в JPA
    Person toPersonJpa(PersonDto personDto);
}

package com.gelvides.ttforlanit.mapper;

import com.gelvides.ttforlanit.domain.CarDto;
import com.gelvides.ttforlanit.jpa.domain.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    //Маппинг из JPA в
    @Mapping(target = "ownerid", expression = "java(car.getOwnerid())")
    @Mapping(target = "model", expression = "java(car.getFullName())")
    CarDto toCarDto(Car car);

    //Маппинг из DTO в JPA
    @Mapping(target = "vendor", expression = "java(carDto.getModel().split(\"-\")[0])")
    @Mapping(target = "model", expression = "java(carDto.getModel().split(\"-\")[1])")
    Car toCarJpa(CarDto carDto);
}

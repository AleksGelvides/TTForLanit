package com.gelvides.ttforlanit.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gelvides.ttforlanit.jpa.domain.Person;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
public class CarDto extends MainDto {
    @NotNull
    @Pattern(regexp = ".+-.+")
    private String model;
    @NotNull
    @Min(1)
    private Integer horsepower;
    @NotNull
    @Min(1)
    private Long ownerid;


    public CarDto(long id,
                  String model,
                  Integer horsepower,
                  Long ownerid){
        super(id);
        this.model = model;
        this.horsepower = horsepower;
        this.ownerid = ownerid;
    };


}

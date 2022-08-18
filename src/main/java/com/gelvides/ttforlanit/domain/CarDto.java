package com.gelvides.ttforlanit.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class CarDto extends MainDto {
    @NotNull
    @Pattern(regexp = ".+-.+")
    private String model;
    @NotNull
    private Integer horsepower;
    @NotNull
    private Long ownerid;


    public CarDto(long id,
                  String model,
                  Integer horsepower,
                  Long ownerid){
        super(id);
        this.model = model;
        this.horsepower = horsepower;
        this.ownerid = ownerid;
    }
}

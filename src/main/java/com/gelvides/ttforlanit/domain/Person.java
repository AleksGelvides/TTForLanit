package com.gelvides.ttforlanit.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

import java.util.Date;

@Getter
@Setter
public class Person extends Main{

    @NotNull
    private String name;

    @NotNull
    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date birthdate;



    public Person(long id,
                  String name,
                  @JsonFormat(pattern = "dd.MM.yyyy") Date birthdate) {
        super(id);
        this.name = name;
        this.birthdate = birthdate;
    }
}

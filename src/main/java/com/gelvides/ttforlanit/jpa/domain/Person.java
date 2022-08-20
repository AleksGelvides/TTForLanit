package com.gelvides.ttforlanit.jpa.domain;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.System.out;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "person")
public class Person {

    @Id
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "birthdate")
    private Date birthdate;

    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
    private List<Car> cars;

}

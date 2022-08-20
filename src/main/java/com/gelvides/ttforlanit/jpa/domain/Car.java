package com.gelvides.ttforlanit.jpa.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Accessors(chain = true)
@Table(name = "car")
@Getter
@Setter
public class Car {
    @Id
    private long id;
    @Column(name = "model")
    private String model;
    @Column(name = "horsepower")
    private int horsepower;
    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    public Long getOwnerid(){
        return person.getId();
    }

}

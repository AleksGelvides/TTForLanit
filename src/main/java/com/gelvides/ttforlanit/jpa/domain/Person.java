package com.gelvides.ttforlanit.jpa.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

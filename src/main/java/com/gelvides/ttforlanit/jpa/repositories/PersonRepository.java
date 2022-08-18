package com.gelvides.ttforlanit.jpa.repositories;

import com.gelvides.ttforlanit.jpa.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Person getById(long id);
}

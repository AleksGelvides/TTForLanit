package com.gelvides.ttforlanit.jpa.repositories;

import com.gelvides.ttforlanit.jpa.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    void deleteAll();
}

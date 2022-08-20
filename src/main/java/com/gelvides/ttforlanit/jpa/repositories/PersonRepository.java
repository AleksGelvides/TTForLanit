package com.gelvides.ttforlanit.jpa.repositories;

import com.gelvides.ttforlanit.jpa.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<Person, Long> {
    void deleteAll();

    @Query(nativeQuery = true,
    value = "select count(p.id) from person p")
    Long getCountPersons();
}

package com.gelvides.ttforlanit.jpa.repositories;

import com.gelvides.ttforlanit.jpa.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CarRepository extends JpaRepository<Car, Long> {
}

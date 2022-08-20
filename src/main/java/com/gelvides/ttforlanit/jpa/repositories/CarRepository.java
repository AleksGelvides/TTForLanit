package com.gelvides.ttforlanit.jpa.repositories;

import com.gelvides.ttforlanit.jpa.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarRepository extends JpaRepository<Car, Long> {

    @Query(nativeQuery = true,
            value = "select count(c.id) from car c")
    Long getCountCar();

    @Query(nativeQuery = true,
            value = "select count(distinct (upper(c.vendor))) from car c")
    Long getCountUnicVendorCar();
}

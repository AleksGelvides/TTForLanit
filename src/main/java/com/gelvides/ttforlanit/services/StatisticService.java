package com.gelvides.ttforlanit.services;

import com.gelvides.ttforlanit.domain.Statistic;
import com.gelvides.ttforlanit.jpa.repositories.CarRepository;
import com.gelvides.ttforlanit.jpa.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticService {
    private final PersonRepository personRepository;
    private final CarRepository carRepository;

    @Autowired
    public StatisticService(PersonRepository personRepository, CarRepository carRepository) {
        this.personRepository = personRepository;
        this.carRepository = carRepository;
    }



    public Statistic getStatistic(){
        return new Statistic()
                .setPersoncount(personRepository.getCountPersons())
                .setCarcount(carRepository.getCountCar())
                .setUnicvendorcount(carRepository.getCountUnicVendorCar());
    }
}

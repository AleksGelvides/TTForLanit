package com.gelvides.ttforlanit.controller;

import com.gelvides.ttforlanit.domain.CarDto;
import com.gelvides.ttforlanit.domain.PersonDto;
import com.gelvides.ttforlanit.services.CarService;
import com.gelvides.ttforlanit.services.PersonService;
import com.gelvides.ttforlanit.services.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class MainRestController {
    private final PersonService personService;
    private final CarService carService;
    private final StatisticService statisticService;
    @Autowired
    public MainRestController(PersonService personService,
                              CarService carService,
                              StatisticService statisticService) {
        this.personService = personService;
        this.carService = carService;
        this.statisticService = statisticService;
    }

    @PostMapping("/person")
    public ResponseEntity<?> createPerson(@Valid @RequestBody PersonDto personDto){
        try {
            personService.save(personDto);
            return new ResponseEntity<>("Пользователь успешно сохранен", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/car")
    public ResponseEntity<?> createCar(@Valid @RequestBody CarDto carDto){
        try {
            carService.save(carDto);
            return new ResponseEntity<>("Автомобиль успешно сохранен", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/personwithcars")
    public ResponseEntity<?> getPersonWithCars(@RequestParam(name = "personId") long personId){
        try{
            return new ResponseEntity<>(personService.getEntity(personId), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>("Такой пользователь не найден", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/statistic")
    public ResponseEntity<?> getStatistic(){
        try{
            var statistic = statisticService.getStatistic();
            return new ResponseEntity<>(statistic, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/delete")
    public ResponseEntity<?> delete(){
        personService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

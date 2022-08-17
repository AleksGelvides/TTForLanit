package com.gelvides.ttforlanit.controller;

import com.gelvides.ttforlanit.domain.Car;
import com.gelvides.ttforlanit.domain.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class MainRestController {

    @PostMapping("/person")
    public ResponseEntity<?> createPerson(@Valid @RequestBody Person person){
        try {
            return new ResponseEntity<>(person, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/car")
    public ResponseEntity<?> createCar(@Valid @RequestBody Car car){
        try {
            return new ResponseEntity<>(car, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

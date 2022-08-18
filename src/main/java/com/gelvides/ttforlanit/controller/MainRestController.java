package com.gelvides.ttforlanit.controller;

import com.gelvides.ttforlanit.domain.CarDto;
import com.gelvides.ttforlanit.domain.PersonDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class MainRestController {

    @PostMapping("/person")
    public ResponseEntity<?> createPerson(@Valid @RequestBody PersonDto personDto){
        try {
            return new ResponseEntity<>(personDto, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/car")
    public ResponseEntity<?> createCar(@Valid @RequestBody CarDto carDto){
        try {
            return new ResponseEntity<>(carDto, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

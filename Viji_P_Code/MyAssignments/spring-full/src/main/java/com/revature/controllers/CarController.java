package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Car;
import com.revature.service.CarService;

@RestController
@RequestMapping("/car")
public class CarController {
	
	@Autowired
	CarService service;
	
	@RequestMapping
	public ResponseEntity<List<Car>> findAll(){
		List<Car> car = service.getAll();
		if(car == null || car.size() == 0)
		return new ResponseEntity<List<Car>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Car>>(car, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Car> add(@RequestBody Car c){
		c = service.add(c);
		return new ResponseEntity<Car>(c, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{brand}")
	public ResponseEntity<Car> findByBrand(@PathVariable String brand){
		return new ResponseEntity<Car>(service.getByBrand(brand), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{yearMade}")
	public ResponseEntity<Car> findByYearMade(@PathVariable int yearMade){
		return new ResponseEntity<Car>(service.findByYearMade(yearMade), HttpStatus.OK);
	}
	
}

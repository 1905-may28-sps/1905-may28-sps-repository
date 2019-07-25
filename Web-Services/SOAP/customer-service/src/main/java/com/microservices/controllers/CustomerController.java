package com.microservices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.models.Customer;
import com.microservices.repositories.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepo;
	
	@RequestMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customer>> getAll(){
		return new ResponseEntity<List<Customer>>(customerRepo.findAll(), HttpStatus.OK);
	}

}

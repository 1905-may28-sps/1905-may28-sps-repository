package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Jeans;
import com.revature.service.JeanService;

@RestController 
@RequestMapping("/jeans")
@CrossOrigin("*")
public class JeansController {
	
	@Autowired
	JeanService service;
	
	@RequestMapping
	public ResponseEntity<List<Jeans>> findAll(){
		List<Jeans> phones = service.getAll();
		if(phones == null || phones.size() == 0) return new ResponseEntity<List<Jeans>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Jeans>>(phones, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Jeans> add(@RequestBody Jeans j){
		j = service.add(j);
		return new ResponseEntity<Jeans>(j, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{fit}")
	public ResponseEntity<List<Jeans>> findByFit(@PathVariable String fit){
		return new ResponseEntity<List<Jeans>>(service.getByFit(fit), HttpStatus.OK);
	}
	
	

}
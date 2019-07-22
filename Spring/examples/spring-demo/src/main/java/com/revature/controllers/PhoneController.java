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

import com.revature.beans.Phone;
import com.revature.service.PhoneService;

@RestController  //what is the difference between this and @Controller?
@RequestMapping("/phone")
public class PhoneController {
	
	@Autowired
	PhoneService service;
	
	@RequestMapping
	public ResponseEntity<List<Phone>> findAll(){
		List<Phone> phones = service.getAll();
		if(phones == null || phones.size() == 0) return new ResponseEntity<List<Phone>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Phone>>(phones, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Phone> add(@RequestBody Phone p){
		p = service.add(p);
		return new ResponseEntity<Phone>(p, HttpStatus.CREATED);
	}
	
//	@RequestMapping(value="/{brand}")
//	public ResponseEntity<List<Phone>> findByBrand(@PathVariable String brand){
//		return new ResponseEntity<List<Phone>>(service.getByBrand(brand), HttpStatus.OK);
//	}
//	
	

}

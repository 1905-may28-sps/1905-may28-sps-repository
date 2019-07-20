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

import com.revature.models.Fishing;
import com.revature.service.FishingService;

@RestController
@CrossOrigin
public class FishingController {

	@Autowired
	FishingService service;
	
	//GET -/fishing
		@RequestMapping(value="/fishing", method=RequestMethod.GET, 
				produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Fishing>> getAllFishing(){
			return new ResponseEntity<List<Fishing>>(service.getAll(), HttpStatus.OK);
		}
		
		@RequestMapping(method=RequestMethod.GET, value="/fishing/species={name}",produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Fishing> findBySpecies(@PathVariable String name){
			Fishing f = service.findBySpecies(name);
			return new ResponseEntity<Fishing>(f, HttpStatus.OK);
		}
		
		//POST -/fishing
		@RequestMapping(value="/fishing", method=RequestMethod.POST, 
				consumes=MediaType.APPLICATION_JSON_VALUE,
				produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Fishing> add(@RequestBody Fishing fishing){
			//lets assume we will always have 201 status
			Fishing f = service.add(fishing);
			if (f==null) return new ResponseEntity<Fishing>(HttpStatus.CONFLICT);
			return new ResponseEntity<Fishing>(f, HttpStatus.CREATED);
		}
	
}

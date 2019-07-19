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

import com.revature.models.Outfit;
import com.revature.service.OutfitService;

@RestController
@CrossOrigin
public class OutfitController {
	
	@Autowired
	private OutfitService service;
	
	//get
	@RequestMapping(value="/outfits", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Outfit>> findAll(){
		return new ResponseEntity<List<Outfit>>(service.getAll(), HttpStatus.OK);
	}
	
	//post
	@RequestMapping(value="/outfits", method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Outfit> add(@RequestBody Outfit outfit){
		Outfit o = service.add(outfit);
		if(o == null) return new ResponseEntity<Outfit>(HttpStatus.CONFLICT);
		return new ResponseEntity<Outfit>(o, HttpStatus.CREATED);
	}
	
	
	//get by nameish
	@RequestMapping(method=RequestMethod.GET, value="/name={name}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Outfit> findByName(@PathVariable String name){
		Outfit o = service.findByName(name);
		return new ResponseEntity<Outfit>(o, HttpStatus.OK);
	}
	
	
//	@RequestMapping(method=RequestMethod.GET, value="/users/weather~{weather}",produces=MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Outfit> findByWeather(@PathVariable String weather){
//		Outfit o = service.findByWeather(weather);
//		return new ResponseEntity<Outfit>(o, HttpStatus.OK);
//	}

	

}
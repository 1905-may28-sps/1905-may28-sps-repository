package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Athlete;
import com.revature.service.AthleteService;

@RestController
@RequestMapping("/athlete")
public class AthleteController {
	
	@Autowired
	AthleteService service;
	

	@RequestMapping(method=RequestMethod.GET, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Athlete> getAllAthlete(){
		return service.getAll();
			
	}


}

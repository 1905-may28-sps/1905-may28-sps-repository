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

import com.revature.beans.Movie;
import com.revature.service.MovieService;

@RestController
@RequestMapping("/movie")
@CrossOrigin("*")
public class MovieController {
	
	@Autowired
	MovieService service;
	
	@RequestMapping(method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Movie> add(@RequestBody Movie m){
		m = service.add(m);
		return new ResponseEntity<Movie>(m, HttpStatus.CREATED);
	}
	
	@RequestMapping
	public ResponseEntity<List<Movie>> findAll(){
		return new ResponseEntity<List<Movie>>(service.getAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{title}")
	public ResponseEntity<Movie> findByTitle(@PathVariable String title){
		return new ResponseEntity<Movie>(HttpStatus.OK);
	}
	

	

}

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

import com.revature.models.User;
import com.revature.service.UserService;

@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(value="/users", method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> add(@RequestBody User user){
		User u = service.add(user);
		if(u == null) return new ResponseEntity<User>(HttpStatus.CONFLICT);
		return new ResponseEntity<User>(u, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/users", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> findAll(){
		return new ResponseEntity<List<User>>(service.getAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/users/username={name}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> findByUsername(@PathVariable String name){
		User u = service.findByUsername(name);
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}
	

	

}

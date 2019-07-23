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

import com.revature.models.DhalUsers;
import com.revature.service.UsersService;

@RestController
@CrossOrigin
public class UsersController {

	@Autowired
	private UsersService service;

	@RequestMapping(value = "/users", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DhalUsers> add(@RequestBody DhalUsers user) {
		DhalUsers u = service.add(user);
		if (u == null)
			return new ResponseEntity<DhalUsers>(HttpStatus.CONFLICT);
		return new ResponseEntity<DhalUsers>(u, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DhalUsers>> findAll() {
		return new ResponseEntity<List<DhalUsers>>(service.getAll(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/users/username={name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DhalUsers> findByUsername(@PathVariable String name) {
		DhalUsers u = service.findByUsername(name);
		return new ResponseEntity<DhalUsers>(u, HttpStatus.OK);
	}

}
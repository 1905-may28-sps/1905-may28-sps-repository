package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Anime;
import com.revature.service.AnimeService;

@RestController
@RequestMapping("/anime")
public class RestControl {

		@Autowired
		private AnimeService service;
		
		//Get Anime
		@RequestMapping(method=RequestMethod.GET,
				produces=MediaType.APPLICATION_JSON_VALUE)
		public List<Anime>  gettingAllUsers(){
			return service.getAll();
		}
		
		//Post Anime
		@RequestMapping (method=RequestMethod.POST,
				consumes=MediaType.APPLICATION_JSON_VALUE,
				produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Anime> save (@RequestBody Anime anime){
			anime = service.save(anime);
			return new ResponseEntity<Anime>(anime, HttpStatus.CREATED);
		}
}

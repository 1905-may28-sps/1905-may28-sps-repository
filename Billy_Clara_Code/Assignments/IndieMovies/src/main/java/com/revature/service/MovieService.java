package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Movie;
import com.revature.repositories.MovieRepository;

@Service
public class MovieService {
	
	
	@Autowired
	MovieRepository dao;
	
	public Movie add(Movie movie) {
		return dao.save(movie);
	}

	public List<Movie> getAll(){
		return dao.findAll();
	}
	public List<Movie> getByTitle(String title){
		return dao.findByTitle(title);
	}
}

package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Outfit;
import com.revature.repositories.OutfitRepository;

@Service
@Transactional
public class OutfitService {
	
	@Autowired
	private OutfitRepository outfitRepo;
	
	public List<Outfit> getAll() {
		return outfitRepo.findAll();
	}

	public Outfit add(Outfit o) {
		return outfitRepo.save(o);
	}

	
	
	public List<Outfit> findByName(String name) {
		return outfitRepo.findByNameContainingIgnoreCase(name);
	}



	public List<Outfit> findByWeather(String name) {
		return outfitRepo.findByWeatherContainingIgnoreCase(name);
	}



}

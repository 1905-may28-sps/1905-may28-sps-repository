package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Fishing;
import com.revature.repositories.FishingRepository;

@Service
@Transactional
public class FishingService {
	
	@Autowired
	FishingRepository fishingRepo;
	
	public List<Fishing> getAll(){
		return fishingRepo.findAll();
	}
	
	public Fishing add(Fishing f) {
		return fishingRepo.save(f);
	}
	
	public Fishing findById(int id) {
		return fishingRepo.findOne(id);
	}
	
	public Fishing findBySpecies(String species) {
		System.out.println("in find by species");
		return fishingRepo.findBySpeciesLikeIgnoreCase(species);
	}
	
	public Fishing findByWeight(int weight) {
		System.out.println("in find by weight");
		return fishingRepo.findByWeightGreaterThanEqual(weight);
	}
	
	public Fishing update(Fishing f) {
		return null;
	}

}

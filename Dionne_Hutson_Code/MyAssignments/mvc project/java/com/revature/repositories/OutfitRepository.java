package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Outfit;

public interface OutfitRepository  extends JpaRepository<Outfit, Integer> {
	Outfit findByName(String name);
	
//	Outfit findByNameContainingIgnoreCase(String name);
	//Outfit findByWeatherContainingIgnoreCase(String key);

}

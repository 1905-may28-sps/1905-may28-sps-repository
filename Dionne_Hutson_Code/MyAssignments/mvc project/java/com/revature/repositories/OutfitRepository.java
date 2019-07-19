package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Outfit;

public interface OutfitRepository  extends JpaRepository<Outfit, Integer> {

	
	List<Outfit> findByNameContainingIgnoreCase(String name);
	List<Outfit> findByWeatherContainingIgnoreCase(String key);

}

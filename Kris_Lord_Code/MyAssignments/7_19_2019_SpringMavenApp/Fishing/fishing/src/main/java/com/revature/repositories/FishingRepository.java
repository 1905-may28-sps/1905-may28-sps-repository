package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Fishing;

@Transactional
@Repository
public interface FishingRepository extends JpaRepository<Fishing, Integer> {

	Fishing findBySpeciesLikeIgnoreCase(String species);
	Fishing findByWeightGreaterThanEqual(int weight);
	List<Fishing> findAll();
	
}

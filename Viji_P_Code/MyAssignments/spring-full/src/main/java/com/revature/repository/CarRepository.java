package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Car;

@Transactional
@Repository
public interface CarRepository extends JpaRepository<Car, Integer>{
	
	Car findByBrandLikeIgnoreCase(String brand);
	Car findByYearMade(int yearMade);
    List<Car> findByBrand(String brand);
}

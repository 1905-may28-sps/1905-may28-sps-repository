package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Car;
import com.revature.repository.CarRepository;

@Service
@Transactional
public class CarService {

	@Autowired
	CarRepository dao;
	
	public Car add(Car car) {
		return dao.save(car);
	}
	
	public List<Car> getAll(){
		return dao.findAll();
	}
	
	public Car getByBrand(String brand){
		System.out.println("In find by Brand");
		return dao.findByBrandLikeIgnoreCase(brand);
	}
	
	public Car findByYearMade(int yearMade) {
		System.out.println("In find by year made");
		return dao.findByYearMade(yearMade);
	}
	
	public Car update(Car car) {
		return null;
	}
}

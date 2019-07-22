package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Phone;
import com.revature.repository.PhoneRepository;

@Service
public class PhoneService {
	
	
	@Autowired
	PhoneRepository dao;
	
	public Phone add(Phone phone) {
		return dao.save(phone);
	}
	
	public List<Phone> getAll(){
		return dao.findAll();
	}
	
	public List<Phone> getByBrand(String brand){
		return dao.findByBrand(brand);
	}

}

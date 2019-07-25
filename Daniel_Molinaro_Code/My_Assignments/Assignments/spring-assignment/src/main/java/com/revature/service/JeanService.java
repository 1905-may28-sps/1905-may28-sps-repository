package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Jeans;
import com.revature.repository.JeansRepository;

@Service
public class JeanService {
	
	
	@Autowired
	JeansRepository dao;
	
	public Jeans add(Jeans jean) {
		return dao.save(jean);
	}
	
	public List<Jeans> getAll(){
		return dao.findAll();
	}
	
	public List<Jeans> getByFit(String fit){
	return dao.findByFit(fit);
}

}
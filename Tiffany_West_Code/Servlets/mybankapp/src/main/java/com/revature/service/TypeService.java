package com.revature.service;

import java.util.List;

import com.revature.dao.typeDao;
import com.revature.pojos.Type;

public class TypeService {

	
	private typeDao typedao = new typeDao();
	
	public List<Type> findAllTypes(){
		return typedao.findAll();
	}
	
}

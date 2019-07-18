package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public List<User> getAll() {
		return userRepo.findAll();
	}

	public User add(User u) {
		return userRepo.save(u);
	}

	public User findById(int id) {
		return userRepo.findOne(id);
	}

	public User findByUsername(String username) {
		System.out.println("in find by username");
		return userRepo.findByUsernameIgnoreCase(username);
	}

	public User update(User u) {
		return null;
	}

}
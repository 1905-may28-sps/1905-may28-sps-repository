package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUsernameIgnoreCase(String name);
	
}

package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.revature.models.DhalUsers;

@Repository
public interface UsersRepository extends JpaRepository<DhalUsers, Integer>{
	DhalUsers findByUsernameIgnoreCase(String name);
	
}
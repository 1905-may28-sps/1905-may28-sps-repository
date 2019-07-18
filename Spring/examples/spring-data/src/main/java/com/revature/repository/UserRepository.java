package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.User;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	//i want to find user with username (case insentitive)
	User findByUsernameLikeIgnoreCase(String username);
	User findByUsernameLikeIgnoreCaseAndPassword(String username, String password);
	List<User> findByUsernameStartingWith(String start);

}

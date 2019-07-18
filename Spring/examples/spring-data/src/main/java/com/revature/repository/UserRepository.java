package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}

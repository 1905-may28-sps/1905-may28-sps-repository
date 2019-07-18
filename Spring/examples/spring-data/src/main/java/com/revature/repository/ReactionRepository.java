package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Reaction;

@Repository
public interface ReactionRepository extends JpaRepository<Reaction, Integer>{

}

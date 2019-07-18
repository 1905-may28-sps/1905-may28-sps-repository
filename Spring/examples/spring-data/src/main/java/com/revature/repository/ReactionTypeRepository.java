package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.ReactionType;

@Repository
public interface ReactionTypeRepository extends JpaRepository<ReactionType, Integer>{

}

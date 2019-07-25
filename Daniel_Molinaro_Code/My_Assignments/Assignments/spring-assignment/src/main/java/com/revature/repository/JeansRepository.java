package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.beans.Jeans;


@Repository
public interface JeansRepository extends JpaRepository<Jeans, Integer>{
	
	List<Jeans> findByFit(String fit);
	
	/*
	 * In order to do more complex queries, we can use the 
	 * @Query annotation over a method and write out the 
	 * query string we want the method to represent
	 * 
	 * more info here: https://www.baeldung.com/spring-data-jpa-query
	 */
	@Query("SELECT j FROM Jeans j WHERE j.fit BETWEEN ?1 AND ?2")
	public List<Jeans> randomQuery(int id1, int id2);

}
package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.beans.Phone;


@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer>{
	
	List<Phone> findByBrand(String brand);
	
	/*
	 * In order to do more complex queries, we can use the 
	 * @Query annotation over a method and write out the 
	 * query string we want the method to represent
	 * 
	 * more info here: https://www.baeldung.com/spring-data-jpa-query
	 */
	@Query("SELECT p FROM Phone p WHERE p.id BETWEEN ?1 AND ?2")
	public List<Phone> randomQuery(int id1, int id2);

}

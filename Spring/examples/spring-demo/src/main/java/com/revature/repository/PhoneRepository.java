package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Phone;


@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer>{
	
	List<Phone> findByBrand(String brand);

}

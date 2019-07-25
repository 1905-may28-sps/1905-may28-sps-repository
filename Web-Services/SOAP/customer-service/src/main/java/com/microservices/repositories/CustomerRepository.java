package com.microservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}

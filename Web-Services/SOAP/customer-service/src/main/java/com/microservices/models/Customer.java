package com.microservices.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Customer {
	
	@Id
	@SequenceGenerator(allocationSize=1, name="cust_seq_gen", sequenceName="cust_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cust_seq_gen")
	private int id;
	private String username;
	private String password;
	
	Customer(){}

	public Customer(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}

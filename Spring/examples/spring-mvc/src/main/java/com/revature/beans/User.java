package com.revature.beans;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

/*
 * Exploring JSR-303 (Bean validation)
 * - Java Specification Request 
 * - the specification of the Java API for JavaBean validation
 * - it provides an easy way of ensuring that the properties of 
 * your beans have the right values in them
 * 
 */

@Component
public class User {
	
	@Min(value=0)
	private int id;
	
	@NotNull
	@Size(min=5)
	@Pattern(regexp="[a-z-A-Z]*")
	private String username;
	
	@Size(min=5)
	private String password;
	
	public User() {}

	public User(int id, String username, String password) {
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

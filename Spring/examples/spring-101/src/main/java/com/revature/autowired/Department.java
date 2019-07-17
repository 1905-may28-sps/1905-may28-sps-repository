package com.revature.autowired;

import org.springframework.stereotype.Component;

/*
 * Spring uses many annotations to register 
 * classes as "beans" (again, these are simply objects
 * that will be managed by the container)
 * For simple POJOS, we use the @Component annotation
 * We will later see others, like @Service, 
 * @Repository, @Controller...
 */

@Component
public class Department {
	
	private String name;
	
	public Department() {}

	public Department(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [name=" + name + "]";
	}
	
	

}

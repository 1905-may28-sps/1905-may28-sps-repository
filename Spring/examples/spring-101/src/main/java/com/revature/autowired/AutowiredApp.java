package com.revature.autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowiredApp {
	
	public static void main(String[] args) {
		
		/*
		Employee emp = new Employee();
		emp.getDepartment().setName("Training");
		System.out.println(emp);
		*/
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Employee emp = (Employee) context.getBean(Employee.class);
		emp.getDepartment().setName("Training");
		System.out.println(emp);
	}

}

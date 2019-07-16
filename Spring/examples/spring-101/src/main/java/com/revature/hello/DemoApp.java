package com.revature.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoApp {
	
	public static void main(String[] args) {
		//The following instantiation uses the new keyword, and therefore does not rely on IoC
		HelloSpring spring = new HelloSpring();
		System.out.println(spring.getMessage());
		
		//If we want to use spring and leverage IoC and DI, we must leverage our AppContext
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		HelloSpring hello = (HelloSpring) context.getBean("thisIsABean");
		System.out.println(hello.getMessage());
	}

}

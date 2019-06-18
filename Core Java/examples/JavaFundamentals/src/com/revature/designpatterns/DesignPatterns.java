package com.revature.designpatterns;

public class DesignPatterns {
	/*
	 * A design pattern is a solution (or general approach to solving) 
	 * a common problem in coding
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
	
		Singleton.test();
		LazySingleton.test();
	}
	
	static void exploringSingletons() {
		Singleton single = Singleton.getInstance();
		single.name = "my first reference to static instance created in class";
		
		
		Singleton single2 = Singleton.getInstance();
		single2.name = "my second reference to the same instance";
		
		System.out.println(single.name);
		System.out.println(single2.name);
	}

}

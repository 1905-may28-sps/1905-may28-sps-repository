package com.revature.designpatterns;

public class Singleton {
	/*
	 * Singleton design pattern - used in scenarios 
	 * which require one and only one instance of 
	 * an object to be created 
	 * 
	 * This typically means that the class will have a 
	 * private constructor and public getInstance() 
	 * method that references the single instance created 
	 */
	
	private static Singleton singletonInstance = new Singleton();
	String name; //to test that it's the same instance
	
	private Singleton() {
		System.out.println("Constructing singleton object");
	}
	
	public static Singleton getInstance() {
		return singletonInstance;
	}
	
	public static void test() {
		System.out.println("calling static method in Singleton class");
	}
}

package com.revature.designpatterns;

public class LazySingleton {

	/*
	 * Unlike the "eager" singleton, we only instantiate a "lazy"
	 * singleton object when we call the getinstance method for the 
	 * first time 
	 */
	
	private static LazySingleton singletonInstance;
	
	private LazySingleton() {
		System.out.println("constructing lazy singleton");
	}
	
	public static LazySingleton getInstance() {
		if(singletonInstance == null) {
			singletonInstance = new LazySingleton();
		}
		return singletonInstance;
	}
	
	public static void test() {
		System.out.println("calling static method in LAZY Singleton class");
	}
}

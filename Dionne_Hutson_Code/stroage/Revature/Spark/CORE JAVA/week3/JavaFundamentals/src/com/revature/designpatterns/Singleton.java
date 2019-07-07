package com.revature.designpatterns;

public class Singleton {
	private static Singleton singleton=new Singleton();
	public String name;
	private Singleton() {
		System.out.println("Constructor");
	}
	public static Singleton getInstance() {// since it is static we dont need and instance to get an instace
		return singleton;
	}

}

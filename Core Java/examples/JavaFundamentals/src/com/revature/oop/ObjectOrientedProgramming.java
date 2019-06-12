package com.revature.oop;

public class ObjectOrientedProgramming {
	
	/*
	 * Object oriented programming is a programming paradigm that
	 * gives importance to data rather than just writing instructions
	 * to complete a task (like functional programming)
	 * 
	 * In OOP, our unit of modularity (smallest independent units 
	 * of code) are classes. An object is an idea or thing that you 
	 * want to model in your program, and a class is a blueprint for
	 * an object. 
	 * 
	 * Objects in java have state(instance variables)
	 * and behavior(methods). Classes define the state
	 * and behavior. 
	 * 
	 * OOP is further defined by its four pillars/principles 
	 * 
	 * ABSTRACTION = hiding implementation details and exposing 
	 * functionality only 
	 * --> abstract methods, abstract classes, and interfaces
	 * 
	 * POLYMORPHISM = the ability of an object to take on different 
	 * behavior, usually through its parent class
	 * --> method overriding, method overloading, covariant types 
	 * 
	 * INHERITANCE = the ability of objects to share state and behavior 
	 * between parent and super classes 
	 * --> extending classes, and implementing interfaces 
	 * 
	 * ENCAPSULATION = restriction of direct data access from 
	 * other objects, and requiring all interaction to occur 
	 * through methods
	 * --> private instance vars, public getters and setters
	 */
	
	
	public static void main(String[] args) {
		Person p = new Person("Gen", 50);
		Person p2 = new Person();
		p2.setName("Genesis");
		System.out.println("Person p " + p.getName());
		System.out.println("Person p2 " + p2.getName());
	}

}

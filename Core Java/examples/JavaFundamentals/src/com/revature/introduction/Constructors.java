package com.revature.introduction;

public class Constructors {
	/*
	 * A constructor in Java is a block of code 
	 * that is similar to a method (not technically 
	 * a method as it does not have a return type)
	 * that gets called when an instance of a class
	 * is created. 
	 * 
	 * All classes have an implicit or DEFAULT 
	 * constructor unless one is defined 
	 * 
	 * The first line of ANY constructor MUST be 
	 * either a call to the super class's constructor
	 * super()
	 * OR a call to another constructor in the current class 
	 * this()
	 * if we put neither, the first line is an 
	 * implicit call to the super class's no argument constructor
	 * 
	 * 	 */
	
	private String name;
	private int id;

	//no arg constructor, if we never define one this is also the 
	//default constructor
	public Constructors() {
		this("defaultName", 7);
	}
	
	//Constructors c = new Constructors();
	//Constructors c = new Constructors("Genesis", 1);
	public Constructors(String name, int id) {
		super();
		this.name = name;
		this.id = id;		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name == null) return;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public static void main(String[] args) {
		C myInstance = C.getInstance();
		
		B b = new B();
	}
}

class A{
	A(){
		System.out.println("CLASS A CONSTRUCTOR");
	}
}

class B extends A{
	B(){
		System.out.println("CLASS B CONSTRUCTOR");
	}
}

class C extends B{
	
	private static C c = new C();
	
	private C(){
		//super();
		System.out.println("CLASS C CONSTRUCTOR");
	}
	
	static C getInstance() {
		return c;
	}
}

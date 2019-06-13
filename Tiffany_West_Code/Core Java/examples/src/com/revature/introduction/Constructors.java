package com.revature.introduction;

public class Constructors {
/*
 * 
 * the first line of any constructor must be either a call to the suoer class's constructor in the current class
 * this()
 */
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
	 * 
	 * 
	 * more info:
	 * https://www.dummies.com/programming/java/how-to-use-a-constructor-in-java/
	 * 
	 * 
	 * 	 */
	private String name;
	private int id;
	
	// Default constructor isn't called but you know its there
	
	//no arg constructor now that it is here
	public Constructors() {
		super();
		//this("defaultName", 7);

	}

	//constructors c= new constructor ("Genesis", 1)
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

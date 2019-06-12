package com.revature.modifiers;

public class AccessModifiers {
	/*
	 * Access modifiers 
	 * public - entity is accessible everywhere
	 * protected - entity is accessible within 
	 * 	 package AND its subclasses which may be 
	 *   in other packages 
	 * ___ (AKA default or package) - accessible 
	 *   within the package 
	 * private - only accessible within the class
	 *   it is declared in
	 */
	
	
	public int publicVar = 10;
	protected int protectedVar;
	int packageVar;
	private int privateVar;
	
	protected static int staticVar;
	
	protected void doesThings() {
		System.out.println("protected");
	}

}

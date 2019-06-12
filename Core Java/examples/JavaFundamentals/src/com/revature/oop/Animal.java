package com.revature.oop;

/*
 * Abstract classes in Java are classes that have 
 * the ABILITY to have abstract methods, and do not 
 * have the ability to be instantiated
 * 
 * In order to be abstract, 
 */
public abstract class Animal implements Livable{

	@Override
	public int reproduce() {
		return 0;
	}


}

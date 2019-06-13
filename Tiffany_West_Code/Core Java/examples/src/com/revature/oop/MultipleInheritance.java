package com.revature.oop;

public class MultipleInheritance {
	/*
	 * Multiple inheritance is the ability for a class to inherit 
	 * from multiple other classes. 
	 * Java does NOT support this. We can only extend at most 
	 * one class from another class
	 * 
	 * A common interview question is "what is a workaround for 
	 * multiple inheritance?" and that's the fact that we can 
	 * implement as many interfaces as we want. 
	 */
	public static void main(String[] args) {
		TestClass test = new TestClass();
		test.doThings();
	}

}

class TestClass implements I1, I2{

	@Override
	public void doThings() {
		I1.super.doThings();
		I2.super.doThings();
		System.out.println("Now that we can have method implementations in "
			+ "interfaces, if we implement two interfaces with default methods "
			+ "with the same name, we MUST override that method");
	}
	
}

interface I1{
	default void doThings() {
		System.out.println("doing things in interface one");
	}
}

interface I2{
	default void doThings() {
		System.out.println("doing things in interface two");
	}
}

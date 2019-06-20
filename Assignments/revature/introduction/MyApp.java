package com.revature.introduction;

public class MyApp {
	/*
	 * In this class, we will explore how to instantiate
	 * other classes and the differences between instance
	 * and static scoped fields
	 */
	public static void main(String[] args) {
		/*
		 * Using new keyword, we have just created an 
		 * instance of the ClassBasics class.
		 * The verb tense of this is instantiated
		 * 
		 * We see here that we call new ClassBasics(), meaning
		 * we are calling a constructore of the classs
		 * 
		 * However, we did not write a constructor! How does this 
		 * work?!
		 * 
		 * Every class has a default constructor until you 
		 * create one programaticallyy (code it)
		 * 
		 * default constructors
		 */
		ClassBasics myInstance = new ClassBasics();
		myInstance.InstanceVar = "This instance is myInstance";
		myInstance.staticVar = "this is a static variable from myInstance";
		
		ClassBasics secondInstance = new

	}

}

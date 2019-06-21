package com.revature.introduction;

public class MyApp {

	/*
	 * In this class, we will explore how to instantiate 
	 * other classes and the differences between instance 
	 * and static scoped fields
	 */

	public static void main(String[] args) {
		/*
		 * Using the new keyword, we have just created an 
		 * instance of the ClassBasics class.
		 * The verb tense of this is instantiated 
		 * 
		 * We see here that we call new ClassBasics(), meaning
		 * we are calling a constructor of the class 
		 * 
		 * However, we did not write a constructor! How does this
		 * work?!
		 * 
		 * Every class has a default constructor until you 
		 * create one programmatically (code it)
		 * 
		 * default constructors look as follows:
		 * 
		 * public ClassName(){
		 * 		super();
		 * }
		 * 
		 * super() calls the constructor of the class's
		 * superclass. As we know, unless our class manually 
		 * extends another class, its superclass is Object 
		 * 
		 * In order to instantiate a class, we must use 
		 * the new keyword with its constructor as we see below
		 */
		//CREATING INSTANCE 1
		ClassBasics myInstance = new ClassBasics();
		myInstance.instanceVar = "This instance is myInstance";
		myInstance.staticVar = "this is a static variable from myInstance";
		
		
		//CREATING NEW INSTANCE 2
		ClassBasics secondInstance = new ClassBasics();
		secondInstance.instanceVar = "this is our second instance";
		secondInstance.staticVar = "STATIC! NOT INSTANCE!";
		
		ClassBasics.staticVar = "We can access static fields directly from the class, "
				+ "instead of from the instance";
		//ClassBasics.instanceVar = "not accessible from the class, only from instance";
		
		System.out.println(myInstance.instanceVar);
		System.out.println(myInstance.staticVar);
		System.out.println(secondInstance.instanceVar);
		System.out.println(secondInstance.staticVar);
		
		ClassBasics.getCurrentTime();
		myInstance.notStatic();
		

	}

}

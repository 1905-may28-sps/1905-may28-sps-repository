package com.revature.introduction;

public class MyApp {

	/*
	 *  In this class, we will explore how to instantiate other classes and the difference between instance
	 *  and static scoped fields
	 */
	public static void main(String[] args) {
		         //CREATING INSTANCE 1
				ClassBasics myInstance = new ClassBasics();
				myInstance.instanceVar = "This  instance is myInstance";
				//myInstance.staticVar  = "this is a static variable from myInstance";
				
				//CREATING NEW INSTANCE 2
				ClassBasics secondInstance = new ClassBasics();
				secondInstance.instanceVar = "this is our second instance";
				secondInstance.staticVar = "STATIC!  NOT INSTANCE!";
				
				//this 
				//ClassBasics.staticVar = "We can access static fields directly from the class, "
					//+ "instead of from the instance";
				//ClassBasics.instanceVar = "not accessible from the class, only from instance";
				
				System.out.println(myInstance.instanceVar);
				System.out.println(myInstance.staticVar);
				System.out.println(secondInstance.instanceVar);
				System.out.println(secondInstance.staticVar);
				
				ClassBasics.getCurrentTime();
				myInstance.notStatic();
				
				
				
				
	}

}

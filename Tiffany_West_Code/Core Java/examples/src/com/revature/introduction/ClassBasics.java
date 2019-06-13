package com.revature.introduction; // package declaration

import java.time.LocalDateTime;
import java.time.LocalTime;

//here is where we put imports if we have any

public class ClassBasics {
	/*
	 * Typically, right after the class delcaration 
	 * we will see the declaration of our instance 
	 * and static variables. Instance and static 
	 * scoped variables are the only scope with 
	 * default values (method and block scoped 
	 * vars must be initialized to be used). 
	 * The default value of a variable depends on 
	 * its type
	 */
	
	String instanceVar;
	static String staticVar;
	int x;
	static int y;
	
	static {
		//this is weird right! this is known as a static initializer 
		//these blocks of code execute WHEN THE CLASS LOADS 
		//System.out.println("THIS IS A STATIC BLOCK");
	}
	
	{
		//System.out.println("THIS IS AN INSTANCE BLOCK~");
	}
	
	//[access mod] [non-access mod(s)] [return type*] [method name*]([params])
	public static void main(String[] args) {
		//getCurrentTime();
	
		
		/*
		 * In order to call instance methods/refer to instance 
		 * variables within static methods, we must create 
		 * an instance of the class within itself 
		 */
		ClassBasics cb = new ClassBasics();
		//cb.notStatic();

	}

	//this is an instance method, because it doesnt have the word static 
	public void notStatic() {
		System.out.println("This is not a static method, but "
				+ "an instance method. it can only be accessed "
				+ "with an instance of this class");
	}

	
	public static void getCurrentTime() {
	LocalDateTime currTime=  LocalDateTime.now();
	System.out.println(" It is  now " + currTime);
}

}

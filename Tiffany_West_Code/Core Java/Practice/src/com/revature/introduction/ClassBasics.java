package com.revature.introduction;

import java.time.LocalDateTime;

/*  here is where we'd put imports if we have any. 
 *  CTRL + SHIFT + O = shortcut to resolve imports  
 *  import statements allow us to leverage classes 
 *  in other packages without writing their fully
 *  qualified names 
 *  
 *  The only classes that we do not need to import 
 *  to use without referring to them by their full 
 *  names are classes WITHIN the same package that 
 *  the class you're writing is in, and classes 
 *  in the java.lang package such as String and System
 */
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
	
	/*
	 * Constructor(s) usually go after the variable declarations
	 */
	
	static {
		//this is weird right! this is known as a static initializer 
		//these blocks of code execute WHEN THE CLASS LOADS 
		System.out.println("THIS IS A STATIC BLOCK");
	}
	
	
	{
		System.out.println("THIS IS AN INSTANCE BLOCK~");
	}
	
	
	
	//[access mod] [non-access mod(s)] [return type*] [method name*]([params])
	public static void main(String[] args) {
		
		//we can call static methods from inside static methods 
		getCurrentTime();
		
		/*
		 * In order to call instance methods/refer to instance  variables within static methods, we must create 
		 * an instance of the class within itself 
		 */
		
		ClassBasics cb = new ClassBasics();
		cb.notStatic();
		
	}
	
	//this is an instance method, because it doesn't have the word static 
	public void notStatic() {
		System.out.println("This is not a static method, but an instance method. it can only be accessed with an instance of this class");
	}
	
	//this is a static method 
	public static void getCurrentTime() {
		
		
		
		//if we DO import, we can just say 
		LocalDateTime currTime = LocalDateTime.now();
		 
		System.out.println("IT IS NOW " + currTime);
	}
	
	/*
	 * Classes can also have nested classes
	 */
	
}

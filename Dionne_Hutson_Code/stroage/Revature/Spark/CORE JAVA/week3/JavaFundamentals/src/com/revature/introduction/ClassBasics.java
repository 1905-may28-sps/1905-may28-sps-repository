package com.revature.introduction;

/*
 * here is for imports
 */

import java.time.LocalDateTime;

		
public class ClassBasics {
	/*
		 * Ster the class declartion we will see the declaration of our instance and static variables. instance
		 */
		String instanceVar;//object scope they are uniques tothe instance instances are objects of a class so the instance variables are objet scope
		static String staticVar;//class scope, these are shared within the class
		int x;
		static int y;//static lets you do things without creating an instance
		static {//static intializeer theseblock of code executes when the class load
			System.out.println("This is a static block");}
		
		{System.out.println("This is an instance block, it executes when the instance is created");}
	public static void main(String[] args) {
		getCurrentTime();
		//cannot call instance variable of methods from class unless you make an instance
		ClassBasics cb=new ClassBasics();//instantiating class basics within the class
		
	}
	void notStatic() {//this is an instance method
		System.out.println("this is not a staic feild, it is only acessible via the class");
	}
	public static void getCurrentTime() {
		//local date time is the classname
		//java.time .LocalDateTime, if not import statement is used
		LocalDateTime currTime= LocalDateTime.now();//did not create an instance of local date time with new ()
		System.out.println("It is now "+currTime);
		
	}

}

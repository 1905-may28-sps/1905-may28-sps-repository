//the package declaration is the first line of any Java class
package com.revature.introduction;

//class delcaration 
//[access Mod] [non-access Mod(s)] class [className]{}
public class HelloWorld {

	/*
	 * This is our main method 
	 * The main method is the starting point of any 
	 * non-web Java application. In order to start 
	 * a thread of execution, we must start here. 
	 * 
	 * The main method is always public and static 
	 * with a void return type (does not return anything)
	 * It must always be called main 
	 * It also must always take in a String array of params
	 * However, the array does not have to be called args, 
	 * and it can use something called varags (to be discussed later)
	 */
	public static void main(String arguments[]) {
		//This prints text out in the console on a new line 
		//In Java, we must use double quotes for strings
		System.out.println("Hello World");
		
		for(String str : arguments) {
			//println = print+"\n"
			System.out.print(str+"\n");
		}
		
		doesThings();
	}
	
	static void doesThings() {
		System.out.println("this does things");
		System.out.println("doing more things");
	}

}

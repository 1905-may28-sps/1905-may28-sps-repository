//package declartion
package com.revature.introduction;
//class declaration
//[acess modifier][non acess mods] class [className]{}
public class HelloWorld {
	/*
	 * This is our main method
	 * The main method is the starting point of any non web java application
	 * to start a thread of execution we must start here.
	 */
// add to run configuation to give it meaningful functionality
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello, World!");
		for(String str:args) {
			System.out.println(str+"\n");
		}
	}

}

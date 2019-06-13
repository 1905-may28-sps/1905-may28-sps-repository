//the package declaration is the first line of any Java class
package com.revature.introduction;


//class declaration
//[access Mod] [non-access Mod(s)} class [class name]{}
public class HelloWorld {

	
	/*
	 *  this is our main method
	 *  the main method is the starting point of any
	 */
	public static void main(String[] args) {

		System.out.println("Hello world !!!");
		
		for(String str : args) {
			System.out.println(str);
		}
		
						doesThings();
		}
	static void doesThings() {
		System.out.println("this does things");
	}

}

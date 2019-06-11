package com.revature.introduction; //1st line == package declaration

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
import java.time.*;

public class ClassBasics {
	
	public static void main(String[] args) {
		getCurrentTime();
	}
	
	public static void getCurrentTime() {
		/*if we dont import java.time.LocalDataTime above we 
		/  have to refer to the class as follows
		/ java.time.LocalDateTime currTime = java.time.LocalDateTime.now();
		*/
		//if we DO import, we can just say 
		LocalDateTime currTime = LocalDateTime.now();
		System.out.println("IT IS NOW " + currTime);
	}
	
}

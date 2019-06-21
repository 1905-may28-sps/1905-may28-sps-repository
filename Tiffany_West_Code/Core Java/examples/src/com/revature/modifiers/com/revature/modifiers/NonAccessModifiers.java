package com.revature.modifiers;

public class NonAccessModifiers {

	
	
	
	/*
	 * In Java, we have a lot of reserved keywords, some of these are modifiers
	 * which give whatever we are modifying certain traits 
	 * we have explored access mods, here are some non acces mods 
	 * 
	 * 
	 * some that you will need to know - 
	 * final 
	 * static 
	 * transient -- instance variable not to be serialized 
	 * synchronized -- only one thread can access at a time 
	 * default -- allows us to give method implementation in interfaces
	 */
	
	/*
	 * FINAL - think not meant to be changed
	 * final variables cannot reassign them
	 * final methods cannot be OVERRIDEN, BUT THEY CAN BE OVERLOADED
	 * final classes cannot be extended
	 */
	
	public final static void testFinal() {
		final int x;
		x = 5;
		//x = 10; //will not work
	}
	
	public static void testFinal(int a) {
		System.out.println("Here, we are overloading testFinal, which is fine "
				+ "even though it is a final method ");
	}


}

final class finalClass{
	void test() {
		
	}
}

//class testFinalClass extends finalClass{
//	
//}

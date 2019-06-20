package com.revature.introduction;

public class UnderstandingStrings {
	
	public static void main(String[]args) {
		String str = "hello";
		String str2 = "hello";
		String str3 = new String("hello");
		System.out.println(str == str3); //false
		/*
		 * object class has a .equals() method 
		 * which would look like obj1.equals(obj2)
		 * the object class implementation just
		 * returns the output of ==, which returns
		 * true if the two object references refer
		 */
		System.out.println(str.equals(str3));
		
	}
}


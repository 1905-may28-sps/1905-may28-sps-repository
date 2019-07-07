package com.revature.string;

public class UnderstandingStrings {
	public static void main(String[] args) {
		
		String str="hello";
		String str2="hello";
		String str3=new String("hello");
		System.out.println(str==str3);
		/*
		 * object class has a .equals() method 
		 * obj1.equals(obj2)
		 * the object class implemenation just returns the output of ==
		 * which returns true if the two object refrences refers to th esame exact object in memoery, not just for coteent equality
		 * but the string class overrides the equals methd so that it tests for the equality of the ontent, not just the location in memory
		 */
		System.out.println(str.equals(str3));
		
	}

}

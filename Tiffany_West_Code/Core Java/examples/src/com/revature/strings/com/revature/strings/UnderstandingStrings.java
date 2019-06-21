package com.revature.strings;

public class UnderstandingStrings {

	public static void main(String[] args) {
		String str = "hello";
		String  str2 = "hello";
		String str3 = new String ("hello");
		System.out.println(str == str2);
		//this makes a new java string in pool so it's not pointing to the same thing
		System.out.println(str == str3);
		
		//you can override with the .equal supermethod
		System.out.println(str.equals(str));
		
		String str4 = "Hello";
		//ignore case will be true
		System.out.println(str.equalsIgnoreCase(str4));
		
	}
}

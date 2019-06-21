package com.revature.strings;

public class MutableStrings {

	/*
	 * immutable - once created, cannot be changed 
	 * 
	 * Strings are immutable but two mutable solutions to this exist:
	 * - StringBuilder 
	 * - StringBuffer(rarely used, slower than stringbuilder, but thread safe)
	 */
	
	public static void main(String[] args) {
		String a = "hello";
		a = new String("hi").concat(" world!").concat(" test");
		System.out.println(a);
		
		StringBuilder sb = new StringBuilder("hello");
		//StringBuilder sb2 = "hi"; //will not work 
		
		sb.append(" world");
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
		
		StringBuffer sb2 = new StringBuffer("test");
		sb2.append("testing");
	}
}

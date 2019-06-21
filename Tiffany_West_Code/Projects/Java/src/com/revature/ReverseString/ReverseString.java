package com.revature.ReverseString;

public class ReverseString {

	public static void main(String[] args) {
			
		stringReverse("String Reverse");
	}

	private static void stringReverse(String str) {
		
		
		String reverse = " ";
		
		for (int i = str.length() - 1; i >= 0; i--) {
			reverse = reverse + str.charAt(i);
		}

		System.out.println( reverse);
	}
	
	

}

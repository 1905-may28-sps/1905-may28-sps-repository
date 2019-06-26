package com.revature.strings;

public class StringCodingChallenges {

	
	/*
	 * write a method that takes in a string and returns a boolean value true if it is a 
	 * palindrone and a boolean value false if it is not
	 */
	public static boolean isPalidrone(String Str) {
		for (int i =0; i< Str.length()/2; i++) {
			String letter = "" + Str.charAt(i);
			String Bletter = "" + Str.charAt(Str.length()-i-1);
			if(letter.equalsIgnoreCase(Bletter)) {
					return true;
			}	
		}
		return false;
	
	}
	
	
}
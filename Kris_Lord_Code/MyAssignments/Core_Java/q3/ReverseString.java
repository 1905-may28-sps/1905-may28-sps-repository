package com.revature.q3;

public class ReverseString {

	public static void main(String[] args) {
		
		String str = "Does this look alright?";
		for(int i=0;i<str.length();i++) {//str.length() for strings
			System.out.print(str.charAt(str.length()-1-i));/*must
			include -1 in str.length() because indexing string begins
			at index 0 and ends at index length of string - 1.*/
		}

	}

}

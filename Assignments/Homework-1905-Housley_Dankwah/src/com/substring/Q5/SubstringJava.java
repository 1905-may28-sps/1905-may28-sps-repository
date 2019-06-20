package com.substring.Q5;

/*	Q5. Write a substring method that accepts a string str and an integer idx 
	and returns the substring contained between 0 and idx-1 inclusive. 
	Do NOT use any of the existing substring methods in the String, StringBuilder, 
	or StringBuffer APIs.
*/

public class SubstringJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubstringIdx("I love food", 7);

	}

	public static void SubstringIdx(String str, int end) {

		char[] str2 = str.toCharArray();

		for (int i = 0; i < end + 1; i++) {
			System.out.print(str2[i]);
		}

	}

}

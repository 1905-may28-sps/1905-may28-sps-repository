package com.reverseString.Q3;

//Q3. Reverse a string without using a temporary variable. Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.

public class ReverseStringJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StringReverse("house");

	}

	public static void StringReverse(String str) {

		String reverse = " ";

		for (int i = str.length() - 1; i >= 0; i--) {
			reverse = reverse + str.charAt(i);
		}

		System.out.println("Reversed of " + str + " is = " + reverse);
	}

}

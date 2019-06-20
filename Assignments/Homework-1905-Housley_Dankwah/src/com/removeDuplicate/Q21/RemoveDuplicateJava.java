package com.removeDuplicate.Q21;

// Q.21. Write a method to remove all repeated characters in a string.

public class RemoveDuplicateJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		removeDup("SSongs");

	}

	private static void removeDup(String str) {

		String removedDupStr = "";

		for (int i = 0; i < str.length(); i++) {
			int count = 1;

			for (int j = i + 1; j < str.length(); j++) {
				if (str.toLowerCase().charAt(i) == str.toLowerCase().charAt(j)) {
					count++;
				}
			}
			if (count == 1) {
				 removedDupStr += str.charAt(i);
			}
		}
		System.out.println(removedDupStr);
	}

}

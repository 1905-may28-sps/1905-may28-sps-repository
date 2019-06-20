package com.revature.hw;

import java.util.Scanner;

public class ReverseWord {
//need to get user input so use scanner?
	
	private static Scanner myObj;



	private static String Word() {
		myObj = new Scanner(System.in);
	    System.out.println("Please enter a word you would like to reverse: ");

	    String words = myObj.nextLine();  // Read user input
		return words;
	}
	
	
	
	public static void main(String[] args) {
		String fWord = Word();
		
		for (int i = fWord.length()-1; i>=0; i--) {
			System.out.print(fWord.charAt(i));	
		}
	}
}

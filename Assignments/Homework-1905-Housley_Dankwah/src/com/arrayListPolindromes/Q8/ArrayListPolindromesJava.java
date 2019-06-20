package com.arrayListPolindromes.Q8;

/*	Q8. Write a program that stores the following strings in an ArrayList and 
saves all the palindromes in another ArrayList.
“karan”, “madam”, ”tom”, “civic”, “radar”, “sexes”, “jimmy”, “kayak”, “john”, 
“refer”, “billy”, “did”

*/

import java.util.ArrayList;

public class ArrayListPolindromesJava {
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		polindrome();

	}
	
	public static void polindrome() {
		ArrayList<String>arrlist = new ArrayList<String>(10);
		ArrayList<String>palindromeArrlist = new ArrayList<String>(10);
		arrlist.add("karan");
		arrlist.add("madam");
		arrlist.add("tom");
		arrlist.add("civic");
		arrlist.add("radar");
		arrlist.add("sexes");
		arrlist.add("jimmy");
		arrlist.add("kayak");
		arrlist.add("john");
		arrlist.add("refer");
		arrlist.add("billy");
		arrlist.add("did");
		
		for (String name : arrlist) {
			StringBuilder newName = new StringBuilder(name);
			if (name.equals(newName.reverse().toString())) {
				System.out.println(name + " reverses to = " + newName.reverse().toString() + " so its a palindrome" );
				palindromeArrlist.add(name);
			} else {
				System.out.println(name + " is not a palindrome");
			}

		}
		System.out.println("The Palindrome words are " + palindromeArrlist);
		
	}

}

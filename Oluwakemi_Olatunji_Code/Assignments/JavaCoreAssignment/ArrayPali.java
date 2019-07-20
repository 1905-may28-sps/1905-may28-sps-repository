package Assignements;

import java.util.ArrayList;

public class ArrayPali {

	public static void main(String[] args) {
		ArrayList<String> myList = new ArrayList<String>();
		ArrayList<String> yesPalindromes = new ArrayList<String>();
		ArrayList<String> notPalindromes = new ArrayList<String>();
		myList.add("karan");
		myList.add("madam");
		myList.add("tom");
		myList.add("civic");
		myList.add("radar");
		myList.add("sexes");
		myList.add("jimmy");
		myList.add("kayak");
		myList.add("john");
		myList.add("refer");
		myList.add("billy");
		myList.add("did");

		for (String palindromes : myList) {
			boolean palindrome = isPalindrome(palindromes);
			// Palindrome?
			if (palindrome) {
				yesPalindromes.add(palindromes);
			} else {
				notPalindromes.add(palindromes);
			}
		}
		System.out.println("Original List: ");
		System.out.println(myList);
		System.out.println("Palindrome list: ");
		System.out.print(yesPalindromes);
	}

	public static boolean isPalindrome(String value) {
		if (value == null || value.isEmpty())
			return false;
		// reverse and compares =
		return new StringBuilder(value).reverse().toString().equals(value);
	}
}

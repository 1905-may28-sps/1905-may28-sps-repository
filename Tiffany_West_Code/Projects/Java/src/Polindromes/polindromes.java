package Polindromes;

import java.util.ArrayList;

public class polindromes {

	public static void main(String[] args) {
		polindrome();
	}

	private static void polindrome() {
		
		ArrayList<String>words = new ArrayList<String>(10);
		ArrayList<String>palindromes = new ArrayList<String>(10);
		
		words.add("karan");
		words.add("madam");
		words.add("tom");
		words.add("civic");
		words.add("radar");
		words.add("sexes");
		words.add("jimmy");
		words.add("kayak");
		words.add("john");
		words.add("refer");
		words.add("billy");
		words.add("did");
		
		for (String word : words) {
			StringBuilder newName = new StringBuilder(word);
			if (word.equals(newName.reverse().toString())) {
				palindromes.add(word);
			} else {
				
			}

		}
		System.out.println("Palindromes: " + palindromes);
	}

}

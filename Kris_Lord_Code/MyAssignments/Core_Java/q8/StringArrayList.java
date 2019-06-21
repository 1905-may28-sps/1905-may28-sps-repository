package com.revature.q8;

import java.util.ArrayList;

public class StringArrayList {
	
	public static ArrayList<String> words = new ArrayList<String>();
	
	public static void storeArrayList() {
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
		System.out.println(words);
	}
	
	public static void getPalindromeWord() {
		for(int i=0; i<words.size(); i++) {
			String word = words.get(i);
			String wordReversed = new StringBuilder(word).reverse().toString();

		    if (word.equals(wordReversed)) {
		      System.out.println(words.get(i));
		    }
		    else {
		      System.out.print("");
		    }
		}
	}
	
	public static void main(String[] args) {
		storeArrayList();
		getPalindromeWord();

	}

}

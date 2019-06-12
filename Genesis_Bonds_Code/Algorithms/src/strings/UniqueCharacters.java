package strings;

import java.util.HashSet;
import java.util.Set;

public class UniqueCharacters {
	
	public static void main(String[] args) {
		System.out.println(noStructures("abcd "));
	}
	
	//implement an algorithm to determine if a string has all unique characters 
	static boolean unique(String str) {
		Set<Character> letters = new HashSet<Character>();
		for(int i = 0; i < str.length(); i++) {
			letters.add(str.charAt(i));
		}
		if(letters.size() == str.length()) return true;
		return false;
	}
	
	//what if you can not use additional data structures
	
	/*
	 * good to make sure you ask about the charset. in this example
	 * just letters? spaces included? case sensitive strings? 
	 * is it ok to assume any char in the ascii set? 
	 * 
	 * complexity O(n)
	 */
	static boolean noStructures(String str) {
		int[] count = new int[256];
		for(int i = 0; i < str.length(); i++){
			int ascii = (int) str.charAt(i);
			if(++count[ascii] > 1) return false;
		}
		
		return true;
	}

}

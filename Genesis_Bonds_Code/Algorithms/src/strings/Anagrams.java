package strings;

import java.util.ArrayList;

public class Anagrams {
	/*
	 * Write a method to determine if two strings are anagrams or not 
	 */
	
	public static void main(String[] args) {
		System.out.println(anagram("cbat", "tabc"));
	}
	
	
	static boolean anagram(String s1, String s2) {
		if(s1.length()!=s2.length()) { return false;}
		
		ArrayList<Character> letters = new ArrayList<Character>();
		for(int i = 0; i < s1.length(); i++) {
			letters.add(s1.charAt(i));
		}
		for(int i = 0; i < s2.length(); i++) {
			Character curr = s2.charAt(i);
			
			if(!letters.contains(curr)) return false;
			else { 
				letters.remove(curr);
			}
		}
		if(letters.isEmpty()) return true;
		else return false;
	}
	
	
	/*
	 * Book suggests either sorting the strings and comparing them 
	 * or to check if the two strings have identical counts for each 
	 * unique character 
	 *  - the second solution is done without hashmapes but instead 
	 *  uses a char array of 256 chars (assuming chars used will be 
	 *  one of the 256 ascii chars) and increments them based on count 
	 *  from the first string and adds to a var of unique characters.
	 *  then iterates through char in the second
	 *  string, immediately returns false if an expected char has a count 
	 *  of 0; else subtracts one from count until 0, and adds 1 to int 
	 *  var num completed. then compares num completed and num unique chars
	 *  to see if strings are anagrams. i would have used the same var 
	 *  and just subtracted 1 every time a character was completely accounted
	 *  for but alas. 
	 */

}

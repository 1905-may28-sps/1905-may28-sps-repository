package com.revature.junit;

import java.util.ArrayList;

public class Methods {
	
	int counter;
	
	public int add(int... nums) {
		int sum = 0;
		for(int n : nums) {
			sum+=n;
		}
		return sum;
	}
	
	public boolean anagram(String a, String b) {
		if(a.length()!=b.length()) return false;
		ArrayList<Character> aChars = new ArrayList<Character>();
		for(int i = 0 ; i < a.length(); i++) {
			aChars.add(a.charAt(i));
		}
		
		for(int i = 0; i < b.length(); i++) {
			int index = aChars.indexOf(b.charAt(i));
			if(index < 0) {
				return false;
			}
			else {
				aChars.remove(index);
			}
		}
		
		if(aChars.size()==0) return true;
		return false;
	}

}

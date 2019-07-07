package com.revature.string;

public class StringCodingChallenges {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		boolean x=isPalindrome("race");
		System.out.println(x);

	}
	
	public static boolean isPalindrome(String str) {
		boolean out=false;
		for (int i=0;i<str.length()/2;i++) {
			if(str.charAt(i)==str.charAt(str.length()-1)) {
				out=true;
			}
		}
			
	return out;	
	}
}



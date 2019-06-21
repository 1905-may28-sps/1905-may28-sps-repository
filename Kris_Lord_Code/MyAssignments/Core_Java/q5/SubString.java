package com.revature.q5;

public class SubString {
	
	public static void SubStringMethod(String str) {
		int idx = str.length()/2;/*to always stay within string,
		chose idx to be half of the string length.*/
		for(int i=0;i<=idx-1;i++) {
			System.out.print(str.charAt(i));
		}
		
	}

	public static void main(String[] args) {

		SubStringMethod("74893207");
	}

}

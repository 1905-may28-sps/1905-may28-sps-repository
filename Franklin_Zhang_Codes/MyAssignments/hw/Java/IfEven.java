package com.revature.hw;

public class IfEven {
	//to check if they are even.
	//if the num entered is even it will equal itself since integers 
	//can only display whole numbers when divided.
	
	static String ifEven(int num) {
		String result ="odd";
		if ((num/2)*2 == num) {
			result="even";
		}
		return result;
	}
	public static void main(String[] args) {
		int x = 0;
		String ans=ifEven(x);
		System.out.println(ans);
	}	
}

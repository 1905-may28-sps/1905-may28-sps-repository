package com.revature.hw;

public class IfEven {
	//to check if they are even.
	//if the num entered is even it will equal itself since integers 
	//can only display whole numbers when divided.
	
	static boolean ifEven(int num) {
		return ((num/2)*2 == num);
	}
	public static void main(String[] args) {
		int num=5;
		if (ifEven(num)==true) {
			System.out.println("even");
		}
		else
			System.out.println("Not even");
	}	
}

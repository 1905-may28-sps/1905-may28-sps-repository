package com.ternaryOperator.Q10;

//Q10. Find the minimum of two numbers using ternary operators.

public class TernaryOperatorsJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TernaryOfTwo(200, 100);

	}
	
	public static void TernaryOfTwo(int a, int b) {
		
		int minimum = (a < b) ? a : b;
		System.out.println(minimum + " is the minimum of " + a + " and " + b);
	}

}

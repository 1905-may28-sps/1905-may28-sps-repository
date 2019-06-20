package com.nFactorial.Q4;

//Q4. Write a program to compute N factorial.

public class NFactorialProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	nFact(10);
	}
	
	public static void nFact(int num) {
		int factorial = 1;
		int i = 1;
		
		for (i= 1; i <=num; i++) {
			
			factorial = factorial*i;
			
		}
		
		System.out.println("Facotorial of  " + num + " is " + factorial );
	}
	
	
}

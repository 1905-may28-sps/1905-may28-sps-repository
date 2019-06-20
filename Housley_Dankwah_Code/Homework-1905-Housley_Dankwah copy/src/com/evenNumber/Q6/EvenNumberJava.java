package com.evenNumber.Q6;

//Q6. Write a program to determine if an integer is even without using the modulus operator (%)


public class EvenNumberJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		evenNumCheck(10);

	}
	public static void evenNumCheck(int num) {
		int value = num / 2;
		System.out.println(num/2);
		System.out.println(value*2);
		if (value * 2 == num) {
			System.out.println( num + " is an even number");

		} else {
			System.out.println(num + " is  an odd number");
		}
	}


}

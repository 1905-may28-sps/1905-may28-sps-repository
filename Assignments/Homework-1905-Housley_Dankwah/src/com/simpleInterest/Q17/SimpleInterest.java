package com.simpleInterest.Q17;

/*	Q17. Write a program that calculates the simple interest on the principal, 
	rate of interest and number of years provided by the user. Enter principal, 
	rate and time through the console using the Scanner class.
	Interest = Principal* Rate* Time
*/

import java.util.Scanner;

public class SimpleInterest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalInterest();
		

	}
	
	public static void CalInterest() {
		Scanner scanner = new Scanner(System.in);

		
		System.out.println("What amount of money is loaned or borrowed? (this is the principal amount)");
		double principle = scanner.nextDouble();
		System.out.println("What is the interest rate (in percent) attached to this money?");

		double rate = (scanner.nextDouble()/100);
		System.out.println(rate);

		System.out.println("After how much time do you want to know what your interest will be?");
		double time = scanner.nextDouble();
		
		
		
		
		double interest = principle * rate * time;
		
		System.out.println("The simple interest of a principle of : " + principle + " at a Rate of : "+ rate + 
				"% over " + time + " years is : " + interest);
		
	}

}

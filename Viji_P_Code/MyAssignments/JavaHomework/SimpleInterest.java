package homework;

import java.util.Scanner;

/*
 * Q17: Write a program that calculates the simple interest on the 
 * principal, rate of interest and number of years provided
 * by the user. Enter principal, rate and time through the console using 
 * the Scanner class.
 */
public class SimpleInterest {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Principal Amount: ");
		double principal = scan.nextDouble();
		System.out.println("Enter Rate of Interest: ");
		double interestRate = scan.nextDouble();
		System.out.println("Enter Number os Years: ");
		int year = scan.nextInt();
		
		double simpleInterest = 1.00;
		simpleInterest = (principal * interestRate * year)/100;
		System.out.println("Simple Interest is: " + simpleInterest);

	}

}

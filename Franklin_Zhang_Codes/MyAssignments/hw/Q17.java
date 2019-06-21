package com.revature.hw;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Q17.Write a program that calculates the simple interest on the principal, 
 * rate of interest and  number  of  years  provided  by  the  user.  
 * Enter  principal,  rate  and  time * through  the console using the Scanner class.
 * Interest = Principal* Rate* Time
 */
public class Q17 {
	
	public static Double Principal() {
		//try {
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Please enter your Principal amount: ");
	    String stringNum = myObj.nextLine();  // Read user input
	    Double prin = Double.valueOf(stringNum);
	    return prin;
		//}catch(NumberFormatException e){
	    //    System.out.println("Your input is invalid, please try again!");
	    //    Principal();
		//}
	}
	
	public static Double Rate() {
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Please enter what %: ");
	    String stringNum = myObj.nextLine();  // Read user input
	    Double rate = Double.valueOf(stringNum);
	    return rate;   
	}
	public static Integer Years() {
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Please enter Years: ");
	    String stringNum = myObj.nextLine();  // Read user input
	    Integer yr = Integer.valueOf(stringNum);
	    return yr;
	}
	
	public static void main(String[] args) {
		try {
		double prin=Principal();
		double rate=Rate()/100;
		int yr=Years();
		double x= simpInte(prin, rate, yr);
		System.out.println(x);
		}
		catch (NumberFormatException e) {
			System.out.println("Your input is invalid, terminating program!");
		}
	}

	
	public static double simpInte(double pri, double rate, int yr) {
				
		double interest=(double) (pri*rate*yr);
		return interest;
		}
}	
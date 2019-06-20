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
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Please enter your Principal amount: ");
	    String stringNum = myObj.nextLine();  // Read user input
	    Double prin = Double.valueOf(stringNum);
	    return prin;
	}
	
	public static Float Rate() {
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Please enter what %: ");
	    String stringNum = myObj.nextLine();  // Read user input
	    Float rate = Float.valueOf(stringNum+"f");
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
		
		//try to see if user enters valid entries, if any incorrect entry
		try {
		double prin=Principal();
		float rate=Rate()/100;
		int yr=Years();
		float interest = (float) (prin*rate*yr);
		System.out.println("Your interest is: "+interest);
		}
		//does not let user continue if enter invalid
		catch(NumberFormatException e){
	        System.out.println("Your input is invalid, please try again!");
		}
		
	}
	  
	    
	
	

}

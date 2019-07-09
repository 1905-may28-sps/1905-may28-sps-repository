package com.revature.hw;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

//switch case
public class Q14 {
	//call on function that asks user to enter in a number between 1 -3
	private static Integer idx() {
		Scanner myObj1 = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("What would you like to do?");
	    System.out.println("Select 1 to find the square root of 555");
	    System.out.println("Select 2 to check the time and date");
	    System.out.println("Select 3 To move characters in a sentence into an array");
	    String stringNum = myObj1.nextLine();  // Read user input
	    Integer num = Integer.valueOf(stringNum);
	    return num;
	}
	
	
	
	public static void main(String[] args) {
		
		//scanner to get user input
		
		int userChoice=idx();
		switch(userChoice) {
		case 1:
			// Find the square root of a number using the Math class method.
			sqreRoot();
			break;
		case 2:
			//Display today’s date.
			display2Day();
			
			break;
		case 3:
			//Split the following string and store it in a sting array. “I am learning Core Java”
			stringSplit();
			
			break;
		default: System.out.println("Invalid Entry, Goodbye");
			
		}
		
	}

	private static void stringSplit() {
		String str= "I am learning Core Java";
		String strArray[] = str.split("");
		System.out.println(Arrays.toString(strArray));
		
	}

	private static void display2Day() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate localDate = LocalDate.now();
		System.out.println(dtf.format(localDate));
		
	}

	private static void sqreRoot() {
		float x=555;
		System.out.println("Math.sqrt(" + x + ")=" + Math.sqrt(x));
		
	}
	
	

}

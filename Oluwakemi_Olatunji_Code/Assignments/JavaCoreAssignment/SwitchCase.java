package Assignements;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class SwitchCase {
	
//	Write a program that demonstrates the switch case. Implement the following
//	functionalities in the cases:
//	Case 1: Find the square root of a number using the Math class method.
//	Case 2: Display today’s date.
//	Case 3: Split the following string and store it in a sting array.
//	“I am learning Core Java
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Hello, what's your name?");
		
		String name = scan.nextLine();

		System.out.println("Hey, " + name+ "!"); 
		menu();
	}
	static void menu() {
		System.out.println("What would you like to do today?"
				+ "You can \n"
				+ "1. Find the square root of a number using the Math class method.  \n"
				+ "2. Display today’s date. \n"
				+ "3. Split the following string and store it in a sting array."
				+ "'I am learning Core Java'");
		String option = scan.nextLine();
		switch(option) {
		case "1": squareRoot(); break;
		case "2": displayDate(); break;
		case "3": stringArray(); break;
		default:
			System.out.println("Please pick 1,2, or 3!");
			menu();	
		
		}
	}
	static void squareRoot() {
		System.out.print("Please enter the number you would "
    			+ "like to find out the Square Root of: ");
    	int i = scan.nextInt();//taking in user inputs
    	System.out.println(Math.sqrt(i));

	}
	static void displayDate() {
		 DateFormat dateFormat = new SimpleDateFormat("MMMM dd yyyy");
		 java.util.Date date = new java.util.Date();
		 System.out.println("Current Date : " + dateFormat.format(date));
	
	}
	
	static void stringArray() {
		String printString="I am learning Core Java";  
    	String[] words=printString.split("\\s");
    	for(String storeString:words){  
    	System.out.println(storeString);  
    	} 
	}
}


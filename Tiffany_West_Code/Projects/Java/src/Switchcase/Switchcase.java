package Switchcase;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Switchcase {

	/*
	Q14. Write a program that demonstrates the switch case. Implement the following functionalities in the cases:
		Case 1: Find the square root of a number using the Math class method. 
		Case 2: Display today’s date.
		Case 3: Split the following string and store it in a sting array.

		“I am learning Core Java”
	*/
	
	public static void main(String[] args) {
		
		
		Switch();
	}
	
	static void Switch() {
		
		
		try {
			Scanner scan = new Scanner(System.in);

			System.out.println("which would you like to do?");
				String option = scan.nextLine(); // i think we'll have to chance the string input to an int
			 //int option = scan.nextInt(); 
				
				switch (option) {
				case "square": //change these to the methods
					square();
					System.out.println("square root is done: " );
					break;
				case "date":
					date();
					System.out.println("date is  done: ");
					break;
				case "split":
					split();
					System.out.println("string split done: ");
					break;
					default:
						System.out.println("please enter a response");
						Switch();
						
				}
		 }
		 catch(InputMismatchException e) {
			 System.out.println("caught exception ");
			 
		 }
		 finally {
			 System.out.println("thank you ");
		 }
}

	 static void  square() {
		 
		 Scanner squareNum = new Scanner (System.in);
		 System.out.println("enter a  number: ");
		 int num = squareNum.nextInt();
	        System.out.println(Math.sqrt(num)); 

		
		 
	 }
	 
	 static void date() {
		
		 Scanner date = new Scanner (System.in);
		 LocalDateTime currTime = LocalDateTime.now();
		 System.out.println("The date and time now : "+ currTime);
		 
		 
		 
	 }
	 
	 static void split() {
		 String split = "I am learning Core Java ";
	        char[] t = split.toCharArray();

	        for(char c : t)
	            System.out.println(c);    

	     
	 }
	 
	
	 
	 

	}
	
	


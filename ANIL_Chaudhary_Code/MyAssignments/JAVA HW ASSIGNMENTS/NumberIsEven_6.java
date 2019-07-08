package javaAssignments;

import java.util.Scanner;

public class NumberIsEven_6 {
	
	public static void main(String[] args) {
			
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter a number: ");
		int number = reader.nextInt(); // Scans the next token of the input as an int.
		//once finished
		reader.close();
		
		int quotient = number/2;
		if(quotient*2== number)
		{ System.out.println("Result: " + number + " is Even number"); }
		else{ 
			System.out.println("Result: " + number + " is Odd number"); } 
		} 
}


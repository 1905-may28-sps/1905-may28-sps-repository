package com.billy.factorial;
import java.util.Scanner;

public class Factorial {
	//a number that is multiplied by its previous number until
	//it reaches 1
	
	//Factorial of n! = n*(n-1) * (n-1)...
	
	public static void main(String[] args) {
		int input;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter number to find its factorial");
		input = in.nextInt();
		int facto = input;
		
		for(int i = (input - 1); i > 1; i--) {
	         facto = facto * i;
	      } 
	      System.out.println("Factorial of " + input +" is " + facto);
		
		
	}
	
	

}

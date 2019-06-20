// Write a program to compute N factorial.

package javaAssignments;

import java.util.Scanner;

public class Factorial_4 {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in); 
		System.out.println("Enter a number to find its factorial: ");
		int number = reader.nextInt(); 
		reader.close();
			
						int i,fact=1;
				  
		for(i=1;i<=number;i++){
		fact=fact*i;
		}
		System.out.println("The Factorial of "+number+" is: "+fact);
	}

}

package homework;

//Q6. Write a program to determine if an integer is even without using the modulus operator (%) 

import java.util.Scanner;

public class FindEvenNumbers {

	public static void main(String[] args) {
	
		System.out.println("Finding Even Numbers without using % Operator");
		System.out.println("Enter Number: ");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		if ((num/2) * 2 == num) {
			System.out.println("Even");
			}
		else
			System.out.println("Odd");
		}
}

package homework;

import java.util.Scanner;
//Write a program to compute N factorial.
//4! means 4*3*2*1 = 24, n*n-1

public class Factorial {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Enter Number: ");
		int fact = 1;
		int num = scan.nextInt();
		if (num == 0) {
			System.out.println("Factorial of 0 is : " + fact);
		}
		else
		{
		for (int i = 1; i<=num; i++) {
			fact = num*(num-1);
			}
			System.out.println("Factorial of " + num + " is : " + fact);
		}
	}
}
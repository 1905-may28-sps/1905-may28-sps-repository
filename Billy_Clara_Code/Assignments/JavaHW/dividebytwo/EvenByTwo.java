package com.billy.dividebytwo;
import java.util.Scanner;
public class EvenByTwo {
	
	public static void main(String[] args) {
		
		//A way to find if a number is divisible by two without using
		//the modulus operator
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a whole number to see if it is even or not.");
		int even = in.nextInt();
		
		if(even /2 * 2 == even) {
			System.out.println("The number is Even");
		} else {
			System.out.println("The number is not even");
		}
	}

}

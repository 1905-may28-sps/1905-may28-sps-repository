package com.revature.hw;
//q2 Write a program to display the first 25 Fibonacci numbersbeginning at 0
public class First25Fib {
	public static void main(String[] args) {
		//create needed variables
		int i=0, a = 0, b = 1;
		//as we cant create the first one, hard coded it in
		System.out.print("0 ");
		for (i=0; i<25; i++) {
			// begin replacing, and printing
			int temp = b;
			b=b+a;
			a=temp;
			System.out.print(a+" ");
		}
	}
}

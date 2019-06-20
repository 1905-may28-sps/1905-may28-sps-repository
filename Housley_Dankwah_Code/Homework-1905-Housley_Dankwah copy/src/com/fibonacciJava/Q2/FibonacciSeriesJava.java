package com.fibonacciJava.Q2;

//Q2. Write a program to display the first 25 Fibonacci numbers beginning at 0.

public class FibonacciSeriesJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n1 = 0, n2 = 1, n3, i, count = 25;
		System.out.print(n1 + " " + n2);// printing 0 and 1

		for (i = 2; i < count; ++i) {
			n3 = n1 + n2;
			System.out.print("," + n3);
			n1 = n2;
			n2 = n3;
		}
	}

}

package com.JavaHomework.question2;

public class Fibonacci25 {

	public static void main(String[] args) {
//		declaring the variables
		int n = 25, t1 = 0, t2 = 1;
		System.out.println("First " + n + " terms: ");
		
//		for loop to iterate through the number of terms
		for(int i = 1; i <= n; ++i) {
			System.out.println(t1 + " + ");
			
			// sum is t1 plus t2
			int sum = t1 + t2;
			//setting t2 to t1 now to continue the sequential addition
			t1 = t2;
			t2 = sum;
		}

	}

}



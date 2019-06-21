package com.revature.q2;

public class First25 {

	public static void main(String[] args) {
		
		int prevNum = 0;
		System.out.println("The first Fibonacci number is " + prevNum);
		int nextNum = 1; /*The first two numbers of Fibonacci must 
		not be part of the loop*/
		System.out.println("The second Fibonacci number is " + nextNum);
		int sum = prevNum + nextNum;
		System.out.println("The third Fibonacci number is " + sum);
		int limit = 25;
		
		for(int i=1;i<limit-2;++i) {
			prevNum = nextNum;
			nextNum = sum;
			sum = prevNum + nextNum;
			
			System.out.println("The " + (i+3) +"th Fibonacci number is " + sum);
		}
	
	}

}

package com.revature.q4;

public class NFactorial {

	public static void main(String[] args) {
		
		long limit = 20;
		long limitnum = limit;/*Since limit is being assigned
		the value of factorial, a new limit that is not being
		reassigned based on the changing factorial should be
		created.*/
		System.out.print(limit + "! is ");
		long factorial;
		for(int i=1;i<limitnum;i++) {
			factorial = limit * (limitnum-i);
			limit = factorial;
		}
		
		System.out.print(limit);

	}

}

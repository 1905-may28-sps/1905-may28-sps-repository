package com.revature.q17;

public class SimpleInterest {
	
	public static int interestSimple(long principal, double rate, int time) {
		
		double interest = principal * rate * time;
		
		return (int) interest;
	}
	
	public static void main(String[] args) {
		System.out.println(interestSimple(10, 0.012, 2));
	}

}

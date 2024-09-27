package com.billy.rateofinterest;
import java.util.Scanner;

public class RateOfInterest {
	public static void main (String [] args) {
	double interest;
	int principal;
	int time;
	Scanner in = new Scanner(System.in);
	
	System.out.println("Please specify the amount of the loan? We will will calculate your interest amount.");
	principal = in.nextInt();
	System.out.println("How many years to repay loan");
	System.out.println("1-5 years Rate at 12.25. "
			+"6-10 years at 14.25");
	time = in.nextInt();
	
	if(time >0 && time <=5) {
		System.out.println(principal * time * 0.1225);
	} else {
		System.out.println(principal * time * 0.1425);
	}
	
	//Simple interest rate equation
	// A = P(1 + rt)
	//Where A = Total Accrued Amount, P= Principal
	//r = rate of interest in decimal
	//t = time in years
	
	
	
	}
}

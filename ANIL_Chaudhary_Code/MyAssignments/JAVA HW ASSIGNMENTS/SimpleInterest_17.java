//Write a program that calculates the simple interest on the principal,

package javaAssignments;

import java.util.Scanner;

public class SimpleInterest_17 {

	public static void main(String[] args) {
		Scanner input1 = new Scanner(System.in); 
		System.out.println("Enter Principal amount: ");
		double loan = input1.nextDouble(); 
		Scanner input2 = new Scanner(System.in);
		System.out.println("Enter Period in years: ");
		double period = input2.nextDouble(); 
		Scanner input3 = new Scanner(System.in);
		System.out.println("rate of interest (%age p.a.): ");
		double rate = input3.nextDouble();
		input1.close();
		input2.close();
		input3.close();
		double interest = loan*rate/100*period ;
		System.out.println("The interest amount is"+ " " +interest);
		
}
}

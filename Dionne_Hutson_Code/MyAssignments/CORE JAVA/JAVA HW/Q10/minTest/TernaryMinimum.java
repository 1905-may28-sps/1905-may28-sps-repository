package com.revature.minTest;
import java.util.Scanner;

public class TernaryMinimum {
	static double firstnum;
	static double secnum;
	static Scanner scan;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the first number");
		scan=new Scanner(System.in);
		firstnum=scan.nextDouble();		
		System.out.println("Enter the second number");
		secnum=scan.nextDouble();
		System.out.println("The minimum values is:" +min(firstnum,secnum));
	}
	public static double min(double first, double sec) {
		return (first<sec)?first:sec;// if first is less than seceond this is true, so it is the min if not it is false so sec is the min
	}
		

}

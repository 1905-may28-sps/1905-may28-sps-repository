package q17;

import java.util.Scanner;

public class SimpleInterest {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter Principal");
		int p = sc1.nextInt();
		@SuppressWarnings("resource")
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Enter Intertest rate % per year");
		int r = sc2.nextInt();
		@SuppressWarnings("resource")
		Scanner sc3 = new Scanner(System.in);
		System.out.println("How many years?");
		int t = sc3.nextInt();

		System.out.println("interest = " + " Principal " + p + "* Rate " + r + "% * Time " + t + "year = " + (p * r/100 * t));

	}

}

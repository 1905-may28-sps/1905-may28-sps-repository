package corejava.revature.q17;

import java.util.Scanner;

public class Q17Interest {

	public static double interest(double prin, double rate, int time) {
		double intr = prin*rate*time;
		return intr;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Principle, Rate, and Time");
		double prin = scan.nextDouble();
		double rate = scan.nextDouble();
		int time = scan.nextInt();
		scan.close();
		System.out.println("Interest: " + interest(prin,rate,time));
	}

}

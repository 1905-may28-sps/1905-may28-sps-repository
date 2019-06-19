package question17;

import java.util.Scanner;

public class CalculateInterest {
	

	static Scanner scan = new Scanner(System.in);

	public static void calculateInterest() {
		System.out.println("Please enter principal");
		String principalStr = scan.nextLine();
		Float principal = Float.parseFloat(principalStr);
		
		System.out.println("Please enter rate");
		String rateStr = scan.nextLine();
		Float rate = Float.parseFloat(rateStr);
		
		System.out.println("Please enter time in years");
		String timeStr = scan.nextLine();
		Float time = Float.parseFloat(timeStr);
		
		
		
		float interest = principal * rate * time;
		
		System.out.println(interest);
		
	}
	
	public static void main(String[] args) {
		calculateInterest();
	}
}

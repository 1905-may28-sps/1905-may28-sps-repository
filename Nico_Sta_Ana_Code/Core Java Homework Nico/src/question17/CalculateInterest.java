package question17;

import java.util.Scanner;

public class CalculateInterest {
	
//initialize scan
	static Scanner scan = new Scanner(System.in);

	public static void calculateInterest() {
		
		//ask user to input principal
		System.out.println("Please enter principal");
		// user input is principalStr
		String principalStr = scan.nextLine();
		//parse string into a float
		Float principal = Float.parseFloat(principalStr);
		
		//same thing for rate
		System.out.println("Please enter rate");
		String rateStr = scan.nextLine();
		Float rate = Float.parseFloat(rateStr);
		
		//same thing for years
		System.out.println("Please enter time in years");
		String timeStr = scan.nextLine();
		Float time = Float.parseFloat(timeStr);
		
		
		//calculate 
		float interest = principal * rate * time;
		
		System.out.println(interest);
		
	}
	
	public static void main(String[] args) {
		calculateInterest();
	}
}

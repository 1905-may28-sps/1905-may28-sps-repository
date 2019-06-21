package interest;

import java.util.Scanner;

public class interest {

	
	/*
	 * . Write a program that calculates the simple interest on the principal, 
	 * rate of interest and number of years provided by the user. Enter principal, 
	 * rate and time through the console using the Scanner class.
Interest = Principal* Rate* Time
	 */
	public static void main(String[] args) {
		
		principle();
	}

	
	
	static void principle() {
		
		
		 Scanner prin = new Scanner (System.in);
		 System.out.println("enter a  amount : $");
		 double num = prin.nextInt();
		 
		 Scanner rate = new Scanner (System.in);
		 System.out.println("enter a  rate: ");
		 double num2 = rate.nextInt();
		 
		 Scanner months = new Scanner (System.in);
		 System.out.println("enter months: ");
		 double num3 = months.nextInt();
		 
		 double interest = num* (num2/100)* num3;
		 double total = interest+ num;
		 
		 System.out.println("you're interest: " + interest);
		 System.out.println("Total with principle: $"+ prin+ " and interest: $"+ interest+ " is $"+ total) ;
		 
	
		 
	}
	
	static void total() {
		
	}
	static  void rate() {
		
		
		 Scanner rate = new Scanner (System.in);
		 System.out.println("enter a  rate: ");
		 double num2 = rate.nextInt();
	        //System.out.println(Math.sqrt(num)); 
		
	}
	
	static void months() {
		
		
		 Scanner months = new Scanner (System.in);
		 System.out.println("enter a  number: ");
		 int num2 = months.nextInt();
	        //System.out.println(Math.sqrt(num)); 
		
	}

}

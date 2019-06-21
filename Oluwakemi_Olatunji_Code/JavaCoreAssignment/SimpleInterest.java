package Assignements;

import java.util.*;

public class SimpleInterest {
	public static void main(String[] args) {
		int principal, rate, time, interest;
	     
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter principal:");
        principal = scanner.nextInt();
        System.out.println("Enter Rate:");
        rate = scanner.nextInt();
        System.out.println("Enter Time:");
        time = scanner.nextInt();
        scanner.close();
        

        interest = principal * rate * time;
    System.out.println("Interest is:"+interest);
	
	
	}

}

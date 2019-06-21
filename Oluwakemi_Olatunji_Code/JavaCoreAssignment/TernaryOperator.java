package Assignements;
import java.util.Scanner;


public class TernaryOperator {
	
	    public static void main(String[] args) 
	    {
	        int num1, num2, minVal;
	      
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Enter First Number:");
	        num1 = scanner.nextInt();
	        System.out.println("Enter Second Number:");
	        num2 = scanner.nextInt();
	        scanner.close();
	    
	        minVal = (num1 < num2) ? num1:num2;
	        System.out.println("Smallest Number is:"+minVal);
	    }
	}


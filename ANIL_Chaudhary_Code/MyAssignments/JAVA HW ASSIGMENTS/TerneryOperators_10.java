//Find the minimum of two numbers using ternary operators.

package javaAssignments;

import java.util.Scanner;

public class TerneryOperators_10 {

		    public static void main(String[] args) 
	    {
	        int num1, num2, result;
	        /* Scanner is used for getting user input. 
	         * The nextInt() method of scanner reads the
	         * integer entered by user.
	         */
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Enter First Number:");
	        num1 = scanner.nextInt();
	        System.out.println("Enter Second Number:");
	        num2 = scanner.nextInt();
	        scanner.close();
	        
	        /* comparing only num1 and
	         * num2 and storing the smallest number into the
	         * result variable to get result
	          */
	        
	        result = num1 < num2 ? num1:num2;
	        
	        System.out.println("The smallest Number is  :   "+result);
	    }
	}



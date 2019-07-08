//Write a method,to turn a number in base 10 to hexadecimal
package javaAssignments;

import java.util.Scanner;

public class DecimaltoHexa_24 {
	// main method
	   public static void main(String args[])
	   {
	     //taking input of decimal number
		   Scanner input = new Scanner( System.in );
	     System.out.print("Enter a decimal number : ");
	     int num =input.nextInt();
	       	 input.close();    
	     int rem;
	       	     
	     String hexanum=""; 
	 	     
	     char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	 
	     while(num>0)
	     {
	       rem=num%16; 
	       hexanum=hex[rem]+hexanum; 
	       num=num/16;
	     }
	     //displaying out hexa number
	     System.out.println("The hexadecimal number is: "+hexanum);
	  }
	}

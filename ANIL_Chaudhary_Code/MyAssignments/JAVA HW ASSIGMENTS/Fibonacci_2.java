//Write a program to display the first 25 Fibonacci numbers beginning at 0.

package javaAssignments;

public class Fibonacci_2{ 
	 
	public static void main(String[] args) 
	{
		// Set it to the number of elements you want in the Fibonacci Series
		 int maxNumber = 25; 
		 int previousNumber = 0;
		 int nextNumber = 1;
		 
	        System.out.print("Fibonacci Series of "+maxNumber+" numbers are :");
 
	        for (int i = 1; i <= maxNumber; ++i)
	        {
	            System.out.print(previousNumber+" ");
	                 
	            int sum = previousNumber + nextNumber;
	            previousNumber = nextNumber;
	            nextNumber = sum;
	        }
 
	}
 
}
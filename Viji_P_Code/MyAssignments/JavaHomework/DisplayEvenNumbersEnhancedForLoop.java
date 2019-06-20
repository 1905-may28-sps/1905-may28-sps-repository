package homework;
import java.util.*;
/*
 * Write a program to store numbers from 1-100 in an array. 
 * Print out all the even numbers from the array. 
 * Use the enhanced for loop for printing out the numbers.
 */

public class DisplayEvenNumbersEnhancedForLoop {
	

	public static void main(String[] args) {
		
	int arr1[] = new int[100];
	for(int i = 0; i<100; i++) {
		arr1[i]=i+1;
	}
	
	System.out.println("Printing out all the "
			+ "numbers from 1-100");
	
	for (int j=0;j<100;j++)
	{
		System.out.println("arr1["+j+"] -"+ arr1[j]);
	}
	System.out.println("All Even numbers from 1-100");
	//Using enhanced For loop(For Each Loop) 
	//for(int num = 0; num <= arr1.length; num++) {
		for ( int num : arr1) {
			if (num % 2 == 0) {
				System.out.println(num);
			}
		  }
}
		
}




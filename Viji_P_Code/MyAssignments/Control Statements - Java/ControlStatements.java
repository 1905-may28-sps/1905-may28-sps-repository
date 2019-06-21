package com.revature.introduction;

public class ControlStatements {
	
	/*
	 * When we need to execute a set of statements based 
	 * on a condition then we need to use control flow 
	 * statements. For example, if a number is greater than 
	 * zero then we want to print “Positive Number” but if 
	 * it is less than zero then we want to print “Negative 
	 * Number”. In this case we have two print statements in 
	 * the program, but only one print statement executes at 
	 * a time based on the input value. We will see how to 
	 * write such type of conditions in the java program 
	 * using control statements.
	 * 
	 * Assignment: With a partner, 
	 * go through the control statements tab in this site
	 * https://beginnersbook.com/2017/08/if-else-statement-in-java/ 
	 * and code one example of each of the following:
	 * if statement, nested if statement, if-else statement, 
	 * if-else if- else statement, for loop, for each loop,
	 * while loop, do while loop, and switch statement
	 * 
	 */
	
	public static void main(String[] args) {
	   ifStatement(2,3);
	   ifElseStatement(67,78);
       ifElseIfStatement(85);
		
	    int[] arr = {10,34,23,24};
	     forLoop(arr);
		
		int[] arr1 = {15,20,45,32};
		secondLargest(arr1);
	   	
			
		
		//String Arrays
		
	String arrays[] = {"cat", "dog", "fish"};
		
		for (int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
		
		//For each Loop
		
	for (String temparr : arrays) {
		    System.out.println(temparr);
		}
		
		//String temparr;
		
		}

	//If - Statement

		public static boolean ifStatement(int a, int b){
				if (a>b) {
			System.out.println("A is greater than B");
					}
			return true;
			}
		
	//If-Else Statement	
	
	public static boolean ifElseStatement(int a, int b){
		if (a>b) {
	System.out.println("A is greater than B");
			}
		else
			System.out.println("B is greater than A");
	return true;
    }
	
	//If-Else if Statement
	
	public static void ifElseIfStatement(int score1) {
		
		if(score1 > 70 && score1 < 80) {
			System.out.println("Grade: C ");
		}
		else if(score1 > 80 && score1 < 90) {
			System.out.println("Grade: B ");
		}
		else if(score1 > 90 && score1 < 100) {
			System.out.println("Grade: A ");
		}
		
	}
	
	//For Loop
	
	public static int forLoop(int arr[]) {
		int temp =0;
				for (int i = 0; i<arr.length; i++) {
				if(arr[i] > temp) 
				temp = arr[i];
				}
				System.out.println("The largest number is: " + temp);
				return temp;
				
	}
	
		
    
	// Finding second largest number in an array  - Coding Challenge
	
	public static void secondLargest(int[] arr1) {
			int temp1 = 0;
			int temp2 = 0;
			for (int i=0; i<arr1.length; i++) {
				if (arr1[i] > temp1) {
					temp2 = temp1;
					temp1 = arr1[i];				
					}
				else if (arr1[i] > temp2) {
					temp2 = arr1[i];
					}
			} System.out.println("The second largest number is: " +  temp2); 
			
		}
}

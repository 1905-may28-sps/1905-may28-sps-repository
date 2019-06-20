package com.revature.arrays;



import java.util.Arrays; 

public class CodeChallengeSecondToLargest {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		int[] arr = {10, 4, 6, 45, 76, 89, 100, 59, 345};
		
		 Arrays.sort(arr);
		
		System.out.println( "second largest value is " + arr[arr.length-2]);
		
		
		getSecondLargest(arr);
		

		

	}
	
	
	
	public static void getSecondLargest(int[] arr) {
	int largest = 0;
	int secondLargest = 0;
	
	for (int i = 0; i < arr.length; i++) {

		if (arr[i] > largest) {
			secondLargest = largest;
			largest = arr[i];

		} else if (arr[i] > secondLargest) {
			secondLargest = arr[i];

		}
	}

	System.out.println("The largest number in this array is: " + largest);
	System.out.println("The Second largest number in this array is: " + secondLargest);

}
			

	
}

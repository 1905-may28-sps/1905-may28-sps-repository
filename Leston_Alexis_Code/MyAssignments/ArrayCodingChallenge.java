package com.revature.arrays;

public class ArrayCodingChallenge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bubbleSort();
		
}
	static void bubbleSort() {
	    int i, j, temp;
	 
	    int arr[] = {10, 15, 9, 5, 11, 22, 17, 36, 13, 2};
	 
	 
	 
	    for (i = 0; i < (arr.length - 1 ); i++) {
	      for (j = 0; j < arr.length - i - 1; j++) {
	        if (arr[j] > arr[j+1]) 
	        {
	           temp = arr[j];
	           arr[j] = arr[j+1];
	           arr[j+1] = temp;
	        }
	      }
	    }
	 
	    System.out.println("Sorted list of integers:");
	 
	    for (i = 0; i < arr.length; i++) 
	      System.out.println(arr[i]);
	    
	    System.out.println("The second highest integer in the array is "+ arr[arr.length-2]);
	  }
	
	
	
}

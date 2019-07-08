//Perform bubble sort to given integer array

package javaAssignments;


public class BubbleSort_1 {
	//bubble sorting method
	static void bubbleSort(int[] arr) {
	      int n = arr.length;
	      int temp = 0;

	      for(int i = 0; i < n; i++) {
	         for(int j=1; j < (n-i); j++) {
	            if(arr[j-1] > arr[j]) {
	               temp = arr[j-1];
	               arr[j-1] = arr[j];
	               arr[j] = temp;
	            }
	         }
	      }
	   }
	  // main method 
	public static void main(String[] args) {
		//given array
	      int arr[] = { 1,0,5,6,3,2,3,7,9,8,4};
	      
	      
	      System.out.println("Array Before Bubble Sort");

	      for(int i = 0; i < arr.length; i++) {
	    	//displaying array before bubble sort
	    	  System.out.print(arr[i] + " ");
	      }
	      //calling bubblesort method
	      bubbleSort(arr);
	      System.out.println("\n Array After Bubble Sort");

	      for(int i = 0; i < arr.length; i++) {
	    	//displaying array after bubble sort
	         System.out.print(arr[i] + " ");
	      }
	   }
	}
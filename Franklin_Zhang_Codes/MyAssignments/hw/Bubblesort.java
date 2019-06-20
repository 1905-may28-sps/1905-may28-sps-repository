package com.revature.hw;
public class Bubblesort {	
	public void bubbleSort(int... arr) {
		//these variables to swap value places.
	        int i, j, temp; 
	   //check to see if it swapped, if not that means it completed     
	        boolean swapped; 
	        for (i = 0; i < arr.length; i++){
	        	//set to false , hopefully already sorted, if not loop
	            swapped = false; 
	            for (j = 0; j < arr.length - i - 1; j++){	            
	                if (arr[j] > arr[j + 1]){ 
	                    temp = arr[j]; 
	                    arr[j] = arr[j + 1]; 
	                    arr[j + 1] = temp; 
	                    //swap occured, so need to run this loop again
	                    swapped = true; 
	                } 
	            } 
	            //we are done if this happened
	            if (swapped == false) 
	                break; 
	        } 
	 } 
	//method to print array
	void printThis(int arr[]) {
		for (int i = 0; i<arr.length; i++) {
			System.out.print(arr[i]+", ");
		}
	}
	
	//main method with arr provided by hw
	public static void main(String[] args) {
		Bubblesort Ob = new Bubblesort();
		int arr[]= {1,0,5,6,3,2,3,7,9,8,4};
		Ob.bubbleSort(arr);
		Ob.printThis(arr);
	}
}

	
	


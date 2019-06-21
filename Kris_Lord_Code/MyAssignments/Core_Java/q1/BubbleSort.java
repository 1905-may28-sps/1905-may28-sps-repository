package com.revature.q1;

import java.util.Arrays;

public class BubbleSort {
	
	public static void bubbleSort(int[] bubbleNum) {
		 int i;
	     boolean pass = true; //first pass
	     int temp;
	     while (pass){
	    	 pass = false;    //reset pass
	    	 for(i=0; i < bubbleNum.length-1; i++){
	    		 if (bubbleNum[i+1] < bubbleNum[i]){ //sort
	    			 temp = bubbleNum[i]; //swap elements
	    			 bubbleNum[i] = bubbleNum[i+1];
	    			 bubbleNum[i+1] = temp;
	    			 pass = true; //after swap is finished  
	    			 }
	    		 }
	    	 }
	     }
	
	public static void main(String[] args) {
		
		 int[] bubbleSortArray ={1,0,5,6,3,2,3,7,9,8,4};
		 bubbleSort(bubbleSortArray);
	     System.out.println(Arrays.toString(bubbleSortArray));

	}

}

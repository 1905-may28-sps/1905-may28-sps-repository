package com.billy.evenarr;

public class ArrayEven {
	
	public static void main(String [] args){
		
		int array[] = new int[100];
		
		for(int arr: array) {
		//for (int a = 0; a < array.length; a++) {
		    arr = arr + 1;
		    
		    if(arr%2 == 0) {
		    	System.out.println(array);
		    }
		}
	}
}


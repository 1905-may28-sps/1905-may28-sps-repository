//Write a program that finds the second largest value in an array. 

package com.revature.arrays;
import java.util.Arrays;

public class SecondLargest {

	  public static void main (String [] args) {
	   int [] array = {45,12,85,32,89,39,69,44,42,1,6,8};
	   int temp;
	   for (int i = 1; i < array.length; i++) {
	    for (int j = i; j > 0; j--) {
	     if (array[j] < array [j - 1]) {
	      temp = array[j];
	      array[j] = array[j - 1];
	      array[j - 1] = temp;
	     }
	    }
	   }
	   
	     System.out.println (array[array.length-2]);
	   }
	  }
	
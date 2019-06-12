//Write a program that finds the second largest value in an array. 

package com.revature.arrays;
import java.util.Arrays;

public class SecondLargest {
public static void main (String [] args) {
	
	int[] nums = {1 ,5, 63, 88, 3, 9, 100, 34, 3459};
	
	Arrays.sort(nums);
	
	System.out.println("The second to largest number is " + nums[nums.length-2]);

}

}


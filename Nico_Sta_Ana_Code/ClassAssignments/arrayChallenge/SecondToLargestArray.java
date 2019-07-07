package com.revature.arrayChallenge;

import java.util.Arrays;

public class SecondToLargestArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {1 ,5, 63, 88, 3, 9, 100, 34, 3459};
		
		Arrays.sort(nums);
		
		System.out.println("Second to largest " + nums[nums.length-2]);

	}

}

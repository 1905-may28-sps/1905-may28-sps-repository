package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HasSum {
	/*
	 * Given an array of integers, determine whether or
	 * not there exist two elements in the array (at different 
	 * positions) whose sum is equal to some target value. 
	 * Examples: [5, 4, 2, 4], 8 --> true [5, 1, 2, 4], 8 --> 
	 * false 
	 */

	public static void main(String[] args) {
		int[] nums = {2, 4, 4, 5};
		System.out.println(googleAnswer(nums, 8));

	}
	
	//O(n^2)
	static boolean bruteForce(int[] nums, int target) {
		for(int i = 0; i < nums.length-1; i++) {
			for(int j = i+1; j < nums.length; j++) {
				if(nums[i] + nums[j] == target) {
					return true;
				}
			}
		}
		return false;
	}
	
	//O(n)
	static boolean hasSum(int[] nums, int target) {
		Set<Integer> differences = new HashSet<Integer>();
		for(int i = 0; i < nums.length; i++) {
			if(differences.contains(target - nums[i])) {
				return true;
			}	
			else {
				differences.add(target-nums[i]);
			}
		}
		return false;
	}
	
	//must be sorted 
	static boolean googleAnswer(int[] nums, int sum) {
		int low = 0;
		int hi = nums.length - 1;
		
		while(low < hi) {
			if(nums[low] + nums[hi] == sum) return true;
		}
		
		return false;
	}

}





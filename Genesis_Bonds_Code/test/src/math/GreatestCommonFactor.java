package math;

import java.util.Arrays;

public class GreatestCommonFactor {
	
	/*
	 * find the greatest common factor of an array of numbers 
	 */
	
	public static void main(String[] args) {
		System.out.println(euclid(20, 8));
	}
	
	static int gcf(int[] nums) {
		Arrays.sort(nums);
		
		return 0;
	}
	
	static int euclid(int m, int n) {
		//check if m > n
		if(m < n) {
			int temp = m;
			m = n; 
			n = temp;
		}
		
		int r = m%n;
		if(r == 0) return n;
		return euclid(n, r);
	}

}

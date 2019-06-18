package com.revature.junit;

public class Methods {
	
	int counter;
	
	public int add(int... nums) {
		int sum = 0;
		for(int n : nums) {
			sum+=n;
		}
		return sum;
	}
	
	public boolean anagram(String a, String b) {
		return false;
	}

}

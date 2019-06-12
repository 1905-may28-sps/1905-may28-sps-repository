package arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;


public class GetNumsToSum {	
	/*
	 * Write a method that takes in an array of numbers and 
	 * returns the pairs of numbers that add up to a certain
	 * number. 
	 */
	
	

	//actual method to return pairs 
	static List<Pair> getOperands(int[] arr, int target){
		
		HashSet<Integer> diffs = new HashSet<Integer>();
		List<Pair> pairs = new ArrayList<Pair>();
		
		for(int num: arr) {
			if(diffs.contains(num)) {
				pairs.add(new Pair(num, target-num));
			}
			else {
				diffs.add(target-num);
			}
		}
		return pairs;
	}
	
	
	//helper method for test
	public static Pair[] asArray(List<Pair> list) {
		Pair[] pairs = new Pair[list.size()];
		for(int i = 0; i < list.size(); i++) {
			pairs[i] = list.get(i);
		}
		return pairs;
	}
	
	
	@Test
	public void test1() {
		int[] arr = {-10, 4, 8, 0, 3, 1, 7};
		List<Pair> actual = getOperands(arr, 8);
		List<Pair> expected = new ArrayList<Pair>();
		expected.add(new Pair(0, 8));
		expected.add(new Pair(1, 7));
		assertArrayEquals(asArray(actual),asArray(expected));
	}
}



//data structure to hold nums 
class Pair{
	
	private int a;
	private int b;
	
	public Pair(int a, int b){
		this.a = a;
		this.b = b;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		result = prime * result + b;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (a == other.a && b == other.b)
			return true;
		if (b == other.a && a == other.b)
			return true;
		return false;
	}
	
	
	
}
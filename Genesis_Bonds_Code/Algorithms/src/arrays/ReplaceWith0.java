package arrays;

import java.util.HashSet;
import java.util.Set;

public class ReplaceWith0 {

	/*
	 * Write an algorithm such that if an element 
	 * MxN matrix is 0, its entire row and column is set to 0
	 * 
	 */
	
	public static void main(String[] args) {
		int[][] nums = {{1, 2, 4, 5}, {0, 1, 7 , 8}, {1 , 3, 0, 5}};
		print(nums);
		System.out.println("----------");
		print(replace(nums));
	}



	static int[][] replace(int[][] arr){
		Set<Integer> rows = new HashSet<Integer>();
		Set<Integer> cols = new HashSet<Integer>();
		//figure out where the 0's are 
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] == 0) {
					rows.add(i);
					cols.add(j);
				}
			}
		}
		
		if(!rows.isEmpty() || !cols.isEmpty()) {
			for(int r : rows) {
				for (int i = 0; i < arr[r].length; i++) {
					arr[r][i] = 0;
				}
			}
			for(int c : cols) {
				for(int i = 0; i < arr.length; i++) {
					arr[i][c] = 0;
				}
			}
		}
		return arr;
	}


	//helper method for testing 
	static void print(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}

package arrays;

public class Spiral2D {

	/*
	 * Find the pattern and complete the function: 
		int[][] spiral(int n);
		where n is the size of the 2D array.

		Sample Results:
		input = 3
		123
		894
		765

		 1  2  3  4 5
		16 17 18 19 6
		15 24 25 20 7
		14 23 22 21 8
		13 12 11 10 9
		input = 4
		01 02 03 04
		12 13 14 05
		11 16 15 06
		10 09 08 07

		input = 8
		 1  2  3  4  5  6  7  8	
		28 29 30 31 32 33 34  9
		27 48 49 50 51 52 35 10
		26 47 60 61 62 53 36 11
		25 46 59 64 63 54 37 12
		24 45 58 57 56 55 38 13
		23 44 43 42 41 40 39 14
		22 21 20 19 18 17 16 15

		[0][0] ..... [0][n-1]
		.  .....
		.
		.

		[n-1][0] .....[n-1][n-1]
	 */
	public static void main(String[] args) {
		/*
		 * notes to solve
		 * max num in array = n^2
		 * is there some function to figure out x&y values ??
		 */

		int x = 5;
		int[][] result = spiral(x);
		System.out.println("-----");
		for(int i = 0; i < x; i++) {
			for (int j = 0; j < x; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}

	}


	static int[][] spiral(int n){

		if(n==1){
			int[][] nums = {{1}};
			return nums;
		}
		int[][] nums = new int[n][n]; //initializing array
		int temp = 1; //counter for nums in array
		int bound = n-1; 
		int rounds = 4;
		int currRound = 0;

		while(currRound < rounds) {

			//top
			for(int j = currRound; j <= bound; j++) {
				nums[currRound][j] = temp++;
			}

			//right [x][n-1-currRound]
			for(int j = currRound+1; j <= bound-1; j++) {
				nums[j][n-1-currRound] = temp++; 
			}

			//bottom
			for(int j =bound; j >= currRound; j--) {
				nums[n-1-currRound][j] = temp++; 
			}

			//left [n-1-currRound][x]
			for(int j =bound-1; j >= currRound+1; j--) {
				nums[j][currRound] = temp++; 
			}

			bound--;
			currRound++;
		}

		if(n%2==1) {
			nums[(n/2)][(n/2)] = n*n;
		}
		return nums;
	}
}



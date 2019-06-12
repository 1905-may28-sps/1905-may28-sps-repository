package arrays;

public class RotateImage {
	
	/*
	 * Given an image represented by an NxN matrix 
	 * where each pixel in the image is 4 bytes, write
	 * a method to rotate the image by 90 degrees.
	 * Can you do this in place?	 */

	public static void main(String[] args) {
		
		int[][] nums =  {{ 1, 2, 3} , {4, 5, 6}, {7, 8, 9}};
		print(nums);
		print(inPlace(nums));
		
	}
	
	public static int[][] rotate(int[][] image){
		//note that 1 int is 4 bytes so we can use an int array 
		
		/*
		 * [0][0] [0][1].... [0][n-1]      [n-1][0] --- [0][0]
		 * .				[1][n-1]    ->  -
		 * .				.				-
		 * [n-1][0] ...[n-1][n-1]	 [n-1][n-1] ----- [0][n-1]		
		 * 
		 * 1 2 3       7 4 1
		 * 4 5 6  ->   8 5 2
		 * 7 8 9       9 6 3
		 */
		
		int len = image[0].length;
		int[][] temp = new int[len][len];
		for(int i = 0; i < len; i++) {
			for(int j = 0; j < len; j++) {
				temp[i][j] = image[len-j-1][i];
			}
		}
		return temp;
	}
	
	//got annoyed by this so.. here's the solution from the book 
	/*
	 * The rotation can be perfomed in layers, where you perform 
	 * a cyclic swap on the edges on each layer
	 * In the first for-loop, we rotate the first layer (outermost
	 * edges). we rotate the edges by doing a four-way swap first on
	 * the corners, then on the element clockwise from the edges, and
	 * so on 
	 */
	static int[][] inPlace(int[][] image){
		int len = image[0].length;
		
		for(int layer = 0; layer < len/2; ++layer) {
			int first = layer;
			int last = len - 1 - layer; 
			for(int i = first; i < last; ++i) {
				int offset = i - first;
				
				//save top row 
				int top = image[first][i];
				
				//left -> top
				image[first][i] = image[last-offset][first];
				
				//bottom -> left
				image[last-offset][first] = image[last][last-offset];
				
				//right -> bottom 
				image[last][last-offset] = image[i][last];
				
				//top -> right
				image[i][last] = top;
			}
		}
		
		return image;
	}


	//helper method for testing 
 	static void print(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}

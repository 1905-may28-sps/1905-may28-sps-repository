package sorts;

public class BubbleSort {

	// Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.
	// O(n^2)
	public static void main(String[] args) {
		int[] test = {10, 2, 5, 11, 6, 60, 3};
		int[] out = bubbleSort(test);
		for(int x : out) {
			System.out.println(x);
		}
	}

	static int[] bubbleSort(int[] nums) {

		for(int j = 0; j < nums.length-2; j++) {
			for(int i = 0; i < nums.length-1; i++) {

				if(nums[i] > nums[i+1]) {
					int a = nums[i];
					int b = nums[i+1];
					nums[i] = b;
					nums[i+1] = a;
				}
			}
		}

		return nums;
	}

}

package Assignements;

// Perform a bubble sort on the following integer array: 1,0,5,6,3,2,3,7,9,8,4
public class BubbleSort {

	static void bubbleSort(int[] arr) {
		int n = arr.length;
		int temp = 0; // temporary storage for swapping
		// i outer loop
		// j inner loop
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (arr[j - 1] > arr[j]) {
					// check number before
					// swap larger items goes to the right
					temp = arr[j - 1]; // first number goes into the temporary variable
					arr[j - 1] = arr[j]; // assign the first number the value of the second
					arr[j] = temp;
				}

			}
		}

	}

	public static void main(String[] args) {
		int arr[] = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };

		System.out.println("Before Bubble Sort");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		bubbleSort(arr);// sorting array elements

		System.out.println("After Bubble Sort");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}
}
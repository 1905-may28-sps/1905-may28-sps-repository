package search;

public class BinarySearch {

	public static void main(String[] args) {
		
		int arr[] = {1, 3, 5, 7, 10, 24, 500};
		System.out.println(binSearch(arr, 7));

	}

	public static int binSearch(int[] arr, int num){
		int start = 0;
		int finish = arr.length-1;
		
		System.out.println("Start: " + start + ", Finish: " + finish);

		while(start+1 < finish){
			int curr = (finish-start)/2 + start; //middle 
			if(arr[curr] == num) return curr;
			else if(arr[curr] < num) start = curr;
			else if(arr[curr] > num) finish = curr;
			else {
				break;
			}
			System.out.println("Start: " + start + ", Finish: " + finish);
		}
		return -1;
	}
}

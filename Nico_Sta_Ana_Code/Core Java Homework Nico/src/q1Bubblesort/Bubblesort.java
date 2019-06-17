package q1Bubblesort;

public class Bubblesort {
	
	void bubbleSort (int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n-1; i ++)
			for(int j = 0; j < n -i -1; j ++)
				if( arr[j] > arr [j+1])
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr [j+1]= temp;
				}
		
	}
	
	
	void printArray(int arr[]) {
		
		int n = arr.length;
		for (int i = 0; i < n; ++i) {
			System.out.println(arr[i]+ " ");
		}
		System.out.println();
	}

public static void main(String[] args) {
	Bubblesort obj = new Bubblesort();
	int arr[] = {1,0,5,6,3,2,3,7,9,8,4};
	obj.bubbleSort(arr);
	obj.printArray(arr);
}

}

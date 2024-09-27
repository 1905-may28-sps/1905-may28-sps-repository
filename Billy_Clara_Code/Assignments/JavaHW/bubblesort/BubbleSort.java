package com.billy.bubblesort;

public class BubbleSort {
	
	void bubbleSort(int arr[]){
		
		int n = arr.length;
		for(int i = 0; i <= n; i++) {
			
			for(int j = 0; j < n-1; j++)
			if (arr[j] > arr[j+1]) {
				
			int temp = arr[j];
			arr[j] = arr[j+1];
			arr[j+1] = temp;
			
			}
		}
	}
	
	void printArr(int arr[]) {
     
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    }
	
	public static void main(String[] args) { 
        BubbleSort BS = new BubbleSort(); 
        int arr[] = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4}; 
        BS.bubbleSort(arr); 
        BS.printArr(arr); 
    } 
}

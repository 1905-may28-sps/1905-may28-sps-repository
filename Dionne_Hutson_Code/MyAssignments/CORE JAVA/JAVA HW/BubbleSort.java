import java.util.Scanner;

public class BubbleSort {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		System.out.println(test());
		int[] arr= {1,0,5,6,3,2,3,7,9,8,4};
		arr=bubbleSort(arr);
		
		
		for (int element: arr) {
            System.out.println(element);
        }
	}
	public static int[] bubbleSort(int[] arr) {
		int j=0;
		do {
		for (int i=0; i<arr.length;i++) {
			int a=arr[i];
			
			if(i<arr.length-1) {
				int b=arr[i+1];
			if (a>b) {
				arr[i+1]=a;
				arr[i]=b;;
						
			}
		} 
		}j++;
		}while (j<arr.length);
		
		return arr;
	}
	
	
		public static boolean test(){
			
			int[] arr1= {1,4,2,3,5};
			int[] arr2= {1,3,2,4,5};
			int[] arr3= {4,1,2,3,5};
			int[] arr4= {1,5,2,3,4};
			int[] arr5= {3,1,4,2,5};
			int[] arr6= {1,2,3,4,5};
			arr1=bubbleSort(arr1);
			arr2=bubbleSort(arr2);
			arr3=bubbleSort(arr3);
			arr4=bubbleSort(arr4);
			arr5=bubbleSort(arr5);
			boolean out=false;
			
			for (int i=0;i<arr6.length;i++) {
			         out=false;
	            if (arr1[i]==arr6[i]) {
		            if (arr2[i]==arr6[i]) {
		            	if (arr3[i]==arr6[i]) {
		            		if (arr4[i]==arr6[i]) {
		            			if (arr5[i]==arr6[i]) {
		            				out=true;
		    		            	
		    		            }else {
		    						out=false; 
		    						return out;}
				            	
				            }else {
								out=false; 
								return out;}
			            	
			            }else {
							out=false; 
							return out;}
		            	
		            }else {
						out=false; 
						return out;}
	            	
	            }else {
				out=false; 
				return out;}
			}
							
						
			return out;
		}
	}






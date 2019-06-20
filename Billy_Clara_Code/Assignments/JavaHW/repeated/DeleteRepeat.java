package com.billy.repeated;

public class DeleteRepeat {
	
	public static void main(String[] args) {
//		
//		String myStr = "Hello";
//		for (int i = 0; i > myStr.length(); i++) {
//			if (i == i+1) {
//				i= i+1;
//				pop.myStr[i];
//				System.out.println(myStr);
//			}
//		}
//	}
	}
		void removeRepeat() {
		String str[] = {"Hello"};
		int n;
		int index = 0;    
	   for (int i=0; i<n; i++) { 
	    
	     int j;   
	     for (j=0; j<i; j++)   
	        if (str[i] == str[j])  
	           break; 
	        
	     if (j == i) 
	        str[index++] = str[i]; 
	   }
	}
	 



package com.revature.arrays;

import java.util.Arrays;

public class ArrayCodingChallenge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//if statement nested if statement if-else saement if elseif else statement  for loop for each loop while loop do while loop switch statement
		
	int i=0;
	while (i<100) {
	i++;
	System.out.println(i);
	
	}
	int j=0;
	
	do {
	j++;
	System.out.println("doing");
	}while(j<10);
	
	switchst("pealth");
	
	
	
	
	

	elseif(4);
	nestedif("Housto");
	int[] arr = {93,482,456,97,478,492};
	
	foreach(arr);
	
	
	//seclrg(arr);
	seclrg2(arr);
	testseclrg2();
	}
	
	public static boolean testseclrg2(){
		int[] arr1= {1,4,2,3,5};
		int[] arr2= {1,3,2,4,5};
		int[] arr3= {4,1,2,3,5};
		int[] arr4= {1,5,2,3,4};
		int[] arr5= {2,1,4,3,5};
		seclrg2(arr1);
		seclrg2(arr2);
		seclrg2(arr3);
		seclrg2(arr4);
		seclrg2(arr5);
		
		boolean out=false;
		if(arr1[3]==4) {
			if(arr2[3]==4) {
				if(arr3[3]==4) {
					if(arr4[3]==4) {
						if(arr5[3]==4) {
						out=true;	
						}
						
					}
					
				}
				
			}
			
		}
		System.out.println(out);
		return out;
	}
	
public static void elseif(int i) {

	if (i>5) {
		System.out.println("This number is too high");
	}
	else if(i<4){
		System.out.println("This number is too low");
	}
	else {
		System.out.println("This is my number!");
	}
}

public static void nestedif(String str) {
	if (str.length()>=7) {
		if ((""+str.charAt(0)).equalsIgnoreCase("h")) {
			System.out.println("Is this a word with more than six letters that starts with H? ");
		}else {System.out.println("Your word is too hard to guess");
	}
		
}


}

public static void foreach(int[] arr) {
	for (int num:arr) {
		System.out.println(num+1);
	}
}

public static void switchst(String str) {
	char ch=str.charAt(0);
	switch(ch)
	{
		case 'a':
		case 'b':
		case 'c':
		case 'd':
			System.out.println("A-D");
			break;
		case 'e':		
		case 'f':
		case 'g':
		case 'h':
			System.out.println("E-F");
			break;
		default:
			System.out.println("none");
	}
	
}



public static void seclrg(int[] arr) {
	Arrays.sort(arr);
	System.out.println(arr[arr.length-2]);
	
}

public static void seclrg2(int[] arr) {
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
	System.out.println(arr[arr.length-2]);
	
}



}



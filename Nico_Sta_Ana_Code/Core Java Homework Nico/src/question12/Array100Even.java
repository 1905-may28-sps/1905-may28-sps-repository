package question12;

public class Array100Even {


public static void main(String[] args) {
	
	
	//create an array of numbers up to 100
	int[] a = new int[101];
	
	//for loop through the array of numbers 0 - 100
	for(int i = 0; i < 100; i ++) {
		a[i] = i +1;
		if(a[i] % 2 == 0) {
			System.out.println(a[i]);
		}
	}

//	end of main
}
// end of class
}

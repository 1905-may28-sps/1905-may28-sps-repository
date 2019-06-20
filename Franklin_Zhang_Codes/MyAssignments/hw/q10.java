package com.revature.hw;
//Find the minimum of two numbers using ternaryoperators.
public class q10 {
	
public static void main(String[] args) {
	int a= 2110;
	int b=320;
	int x=Min(a, b);
	System.out.println(x);
}

/*private static void minoftwo() {
			
	min = (a<b) ? a:b;
	System.out.println(min);
}
*/
public static int Min(int a, int b) {
	int min;
	min = (a<b) ? a:b;
	return min;
}


}

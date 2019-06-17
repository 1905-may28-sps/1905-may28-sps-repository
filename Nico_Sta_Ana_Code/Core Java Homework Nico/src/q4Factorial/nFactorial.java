package q4Factorial;

public class nFactorial {

//	declaring a static method (using recursion)
	static int factorial(int n) {
//		take N multiply by N - 1; keep repeating until base case
		if (n >= 1) {
			return (n * factorial(n-1));
		}
		else {
			return 1;
		}
	}
	
	
	public static void main(String[] args) {
		
//		test case
		int n = 6;
		
		System.out.println("Factorial of " + n + " = " + factorial(n));
	}
}

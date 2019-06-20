package homework;

//Q2: Write a program to display the first 25 Fibonacci numbers beginning at 0.

public class FibonacciNumbers {

	public static void main(String[] args) {
		System.out.println("First 25 Fibonacci numbers:");
		int n1 = 0;
		int n2 = 1;
		int fib = 0;
		int maxNumber = 25;
		System.out.println(n1);
		System.out.println(n2);
		for (int i = 1; i<maxNumber-1; i++) {
			fib = n1+n2;
			n1 = n2;
			n2 = fib;
			System.out.println(fib);
		}
		
	}

}

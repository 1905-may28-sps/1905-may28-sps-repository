package Assignements;


public class NFactorial {
	public static void main(String[] args) {
		System.out.println(factorial(11));
		
	}
		
		public static int factorial (int number) {
			
		
			if(number == 0) {
			return 1;
		}
		return number * factorial(number - 1);	
	}
}


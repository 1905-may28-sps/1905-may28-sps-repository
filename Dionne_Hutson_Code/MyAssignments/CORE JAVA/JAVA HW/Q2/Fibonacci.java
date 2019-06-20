
public class Fibonacci {

	public static void main(String[] args) {
		fib25();
		// TODO Auto-generated method stub

	}
	
	public static void fib25() {
		System.out.print(0+", ");// cannot figure out an algorithim that will produce 0 or 1 on its own so I manually did it.
		System.out.print(1);
		int a=0;
		int b=1;// this is our intial 2 values
		for (int i=0;i<23;i++) {	// we have the first 2 numbers already so we only need 23 more
		int c=a+b;// a and b our our two preceeding values
		System.out.print(", "+c);
		a=b;//this pushes forward the two"preveious" values given 1234 if a was 1 and b was 2 a is now 2 and b is now 3
		b=c;
		
		}
		
		
	}

}

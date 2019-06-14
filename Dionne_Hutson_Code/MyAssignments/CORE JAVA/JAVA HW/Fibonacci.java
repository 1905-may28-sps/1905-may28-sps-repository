
public class Fibonacci {

	public static void main(String[] args) {
		fib25();
		// TODO Auto-generated method stub

	}
	
	public static void fib25() {
		System.out.print(0+", ");
		System.out.print(1);
		int a=0;
		int b=1;
		for (int i=0;i<23;i++) {	
		int c=a+b;
		System.out.print(", "+c);
		a=b;
		b=c;
		
		}
		
		
	}

}

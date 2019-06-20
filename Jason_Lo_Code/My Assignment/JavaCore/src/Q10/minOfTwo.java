package Q10;
import java.util.Random;

public class minOfTwo {

	public static void main(String[] args) {
		
		Random rand = new Random();
		int a = rand.nextInt(100);
		int b = rand.nextInt(100);	
		int minVal = (a < b) ? a : b;
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("Minimin = " + minVal);
	}

}

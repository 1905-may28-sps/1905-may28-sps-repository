package Q6;

public class isEven {

	static boolean isEven(int n) {

		return ((n / 2) * 2 == n);
	}

	public static void main(String[] args) {
		int n = 101;
		if (isEven(n) != false)
			System.out.print("Even");
		else
			System.out.print("Odd");

	}

}

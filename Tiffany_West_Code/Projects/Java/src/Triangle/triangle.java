package Triangle;

public class triangle {

	public static void main(String[] args) {
			binaryTriangle();
	}

	private static void binaryTriangle() {
		for (int i = 0; i <= 4; i++) {
			for (int j = 0; j <= i; j++) {
				if ((i + j) % 2 == 1) {
					System.out.print("1");
				} else {
					System.out.print("0");
				}

			}
			System.out.println();
		}
	}

}

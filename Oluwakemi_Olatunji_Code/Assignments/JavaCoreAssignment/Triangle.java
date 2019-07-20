package Assignements;

public class Triangle {

	public static void main(String[] args) {
		int var = 0;
		System.out.println(var);
		
		for (int i = 0; i <= 1; i += 1) {
			for (int j = 0; j <= i; j++) {
				System.out.print(var + 1);

				if (j % 2 == 0) {
					System.out.print(var);
				}
			}
			System.out.print("\n");
		}
		
		for (int i = 0; i < 3; i += 2) {
			if (i % 2 == 0) {
				System.out.print(var);
			}
			System.out.print(var + 1);
		}
	}

}

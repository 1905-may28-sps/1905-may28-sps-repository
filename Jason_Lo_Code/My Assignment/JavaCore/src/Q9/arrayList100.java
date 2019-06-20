package Q9;

import java.util.ArrayList;

public class arrayList100 {
	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();

		for (int i = 1; i <= 100; i++) {
			numbers.add(i);
		}

		for (Integer i : numbers) {
			boolean isPrime = true;

			for (int j = 2; j < i; j++) {

				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}

			if (isPrime)

				System.out.println(i);
		}

	}
}
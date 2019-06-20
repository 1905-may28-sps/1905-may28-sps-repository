package q12;

import java.util.ArrayList;

public class enhancedForLoop {
	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();

		for (int i = 1; i <= 100; i++) {
			numbers.add(i);
		}

		for (Integer i : numbers) {
			if (i % 2 == 0) {
				System.out.println(i);
			}

		}

	}
}

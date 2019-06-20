package q19;

import java.util.ArrayList;

public class addEvenOdd {

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		ArrayList<Integer> evenSum = new ArrayList<Integer>();
		ArrayList<Integer> oddSum = new ArrayList<Integer>();

		for (int i = 1; i <= 10; i++) {
			numbers.add(i);
		}

		System.out.println(numbers);
		int even = 0;
		int odd = 0;

		for (Integer i : numbers) {
			if (i % 2 == 0) {
				evenSum.add(i);
			} else {
				oddSum.add(i);
			}
		}
		for (Integer i : evenSum) {
			even += i;
			System.out.println(even);
		}
		for (Integer i : oddSum) {
			odd += i;
			System.out.println(odd);

		}
	}
}
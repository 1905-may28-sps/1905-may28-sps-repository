package Assignements;

import java.util.ArrayList;
import java.util.List;

public class Prime {
	public static void main(String[] args) {
	System.out.println("The first 100 Prime Numbers: ");

	// ArrayList Store
	List<Integer> primeNumbers = new ArrayList<Integer>();
	
	for (int index = 2; index < 100; index++) {
		boolean maybePrime = true; 
		// for every number that can factor into the index number
		for (int i = 2; i < index; i++)
				// Is it divisible by a another number?
			if (index % i == 0)
				maybePrime = false;

			if (maybePrime) 
			{
				System.out.print(index + " ");
				primeNumbers.add(index); // Add to Array
			}
		}
	}
}

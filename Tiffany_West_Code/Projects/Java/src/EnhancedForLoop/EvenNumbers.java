package EnhancedForLoop;

import java.util.ArrayList;

public class EvenNumbers {

	public static void main(String[] args) {

		ArrayList<Integer> arraylist = new ArrayList<Integer>(100);
		ArrayList<Integer> evenarr = new ArrayList<Integer>(100);


		
		
		
		
		
		for (int i = 1; i <= 100; i++) {
			arraylist.add(i);
		}
		for (int item : arraylist) {
			if (item % 2 == 0) {
				evenarr.add(item);

			}

		}
		System.out.println("Even Numbers  : " +evenarr);
		

	}

}

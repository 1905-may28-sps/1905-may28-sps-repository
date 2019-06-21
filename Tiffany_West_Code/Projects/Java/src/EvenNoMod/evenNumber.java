package EvenNoMod;

public class evenNumber {

	/*
	 * Q6. Write a program to determine if an integer
	 *  is even without 
	 * using the modulus operator (%)
	 */
	public static void main(String[] args) {

		Number(25);
	}

	private static void Number(int num) {
		int checked = num/2;
		if (checked * 2 ==num) {
			System.out.println("Even number: "+ num);
		} else {
				System.out.println("Odd number : "+ num+ ", try again");
		}

		
	}

}

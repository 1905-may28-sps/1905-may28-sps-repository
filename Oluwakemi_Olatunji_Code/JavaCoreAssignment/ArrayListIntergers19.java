package Assignements;

public class ArrayListIntergers19 {

	public static void main(String[] args) {
		int arrayOfIntergers [] = {1,2,3,4,5,6,7,8,9,10};
		int even = 0;
		int odd = 0;
		
		for (int number = 0; number < arrayOfIntergers.length; number++) {
			if(number % 2 == 0)
				even += arrayOfIntergers[number];
			else
				odd += arrayOfIntergers[number];
			
		}
		System.out.println("Even: " + even);
		System.out.println("Odd: "+ odd);
	}
}

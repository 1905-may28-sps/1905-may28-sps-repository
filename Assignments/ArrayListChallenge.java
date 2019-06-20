import java.util.*;  

public class ArrayListChallenge {

	public static void main(String[] args) {
		/*
		 * Create an ArrayList which stores numbers 1 to 100 & prints all the prime numbers
		 */
		
//		create ArrayList<String> list=new ArrayList<String>();    
		int num = 1;
		
		ArrayList<Integer> list=new ArrayList<Integer>();
		
		for(int i = 1;i <= 100; i++) {
			num = i;
			list.add(num);
			
		}
		
		
//		List<Integer> numbers = Arrays.asList(1, 2, 3, 
//                4, 5, 6, 7, 8); 
//		
		
//		Need a feature to grab prime numbers
		System.out.println(list.toString());
		
	}

}

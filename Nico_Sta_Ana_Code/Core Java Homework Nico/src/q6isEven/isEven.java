package q6isEven;

public class isEven {
	
	static boolean isEven(int n) {
		
		//set default boolean as true
		boolean isEven = true;
		
		//for loop through each number
		for (int i = 1; i <= n; i ++) {
			//every other number is even start at 1
			isEven = !isEven;
		}
		
		return isEven;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 int n = 101; 
	        if(isEven(n)) 
	            System.out.println("Even"); 
	        else
	            System.out.println("Odd"); 
	          

	}

}

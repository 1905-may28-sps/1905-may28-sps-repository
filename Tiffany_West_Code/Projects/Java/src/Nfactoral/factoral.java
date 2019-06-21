package Nfactoral;

public class factoral {

	public static void main(String[] args) {
		int fact = 25; 

			int factorial = 1;
			int i = 1;
			
			for (i= 1; i <=fact; i++) {
				
				factorial = factorial*i;
				
			}
			
			System.out.println("Facotorial of  " + fact + " is " + factorial );
		}
	}


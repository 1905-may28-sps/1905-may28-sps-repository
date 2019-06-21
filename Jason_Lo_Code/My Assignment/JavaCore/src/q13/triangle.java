package q13;

public class triangle {

	public static void main(String[] args) {
		int rows = 4;
		
		for(int i = 1 ; i <= rows; i++ ) {
			for(int j = 1; j <= i; j++) {
				System.out.print(((i+j)%2)+" ");
			}
			System.out.print("\n");
			
		}

	}

}

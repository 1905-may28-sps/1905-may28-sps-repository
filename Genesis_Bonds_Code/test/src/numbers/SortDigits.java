package numbers;

public class SortDigits {

	public static void main(String[] args) {
		sortInts(100);
	}
	
	public static void sortInts (int input) {
		//must include edge cases!
	    int[] arr = new int[10];
	    while (input > 0) {
	        int tmp = input % 10;
	        arr[tmp]++;
	        input = input/10;
	    }
	    for (int i=0; i<10; i++) {
	        while (arr[i] != 0) {
	            System.out.print(i);
	            arr[i]--;
	        }
	    }
	}

}

package corejava.revature.q10;

public class Q10Tern {

	public static int findMin(int num1, int num2) {
		int min;
		if(num1-num2<0) {
		min = num2 > num1 ? num1 : num2;
		}
		else {
		min = num1 > num2 ? num2 : num1;
		}
		return min;
	}

	public static void main(String[] args) {
		System.out.println(findMin(50,100));
		System.out.println(findMin(100,50));

	}

}

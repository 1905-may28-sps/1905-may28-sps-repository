package corejava.revature.q4;

public class Q4Nfactor {

	public static int nFactorial(int num) {
		int sum = num;
		for(int i=(num-1); i>0; i--) {
			sum = i*sum;
		}
		return sum;
	}
	public static void main(String[] args) {
		System.out.println(nFactorial(10));

	}

}

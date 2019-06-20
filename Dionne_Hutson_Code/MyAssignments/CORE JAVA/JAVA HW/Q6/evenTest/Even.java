import java.util.Scanner;

public class Even {
	static Scanner scan;
	static int num;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter a number to find out if it is true that it is even. If the answer is false, it is odd.");
		scan= new Scanner(System.in);
		num=scan.nextInt();
		eoo(num);
		System.out.println(eoo(num));

	}
	public static boolean eoo(int num) {
		boolean even=false;
		double div=num/2;
		if ((num/2)==num-div) {//if half of the number(found through divsion) is equal to the number -(half of the number) ie 6/2= 6-(6/2)
			even=true;
		}
		
		return even;
	}

}

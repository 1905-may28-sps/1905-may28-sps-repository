import java.util.Date;
import java.util.Scanner;

public class switchCases {
static int length;
	
	static String opt;
	static Scanner scan;
	static String word;
	static int num;
	public static void main(String[] args) {
		System.out.println("Hi \n Would you like to: \n(1) Find the Square Root (2)Find the Date (3)Split String?");
		scan=new Scanner(System.in);

		opt=scan.nextLine();
		System.out.println(opt);
		option(opt);
		
	}
	public static void option(String option) {
		switch(option) {
		case "1":
			System.out.println("You chose to find the Square Root. Enter a number");
			num=scan.nextInt();// ask for a number
			System.out.println(Math.sqrt(num));
			
			break;
		case "2":
			System.out.print("Today is: ");
			System.out.println(new Date());
			break;
		case "3":
			String str="I am learning Core Java";
			String[] strArr=str.split(" ");// split by space
			break;
		default: System.out.println("You did not enter 1 or 2 try again");
		//tryAgain();

		}

	}

}
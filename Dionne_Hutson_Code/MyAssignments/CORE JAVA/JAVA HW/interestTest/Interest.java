import java.util.Scanner;

/*Write a program that calculates the simple interest on the principal, rate of interest and number of years provided by the user. Enter principal, rate and time through the console using the Scanner class. 
Interest = Principal* Rate* Time
 * 
 * */
public class Interest {
static double pri;
static double rate;
static int time;
static Scanner scan;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		scan=new Scanner(System.in);
		System.out.println("Enter the principal value");
		pri=scan.nextDouble();
		System.out.println("Enter the rate of intrest");
		rate=scan.nextDouble();
		System.out.println("Enter the number of years");
		time=scan.nextInt();
		
		System.out.println("Your interest is: "+interest(pri,rate,time));
		

	}
	public static double interest(double pri,double rate, int time) {
		
		return pri*rate*time;
		
	}

}

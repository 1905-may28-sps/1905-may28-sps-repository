package HextoDec;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadFromScanner {

	
	public static void main(String[] args) {
		System.out.println("Hi, what's your name? ");
		
		Scanner scan = new Scanner(System.in);
	
		String name = scan.nextLine();
		
		System.out.println("Hey, " + name  + " !");
		conversion();
		
		
		/*
		 * Greet users and displays options
		 * 
		 * 1. convert decimal to hex
		 * 2. convert hex to dec
		 */
}

static void conversion() {
try {
Scanner scan = new Scanner(System.in);

System.out.println("which would you like to do");
String option = scan.nextLine(); // i think we'll have to chance the string input to an int
//int option = scan.nextInt(); 

switch (option) {
case "dec": //change these to the methods
dec();
System.out.println("dec to hex is done: " );
break;
case "hex":
hex();
System.out.println("hex to dec is done: ");
break;
default:
System.out.println("please enter a response dec or hex");
conversion();

}
}
catch(InputMismatchException e) {
System.out.println("caught exception ");

}
finally {
System.out.println("go take a break ");
}
}

static void  dec() {
Scanner decNum = new Scanner (System.in);
System.out.println("enter a decimal number: ");
int num = decNum.nextInt();

String str = Integer.toHexString(num);
System.out.println("dec method : " + str);

}

static void hex() {
System.out.println("hex method");
Scanner hexDec = new Scanner (System.in);
System.out.println("enter a hexdecimal: ");
String hex = hexDec.nextLine();

int decimal = Integer.parseInt(hex,16);
System.out.println( "hex to dec is: " +decimal);



}

}

package corejava.revature.q20;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q20 {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner scan = new Scanner(new File("C:\\Users\\Daniel Molinaro\\Desktop\\Data.txt")).useDelimiter(":|\\s");
		String name = scan.next();
		String lastName = scan.next();
		int age = scan.nextInt();
		String state = scan.next();
		scan.close();

		System.out.println("Name: " + name + " " + lastName);
		System.out.println("Age: " + age + " " + "years");
		System.out.println("State: " + state + " " + "State");

	}

}

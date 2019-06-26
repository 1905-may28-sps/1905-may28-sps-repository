package BankJava;

import java.util.Scanner;

public class BankFirst {
	public static void main(String[] args) {
		LogOrReg();
		//System.out.println(returningUsers);
	}
	
	public static void LogOrReg() {
		System.out.println("Hello! Welcome to BankRev");
		System.out.println("Please enter 1 to Login or 2 to register");
		Scanner in = new Scanner(System.in);//get input
		String choice = in.nextLine();//change input
		//integer choice= String.valueOf(in); we can use this if we dont want to use a string
		switch(choice) {
		case "1": //System.out.println("login page");//temp change to function
			BankLogin();
			break;
		case "2": //System.out.println("register page");
			BankRegister();
			
			break;
		default: 
			System.out.println("Incorrect Input, Please press 1 to Login or press 2 to Register");
			LogOrReg();
		}
		
	}

	private static void BankRegister() {
		System.out.println("You have Chosen to register");
		BankRegister.addUser();
	}

	private static void BankLogin() {
		System.out.println("You have Chosen to Login");
		BankLogin.checkUser();
		
	}
}
//test

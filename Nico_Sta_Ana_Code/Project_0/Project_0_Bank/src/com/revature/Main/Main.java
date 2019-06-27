package com.revature.Main;

import java.util.Scanner;

import com.revature.Bank.Bank;

public class Main {

	static Scanner scan = new Scanner(System.in);
	public static Bank bank = new Bank();
	
	public static void main(String[] args) {
		
		home();

	}
	
	static void home() {
		System.out.println("What would you like to do today? "
				+ "Please choose an option \n"
				+ "1. Create an Account \n"
				+ "2. Log In \n");
			
		String option = scan.nextLine();
		
		switch(option) {
		case "1": 
//			function for create an account;
			System.out.println("Enter Your first Name \n");
			String firstName = scan.nextLine();
			
			System.out.println("Enter Your Last Name \n");
			String lastName = scan.nextLine();
			
			System.out.println("Enter a username \n");
			String username = scan.nextLine();
			
			System.out.println("Enter a password");
			String password = scan.nextLine();
			
						
			bank.createUser(firstName, lastName, username, password);
			home();
//			System.out.println("CREATE ACCOUNT");
			break;
		case "2":
//			function to login
			
			System.out.println("Enter your username");
			String usernameLogIn = scan.nextLine();
			
			System.out.println("Enter your password");
			String passwordLogIn = scan.nextLine();
			
			if(bank.signIn(usernameLogIn, passwordLogIn)){
			loggedInOptions();
//			
//			if(bank.signIn("nf", "pass")) {
//				loggedInOptions();
//				
			}else {
				home();
			}
			break;
			default:
				System.out.println("PLEASE CHOOSE AN OPTION");
				home();
				
				
		}
	}
	
	
	static void loggedInOptions() {
		System.out.println("What would you like to do today? \n"
				+ "1. Check Balance \n"
				+ "2. Deposit \n"
				+ "3. Withdrawal \n"
				+ "4. Create Account \n"
				+ "5. Log Out \n");
		String option = scan.nextLine();
		
		
		
		switch(option) {
		case "1": 
			System.out.println("Enter your account number");
			String accountNum = scan.nextLine();
			
			System.out.println(bank.checkBalance(accountNum));
			loggedInOptions();
			break;
		case "2":
			System.out.println("Enter your account number");
			String accountNumDep = scan.nextLine();
			
			System.out.println("Enter a Deposit Amount \n");
			String depAmount = scan.nextLine();
			Double result = Double.parseDouble(depAmount);
			bank.deposit(result, accountNumDep);
//			
//			bank.deposit(1111, "1");
			loggedInOptions();
			break;
		case "3": 
			System.out.println("Enter your account number");
			String accountNumWithdrawal = scan.nextLine();
			
			
			System.out.println("Enter a Deposit Amount \n");
			String withdrawalAmount = scan.nextLine();
			Double result2 = Double.parseDouble(withdrawalAmount);
			bank.withdrawal(result2, accountNumWithdrawal);
//			bank.withdrawal(300000, "1");
			loggedInOptions();
		case "4": 
			
			System.out.println("Enter your initial deposit \n");
			String initialDep = scan.nextLine();
			Double result3 = Double.parseDouble(initialDep);
			
			System.out.println("Enter a type of account you want to create \n");
			String accountType = scan.nextLine();
			
			bank.createAccount(result3, accountType);
//			bank.createAccount(5000, "savings");
			loggedInOptions();
		case "5":

			bank.signOut();
			home();
			break;
			
			default:
				System.out.println("PLEASE CHOOSE AN OPTION");
				loggedInOptions();
				
				
		}
	}




}

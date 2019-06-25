package com.animoBank.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.animoBank.dao.BankAccountDAO;
import com.animoBank.dao.BankAccountTypeDAO;
import com.animoBank.dao.BankUserDAO;
import com.animoBank.pojo.BankAccount;
import com.animoBank.pojo.BankAccountType;
import com.animoBank.pojo.BankUser;

public class BankMain {

	static Scanner scan = new Scanner(System.in);
	static BankUserDAO bankUserDao = new BankUserDAO();
	static BankAccountDAO bacnkAccountDao = new BankAccountDAO();
//	static List<BankAccountType> bnkAccountType =  new ArrayList<BankAccountType>();
	static BankAccountTypeDAO bankAccountType = new BankAccountTypeDAO();

	public static void main(String[] args) {
		welcomePage();
		

//		List<BankUser> bnkusr = bankUserDao.findAll();
//		System.out.println(bankUserDao.findAll());

	}

	public static void LogIn() {
		System.out.println("Please Log In");
		String login = scan.nextLine();

		System.out.println("What is your Username?");
		String username = scan.nextLine();

		System.out.println("What is your Password");
		String password = scan.nextLine();
		BankUser newBankuser = new BankUser();

		System.out.println("Logging In ...");
		newBankuser = bankUserDao.findByUsername(username, password);
//		System.out.println(newBankuser);
		System.out.println(
				"WELCOME " + newBankuser.getFirstname() + " " + newBankuser.getLastname() + " " + "\n" + " \n");

		BankAccount accountInfo = bacnkAccountDao.findAccountById(newBankuser.getUserId());

		if (accountInfo == null) {
			System.out.println("OUR RECORDS SHOWS THAT YOU HAVE HAVE 0 ACCOUNTS OPEN" + " AT THE MOMENT \n" + " \n");

			System.out.println("WHAT WOULD YOU LIKE TO DO TODAY?\n" + " \n" + "PRESS: \n" + " \n"
					+ "1 - CREATE A NEW CHECKINGS ACCOUNT\n" + "2 - CREATE A NEW SAVINGS ACCOUNT");
		} else {
//			System.out.println(accountInfo.getAccType());
//			System.out.println(bankAccountType.findAllAccountType());
			List<String> accountType = bankAccountType.findAllAccountType();
//			System.out.println(accountType);
//			
			System.out.println("YOUR:\n");
			for (int i = 0; i < accountType.size(); i++) {
				
//				System.out.println(accountType.get(i));
				
				System.out.println( accountType.get(i)+ " ACCOUNT #" + accountInfo.getAccountId() +
						" BALANCE IS: $" + accountInfo.getBalance());
			}
			
//			BankAccountType Acctype = bankAccountType.findAccTypeBy(accountInfo.getAccType());
//			System.out.println("YOUR: \n " + Acctype.getType()+ " ACCOUNT #" + accountInfo.getAccountId() +
//					" BALANCE IS: $" + accountInfo.getBalance());
			
//			List<BankAccountType> Acctype = bankAccountType.findAccTypeBy(accountInfo.getAccType());
//			System.out.println("YOUR: \n " + Acctype + " ACCOUNT #" + accountInfo.getAccountId() +
//					" BALANCE IS: $" + accountInfo.getBalance());
			
		}

	}

//	public BankUser LogIn() {
//		System.out.println("Please Log In");
//		String login = scan.nextLine();
//		
//		System.out.println("What is your Username?");
//		String username = scan.nextLine();
//		
//		System.out.println("What is your Password");
//		String usrPassword = scan.nextLine();
//		
//		BankUserDAO.findByUsername(username,usrPassword);
//		
//	}

	public static void RegistrationPage() {
		System.out.println("Please fill out the form");
		String form = scan.nextLine();

		System.out.println("Firstname");
		String firstname = scan.nextLine();

		System.out.println("Lastname");
		String lastname = scan.nextLine();

		System.out.println("Username");
		String username = scan.nextLine();

		System.out.println("Password");
		String usrPassword = scan.nextLine();

	}

	public static void welcomePage() {
		System.out.println("Welcome to Animo Bank! What would you like to do? \n" + "1 - Register \n"
				+ "2 - Alreadly Registered? LogIn");
		int register = scan.nextInt();

		if (register == 1) {
			RegistrationPage();
		} else if (register == 2) {
			LogIn();
		} else {
			System.out.println(register + " is not a valid option\n"
					+ "please try again");
			welcomePage();
		}
	}

}

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
	static BankAccountDAO bankAccountDao = new BankAccountDAO();
	static List<BankAccountType> bnkAccountType = new ArrayList<BankAccountType>();
	static BankAccountTypeDAO bankAccountType = new BankAccountTypeDAO();

	public static void main(String[] args) {
		welcomePage();

	}

	public static void CreateBankAccount(BankUser user) {
		System.out.println(user.getFirstname() + " " + user.getLastname());

		System.out.println("WHAT TYPE OF ACCOUNT WOULD YOU LIKE TO OPEN?\n" + " \n" + "PRESS: \n" + " \n"
				+ "1 - NEW CHECKINGS ACCOUNT\n" + "2 - NEW SAVINGS ACCOUNT\n" + "3 - LOG-OUT");

		int accountOpt = scan.nextInt();

		switch (accountOpt) {
		case 1:
			bankAccountDao.prepareBankAccount(user, 2, "CHECKINGS");
			break;
		case 2:
			bankAccountDao.prepareBankAccount(user, 21, "SAVINGS");
			break;
		case 3:
			welcomePage();
		default:
			CreateBankAccount(user);
			break;
		}
	}

	public static void LogIn() {
		System.out.println("PLEASE LOGIN \n");

		System.out.println("PLEASE ENTER YOUR USERNAME");
		String username = scan.nextLine().toLowerCase();

		System.out.println("PLEASE ENTER YOUR PASSORD");
		String password = scan.nextLine();
		BankUser newBankuser = new BankUser();

		System.out.println("Loading......  Logging In....");
		newBankuser = bankUserDao.findByUsernameAndPassword(username, password);

		if (newBankuser == null) {
			System.out.println();
			System.out.println("INVALID USERNAME OR PASSWORD...PLEASE TRY AGAIN!");
			LogIn();
		} else {

			logInSuccess(newBankuser);
		}
	}

	public static void logInSuccess(BankUser newBankuser) {

		System.out.println(
				"WELCOME " + newBankuser.getFirstname() + " " + newBankuser.getLastname() + " " + "\n" + " \n");

		BankAccount accountInfo = bankAccountDao.getOneAccountById(newBankuser.getUserId());
		List<BankAccount> listAccountInfo = bankAccountDao.findAccountById(newBankuser.getUserId());

		if (accountInfo == null) {
			System.out.println("OUR RECORDS SHOWS THAT YOU HAVE HAVE 0 ACCOUNTS OPEN" + " AT THE MOMENT \n" + " \n");
			CreateBankAccount(newBankuser);
		} else {
			for (BankAccount account : listAccountInfo) {
				System.out.println(account);
			}

			List<String> accountType = bankAccountType.findAllAccountType();

			System.out.println("WHAT WOULD YOU LIKE TO DO TODAY? \n " + "\n" + "1 - OPEN A NEW BANK ACCOUNT \n" + " \n"
					+ "2 - DEPOSITE INTO AN EXSISTING ACCOUNT \n " + " \n" + "3 - WITHDRAW FROM AN EXISTING ACCOUNT \n "
					+ "\n" + "4 - LOG-OUT");

			String option = scan.nextLine();

			switch (option) {
			case "1":
				CreateBankAccount(newBankuser);
				break;
			case "2":
				BankAccountDAO.prepareDeposite(accountInfo);
				break;
			case "3":
				BankAccountDAO.prepareWithdraw(accountInfo, newBankuser);
				break;
			case "4":
				welcomePage();
			default:
				System.out.println("INVALID SELECTION PLEASE TRY AGAIN!\n \n \n ");
				logInSuccess(newBankuser);

			}

		}
	}

	public static void RegistrationPage() {
		System.out.println("Please fill out the form");

		System.out.println("PLEASE ENTER YOUR FIRSTNAME");
		String firstname = scan.nextLine();

		System.out.println("PLEASE ENTER YOUR LASTNAME");
		String lastname = scan.nextLine();

		System.out.println("PLEASE ENTER A USERNAME");
		String username = scan.nextLine();
		// bankUserDao.findByUsername(username);

		System.out.println("PLEASE ENTER A PASSWORD");
		String usrPassword = scan.nextLine();

		BankUser newMember = new BankUser();
		newMember.setFirstname(firstname);
		newMember.setLastname(lastname);
		newMember.setUsername(username.toLowerCase());
		newMember.setUsrPassword(usrPassword);
		newMember = bankUserDao.registerMember(newMember);
		System.out.println(
				"REGISTRATION SUCCESS" + " " + newMember.getFirstname() + " " + newMember.getLastname() + "  \n "
						+ "Loading.... \n");

		LogIn();

	}

	public static void welcomePage() {
		System.out.println("Welcome to Animo Bank! What would you like to do? \n" + "1 - Register \n"
				+ "2 - Alreadly Registered? LogIn");
		String register = scan.nextLine();

		if (register.equalsIgnoreCase("1")) {
			RegistrationPage();
		} else if (register.equalsIgnoreCase("2")) {
			LogIn();
		} else {
			System.out.println(register + " is not a valid option\n" + "please try again");
			welcomePage();
		}
	}

}
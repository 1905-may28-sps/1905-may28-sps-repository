package com.revature.app;

import java.util.List;
import java.util.Scanner;

import com.revature.daos.AccountDao;
import com.revature.daos.UserDao;
import com.revature.pojos.Account;
import com.revature.pojos.User;

public class BankApp {
	
	static Scanner scan = new Scanner(System.in);
	static UserDao userDao = new UserDao();
	static AccountDao accountDao = new AccountDao();
	static User existingUserForAccounts = new User();
	static Account existingAccountHolder = new Account();
	static Account newCheckingAcc = new Account();
	static Account newSavingsAcc = new Account();

	public static void main(String[] args) {
		
		loginMenu();

	}
	
	public static void loginMenu() {
		System.out.println("\nWelcome to Lord Estate Bank!\nPlease choose from the following options:\n"
								+ "1. Register as a New User\n"
								+ "2. Login for Existing Users");
		try {
			int option = Integer.parseInt(scan.nextLine());
			
			switch(option) {
			case 1: register();
			break;
			case 2: login();
			break;
			default: System.out.println("****************************************\nInvalid.  Try Again.\n****************************************\n");
				loginMenu();
			break;
			}
		}catch(NumberFormatException e) {
			System.out.println("****************************************\nPlease enter a number!\n****************************************\n");
			loginMenu();
		}
	}
		
	public static void register() {
		
		System.out.println("\nThank you for choosing to register with Lord Estate Bank.");
		System.out.println("What is your first name?");
		String fn = scan.nextLine();
		System.out.println("What is your last name?");
		String ln = scan.nextLine();
		System.out.println("What is your email address?");
		String email = scan.nextLine();
		System.out.println("What is your chosen login name?");
		String logn = scan.nextLine();
		User newUser = new User();
		newUser.setFirstName(fn);
		newUser.setLastName(ln);
		newUser.setEmail(email);
		newUser.setLoginName(logn);
		while(userDao.getUserByUserName(logn)!=null) {
			System.out.println("****************************************\nThat login name is already taken, please try again.\n****************************************\n");
			System.out.println("What is your chosen login name?");
			logn = scan.nextLine();
		}
		newUser.setLoginName(logn);
		System.out.println("What is your chosen password?");
		String pw = scan.nextLine();
		newUser.setPassword(pw);
		newUser = userDao.save(newUser);
		System.out.println("****************************************\nThank you for registering.\nHere are your registration details.\nPlease store them in a safe place.\n****************************************\n" + newUser);
		loginMenu();
	}
	
//	public static List<User> viewUsers() {
//		List<User> users = userDao.findAll();
//		for(User u : users) {
//			System.out.println(u);
//		}
//		return users;
//	}
	
	public static void login() {
		
		System.out.println("\nWelcome Back to Lord Estate Bank.");
		System.out.println("What is your login name?");
		String exlogn = scan.nextLine();
		User existingUser = new User();
		existingUser.setLoginName(exlogn);
		while(userDao.getUserByUserName(exlogn)==null) {
			System.out.println("****************************************\nIncorrect login name, please try again.\n****************************************\n");
			System.out.println("What is your login name?");
			exlogn = scan.nextLine();
		}		
		System.out.println("What is your password?");
		String expw = scan.nextLine();
		existingUser.setPassword(expw);
		while(userDao.getUserByUserNameAndPassword(exlogn,expw)==null) {
			System.out.println("\n****************************************\nIncorrect password, please try again.\n****************************************\n");
			System.out.println("What is your password?");
			expw = scan.nextLine();
		}
		existingUser.setPassword(expw);
		existingUser=userDao.getUserByUserNameAndPassword(exlogn,expw);
		System.out.println("\n****************************************\nLogin successful!\n****************************************\n");
		existingUserForAccounts = existingUser;
		accountMenu(existingUser.getUserId());
	}
	
	public static void accountMenu(Integer exUser) {
		
		System.out.println("\nThank you for logging in.\nHere are your profile details.\n" + existingUserForAccounts);
		List<Account> existingAccounts = AccountDao.showAccountDetails(existingUserForAccounts.getUserId());
		if(existingAccounts.isEmpty()) {
			System.out.println("\nYou have no accounts.\nWhich account would you like to create?\n");
			savingOrCheckingMenu();
			} else{
			System.out.println("Here are your account details.\n"
				+ existingAccounts);
			System.out.println("Would you like to create a new account or access your account?");
			createOrAccess();
				}
	}
		
		public static void createOrAccess() {
			System.out.println(
					"\n1. Create a new account\n"
					+"2. Access Account\n");
			try {
				int option = Integer.parseInt(scan.nextLine());
				
				switch(option) {
				case 1: savingOrCheckingMenu();
				break;
				case 2: List<Account> existingAccounts = AccountDao.showAccountDetails(existingUserForAccounts.getUserId());
				System.out.println("Here are your account details.\n"
						+ existingAccounts);
				System.out.println("\nWhich account would you like to access?\nPlease choose using Account ID.\n");
				AccountIDAccess();				
				break;
				default: System.out.println("\n****************************************\nInvalid.  Try Again.\n****************************************\n");
					createOrAccess();
				break;
				}
			}catch(NumberFormatException e) {
				System.out.println("\n****************************************\nPlease enter a number!\n****************************************\n");
					createOrAccess();
			}
		}
	
		public static void savingOrCheckingMenu() {
			System.out.println(
					"\n1. Checking Account\n"
					+ "2. Savings Account\n");
		try {
			int option = Integer.parseInt(scan.nextLine());
			
			switch(option) {
			case 1: checking();
			break;
			case 2: savings();
			break;
			default: System.out.println("\n****************************************\nInvalid.  Try Again.\n****************************************\n");
				savingOrCheckingMenu();
			break;
			}
		}catch(NumberFormatException e) {
			System.out.println("\n****************************************\nPlease enter a number!\n****************************************\n");
			savingOrCheckingMenu();
		}
	}
		
		public static void AccountIDAccess() {
			int accessAccountID = Integer.parseInt(scan.nextLine());
			Account chosenAccount = AccountDao.chosenAccountDetail(accessAccountID);
			existingAccountHolder=chosenAccount;
			System.out.println("Here are your account details." + chosenAccount);
			withdrawOrDepositMenu();}
		
		
		public static void checking() {
			System.out.println("\nThank you for choosing to create a Checking Account.");
			String ca = "checking";
			int ui = existingUserForAccounts.getUserId();
			Double bc = 0.00;
			Account newCheck = new Account();
			newCheck.setBalance(bc);
			newCheck.setUserId(ui);
			newCheck.setAccountType(ca);
			newCheck = accountDao.newAccount(newCheck);
			newCheckingAcc = newCheck;
			System.out.println("\nHere is your new Checking Account balance information.\n" + newCheck);
			List<Account> existingAccounts = AccountDao.showAccountDetails(existingUserForAccounts.getUserId());
			System.out.println("Here are your account details.\n"
					+ existingAccounts);
		System.out.println("\nWhich account would you like to access?\nPlease choose using Account ID.\n");
			AccountIDAccess();
		}

		private static void savings() {
			System.out.println("\nThank you for choosing to create a Savings Account");
			String sa = "savings";
			int ui = existingUserForAccounts.getUserId();
			Double bc = 0.00;
			Account newSav = new Account();
			newSav.setBalance(bc);
			newSav.setUserId(ui);
			newSav.setAccountType(sa);
			newSav = accountDao.newAccount(newSav);
			newSavingsAcc = newSav;
			System.out.println("\nHere is your new Savings Account balance information.\n" + newSav);
			List<Account> existingAccounts = AccountDao.showAccountDetails(existingUserForAccounts.getUserId());
			System.out.println("Here are your account details.\n"
					+ existingAccounts);
			System.out.println("\nWhich account would you like to access?\nPlease choose using Account ID.\n");
			AccountIDAccess();
		}
		
		public static void withdrawOrDepositMenu() {
			System.out.println("\nWould you like to withdraw money or deposit money?\n"
					+ "1. Withdraw Money\n"
					+ "2. Deposit Money\n");
		
		try {
			int option = Integer.parseInt(scan.nextLine());
			
			switch(option) {
			case 1: withdraw();
			break;
			case 2: deposit();
			break;
			default: System.out.println("****************************************\nInvalid.  Try Again.\n****************************************\n");
			withdrawOrDepositMenu();
			break;
			}
		}catch(NumberFormatException e) {
			System.out.println("****************************************\nPlease enter a number!\n****************************************\n");
			withdrawOrDepositMenu();
		}
	}

		private static void withdraw() {
			System.out.println("How much money would you like to withdraw?");
			double withd = Double.parseDouble(scan.nextLine());
			int uid = existingAccountHolder.getUserId();
			int accid = existingAccountHolder.getAccountId();
			while((accountDao.checkWithdraw(uid, accid)-withd)<0) {
				System.out.println("Withdrawal denied.\nYou are attempting to withdraw more than your available balance.\nPlease resubmit your withdrawal request.");
				withd = Double.parseDouble(scan.nextLine());
			}
			double withdrawAcc = accountDao.withdrawMoney(withd,existingAccountHolder.getUserId(),existingAccountHolder.getAccountId());
			System.out.println("Thank you for withdrawing $" + withdrawAcc);
			Double withdrawBal=existingAccountHolder.getBalance()-withdrawAcc;
			System.out.println("Here is your remaining balance: $" + withdrawBal);
			System.out.println("Would you like to logout or choose another checking or savings account?");
			logoutMenu();
		}
		
		private static void deposit() {
			System.out.println("How much money would you like to deposit?");
			double depd = Double.parseDouble(scan.nextLine());
			double depositAcc = accountDao.depositMoney(depd,existingAccountHolder.getUserId(),existingAccountHolder.getAccountId());
			System.out.println("Thank you for depositing $" + depositAcc);
			Double depositBal=existingAccountHolder.getBalance()+depositAcc;
			System.out.println("Here is your remaining balance: $" + depositBal);
			System.out.println("Would you like to logout or choose another checking or savings account?");
			logoutMenu();
		}
		
		public static void logoutMenu() {
			System.out.println(
					"\n1. LogOut\n"
					+ "2. Access Checking or Savings Account.\nFor security purposes, you must login again.\n");
		
		try {
			int option = Integer.parseInt(scan.nextLine());
			
			switch(option) {
			case 1: logOut();
			break;
			case 2: login();
			break;
			default: System.out.println("\n****************************************\nInvalid.  Try Again.\n****************************************\n");
				logoutMenu();
			break;
			}
		}catch(NumberFormatException e) {
			System.out.println("\n****************************************\nPlease enter a number!\n****************************************\n");
			logoutMenu();
		}
	}
		
		public static void logOut() {
			System.out.println("\nThank you for visiting Lord Estate Bank.\nHave a nice day.");
		}
			
		}
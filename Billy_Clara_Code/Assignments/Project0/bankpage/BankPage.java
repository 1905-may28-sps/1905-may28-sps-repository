package com.revature.bankpage;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Scanner;

import com.revature.pojo.Account;
import com.revature.pojo.BankUser;
import com.revature.DAO.AccountDao;
import com.revature.DAO.UserDao;



public class BankPage{
	static Scanner myScan = new Scanner(System.in);
	static UserDao user = new UserDao();
	static AccountDao userAcc = new AccountDao();
	
	
	
	
	public static void main(String[] args) {
		mainMenu();
		//System.out.println(userAcc.findByOwner(83));
//		System.out.println(user.findAll());
		
//		BankUser b = user.findByUsername("");
//		System.out.println(b);	
	}
		
		static void mainMenu() {
		System.out.println("Welcome to Bill's Bank");
		System.out.println("What would you like to do today \r"
				+"Press 1: To log into your account\r"
				+"Press 2: If you do not have an account and would like to create one"
				);
		
		//String option = myScan.nextLine();
		
		try {
		int option = Integer.parseInt(myScan.nextLine());
		switch(option) {
		//switch(Integer.parseInt(option)) {
		case 1: logIn(); break;
		case 2: createAccount(); break;
		default:}
		}
		catch(NumberFormatException e) {
			System.out.println("Input not valid. Please enter a valid option! \r"
					+ "------------------------------ \r"
					+ "------------------------------ \r");
			mainMenu();
		}
			
		
		
		
	}
	
	static void logIn() {
		System.out.println("Welcome please enter your Username \r"
				+"Note: Case Sensitive");
		String un = myScan.nextLine();
		System.out.println("Please enter your password \r"
				+"Note: Passwords are case sensitive");
		String pw = myScan.nextLine();
		
	

			BankUser b = user.findByUsername(un, pw);
			if( b == null) {
				System.out.println("You have entered a wrong Username or password \r"
						+"Please try again");
				logIn();
			}else {
				System.out.println(b +"." + " " + "\r" + "What would you like to do today?");

				UserPage();
				
			}
	}
			
	static void UserPage() {
			System.out.println("Enter 1: Deposit Into Account. \r"
					+"Enter 2: Withdraw from Account. \r"
					+"Enter 3: Log out and return to the Main Menu");
			
			
			
			//String opt = myScan.nextLine();
			//switch(Integer.parseInt(opt)) {
			try {
				int option = Integer.parseInt(myScan.nextLine());
				switch(option) {
			case 1: deposit(); break;
			case 2: withdraw(); break;
			case 3: mainMenu(); break;
			
			default:
				System.out.println("Please enter a valid option");
				UserPage();
				
			} 
			} catch (NumberFormatException e) {
				System.out.println("Input not valid. Please enter a valid option! \r"
						+ "------------------------------ \r"
						+ "------------------------------ \r");
				UserPage();
			}

		}

//		System.out.println("Enter your password");
//		String pw = myScan.nextLine();
		
	
	
	static void createAccount() {
		
		System.out.println("Hi, to create a new account enter your First Name");
		String fn = myScan.nextLine();
		
		System.out.println("Please enter your last name");
		String ln = myScan.nextLine();
		System.out.println("Enter an E-mail address");
		String email = myScan.nextLine();
		System.out.println("Enter a unique Username");
		String un = myScan.nextLine();
		System.out.println("Enter a password");
		String pw = myScan.nextLine();
		BankUser newuser = new BankUser();
		newuser.setFirstName(fn);
		newuser.setLastName(ln);
		newuser.setEmail(email);
		newuser.setUserName(un);
		newuser.setPassword(pw);
		newuser = user.save(newuser);
		
		

		System.out.println(newuser);
		System.out.println("Account Created Succesfully! You will be redirected to the Initial Deposit Page \r"
				+"--------------------------------- \r"
				+"--------------------------------- \r");
		firstDeposit();
	
		
	
}
	
	static void firstDeposit() {
		System.out.println("How much is your initial deposit?");
		double depo = Double.parseDouble(myScan.nextLine());
		System.out.println("Please enter the Unique BANKUSERID given to you during registration");
		int id = Integer.parseInt(myScan.nextLine());
		Account newacc = new Account();
		newacc.setBalance(depo);
		newacc.setAccountOwner(id);
		
		newacc = userAcc.save(newacc);
		
		System.out.println("Your deposit has been recorded succesfully.\r"
				+"Below is a summary of your account.");
		System.out.println(userAcc.findByOwner(id));
		System.out.println("You will be redirected to the User's Page");
		UserPage();
		
		
	}
	
	static void deposit() {
		try {System.out.println("Please enter your BANKUSERID Number in order to proceed.");
		int UI = Integer.parseInt(myScan.nextLine());
		System.out.println(userAcc.findByOwner(UI));
		
		System.out.println("Please Enter your ACCOUNT ID to make a deposit.");
		int AI = Integer.parseInt(myScan.nextLine());

		Account a = userAcc.findById(AI);
		
		System.out.println("How much would you like to deposit today?");
		double dep = Double.parseDouble(myScan.nextLine());
		userAcc.update(a, dep);
		System.out.println("Deposit was succesful...\r"
				+"----------------------\r"
				+"----------------------\r");
		
		System.out.println(userAcc.findById(AI));
		UserPage();
		}
	
		catch (NullPointerException e) {
		System.out.println("Not a valid ID. Please enter a Valid Unique ID\r"
				+"----------------------\r");
		deposit();
		
	}
	}
	static void withdraw() {
		try {System.out.println("Please enter your BANKUSERID Number to pull up your ACCOUNT ID.");
		int UI = Integer.parseInt(myScan.nextLine());
		System.out.println(userAcc.findByOwner(UI));


		System.out.println("Enter ACCOUNT ID in order to withdraw");
		int AI = Integer.parseInt(myScan.nextLine());
		
		Account a = userAcc.findById(AI);

		
		System.out.println("How much would you like to withdraw today?");
		double wit = Double.parseDouble(myScan.nextLine());
		userAcc.update(a, -wit);
		System.out.println("Withdrawal was succesful...\r"
				+"----------------------\r"
				+"----------------------\r");
		System.out.println(userAcc.findById(AI));
		UserPage();
		}
		catch (NullPointerException e) {
			System.out.println("Not a valid ID. Please enter a Valid Unique ID\r"
					+"----------------------\r");
			withdraw();
		}
	}
	
//	static void updateBankUser() {
//		System.out.println("Please enter Your Unique ID");
//		
//		try {
//			int id = Integer.parseInt(myScan.nextLine());
//			BankUser buser = a.getId(id);
//				System.out.println("Enter your new Email, "
//						+ "If you don't want to change your Email, Please enter n. ");
//				String em = myScan.nextLine();
//				System.out.println("Enter your new UserName. "
//						+ "If you dont't want to change your UserName, please enter n");
//				String un = myScan.nextLine();
//				System.out.println("Enter your new password. "
//						+ "If you don't want to change your Password, please enter n");
//				String pw = myScan.nextLine();
//				
//				if(!em.equalsIgnoreCase("n")) buser.setEmail(em);
//				if(!un.equalsIgnoreCase("n")) buser.setUserName(un);
//				if(!pw.equalsIgnoreCase("n")) buser.setPassword(pw);
//				
//				user.updateBankUser(buser);
//					
//			
//		}	catch(NumberFormatException e) {
//		}
//	}
}

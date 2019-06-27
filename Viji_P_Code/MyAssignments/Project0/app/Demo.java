package com.revature.app;

import java.util.List;
import java.util.Scanner;

import com.revature.dao.UserDAO;
import com.revature.dao.AccountDAO;
import com.revature.pojos.User;
import com.revature.pojos.Account;

public class Demo {

	public static void main (String args[]){
		
		String option;
		
	System.out.println("Welcome to the Bank!!!");
	System.out.println("Would you like to choose an Option: \n"
			+ "1.New User - Create Account \n"
			+ "2.Login - Existing Account \n" );
	System.out.println("Please choose your option:");
	
	Scanner scan = new Scanner(System.in);
	option = scan.nextLine();
	int bal;
	int amount;
	
	switch(option) {
	
	case "1":
		    System.out.println("Opening a New Account: ");
		     
		 	System.out.println("Enter your Firstname: ");
			String fn = scan.nextLine();
			System.out.println("Enter your Lastname: ");
			String ln = scan.nextLine();
			System.out.println("Enter Username: ");
			String un = scan.nextLine();
			System.out.println("Enter Password: ");
			String pw = scan.nextLine();
			System.out.println("Enter the amount to be depostited: ");
			bal = scan.nextInt();
			User userObject = new User();
			Account accObject = new Account();
			System.out.println("Enter 1-Checking Account 2-Saving Account");
			int option1 = scan.nextInt();
			if(option1 == 1) {
				
				accObject.setAccType("Checking Account");
				}
			else if (option1 == 2){
				accObject.setAccType("Saving Account");
				}
			else {
				System.out.println("Invalid Account type");
			}
			
			userObject.setFirstname(fn);
			userObject.setLastname(ln);
			userObject.setUsername(un);
			userObject.setPassword(pw);
			
			UserDAO daoObject = new UserDAO();
			User UserObjectwithID = daoObject.save(userObject);
			
			accObject.setBalance(bal);
			accObject.setOwner(UserObjectwithID.getId());
			
			AccountDAO accDaoObject = new AccountDAO();
			Account acct = 	accDaoObject.saveAcc(accObject);

			System.out.println("Thank you for banking with us!");
		    break;
		     
	case "2":
			System.out.println("Enter your username: ");
			String username = scan.nextLine();
			System.out.println("Enter your password: ");
			String password = scan.nextLine();
			User userObject1 = new User();
			userObject1.setUsername(username);
			userObject1.setPassword(password);
			
			UserDAO exUserObj = new UserDAO();
			boolean UserExists =  exUserObj.checkUser(userObject1);
		//	System.out.println("User Exists "+UserExists);
			
			if (UserExists == false) {
				System.out.println("Invalid Username/Password. Please Try Again!");
				break;
			}
			
			else {
			
			System.out.println("Logged in Successfully");
			
			AccountDAO accDao1 = new AccountDAO();
			List<Account> Acctinfo = accDao1.displayAccountInfo(username);
		//	System.out.println("Account Info: "+ Acctinfo);
			int AcctNum =0;
			int AcctBal=0;
			for (Account AcctObj : Acctinfo) {
				
				AcctNum = AcctObj.getAcc_id();
				AcctBal = AcctObj.getBalance();
				System.out.println ("Acct Number :" +AcctNum);
				System.out.println ("Balance :" +AcctBal);
			}
						
			System.out.println("Press 1 - Deposit 2 - Withdraw ");
					
			String option2= scan.nextLine();
			
			switch (option2) {
			
				
				case "1":
					System.out.println("Deposit");
					System.out.println("Enter Amount:");
					amount = scan.nextInt();
					AcctBal = AcctBal + amount;
					boolean updateStatus = accDao1.updateBalance(AcctBal, AcctNum);
				
				    System.out.println("Update Status: " + updateStatus);
					System.out.println("Final Balance: " + AcctBal);
					break;
					
				case "2":
					System.out.println("Withdraw");
					System.out.println("Enter Amount:");
					amount = scan.nextInt();
					if (amount >= AcctBal) 
					{
						System.out.println("Oops... Insufficent Fund");
						System.out.println("Thank you for banking with us...");
						
					}
					else 
					{
						AcctBal = AcctBal - amount;
						System.out.println("Final Balance: " + AcctBal);
						boolean updateStatus1 = accDao1.updateBalance(AcctBal, AcctNum);
						System.out.println("Update Status: " + updateStatus1);
						System.out.println("Thank you for banking with us...");
						
					}
				break;	
				default:System.out.println("Enter Valid Option");
			}
			
			
			break;
			}		
	default: System.out.println("Please enter valid option");
	}
	
	}

	
	
}

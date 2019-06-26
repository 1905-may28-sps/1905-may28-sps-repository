package BankJava;

import java.sql.*;

import java.util.*;


import DAO.UserDao;
import POJO.Users;
import DAO.AccountDao;
import POJO.Accounts;
import util.ConnectionFactory;

public class HomePage {
	public static void main(String[] args) {
		//test
		
		//int a=37;
		//ViewUsersAccounts(a);
	}
//	public static void test(){
//		
//		CreateOrView();
//	}
	
	public static void CreateOrView(Users User){
		//AccountDao ADao = new AccountDao();
		//Users returningUser=  new Users();
		System.out.println("Welcome "+ User.getFName() + " "+ User.getLName());
		ScanCreateCheckorView(User);
		
		//ViewUsersAccounts(User);
		
	
	}
	
	public static void ScanCreateCheckorView(Users user) {
		System.out.println("Please select 1 to view/go to your accounts or select 2 to create a new account or 3 to logout");
		Scanner in = new Scanner(System.in);//get input
		String choice = in.nextLine();//change input
		switch(choice) {
		case "1": System.out.println("view current accounts");//temp change to function
			ViewUsersAccounts(user);
			break;
		case "2": System.out.println("create new account");
		//ScanCheckOrSav(user);
		createCheckOrSav(user);
			break;
		case "3": System.out.println("Logging out....");BankFirst.LogOrReg(); 
		default: 
			System.out.println("Incorrect Input, Please press 1 to Login or press 2 to Register or 3 to logout");
			ScanCreateCheckorView(user);
		}
	}
	
	private static void createCheckOrSav(Users user) {
		Scanner scan = new Scanner(System.in);
		AccountDao ADao = new AccountDao();
		System.out.println("Please Enter your initial Deposit");
		String inSDeposit = scan.nextLine();
		double inDeposit= Double.parseDouble(inSDeposit);
		//create a check for numbers not with two decimal places later on...
		System.out.println("Please Enter wheher you want a checking or savings account");
		String actType = scan.nextLine();
		
		Accounts newAcct = new Accounts();
		newAcct.setBalance(inDeposit);
		newAcct.setAccount_Type(actType);	
		newAcct.setUser_id(user.getUser_id());
		newAcct = ADao.createaccount(newAcct);
		
		
	}
	private static void ViewUsersAccounts(Users user) {
		// TODO Auto-generated method stub
		AccountDao aDao = new AccountDao();
		List<Accounts> viewAccounts = aDao.findUserAccounts(user.getUser_id());
		if(!viewAccounts.isEmpty()) {
			for(Accounts account: viewAccounts) {
				System.out.println(account);
			}
			WDGL(user);
			//withdraw, deposit, go back, logout
			
		}
		else {
			System.out.println("You do not have any accounts, please create one now!");
			createCheckOrSav(user);
		}
		//test to see if it works System.out.println(viewAccounts);
		
	}
	//withdraw deposit logout potentially also send money to other accounts 
	private static void WDGL(Users user) {
		System.out.println("1 For Withdrawal, 2 for Deposit, 3 Logout");
		Scanner in = new Scanner(System.in);//get input
		String choice = in.nextLine();//change input
		switch(choice) {
		case "1": 
//		"withdraw";
		withdrawMoney(user);
		
		break;	
	
			
		case "2": 
		depositMoney(user);	
		break;	
		//return "saving";
		
		case "3": System.out.println("Logging out...");
		BankFirst.LogOrReg();
		break;	
		/*case"4" : sendmoney to another account num(doesn't matter to who)  will work on it if time permits
		*/
		default: 
			System.out.println("Incorrect Input, Please press 1 for Withdrawal, 2 for Deposit, 3 to Logout");
			//ScanCheckOrSav(user);
		}
		
	}
	private static void depositMoney(Users user) {
		// TODO Auto-generated method stub
		AccountDao ADao = new AccountDao();
		System.out.println("Which account would you like to deposit into?");
		Scanner in = new Scanner(System.in);//get input
		String actnum = in.nextLine();//change input
		Integer AcctNum=Integer.parseInt(actnum);
		System.out.println("How much would you like to deposit?");
		String mon = in.nextLine();//change input
		Double money=Double.parseDouble(mon);
		Accounts newAcct = new Accounts();
		
		newAcct.setBalance(money);
		newAcct.setAccount_num(AcctNum);	
		newAcct.setUser_id(user.getUser_id());
		newAcct = ADao.WithdrawDeposit(newAcct);
		System.out.println("Logging you out now...");
		BankFirst.LogOrReg();
	}
	private static void withdrawMoney(Users user) {
		// TODO Auto-generated method stub
		
		AccountDao ADao = new AccountDao();
		System.out.println("Which account would you like to withdraw from?");
		Scanner in = new Scanner(System.in);//get input
		String actnum = in.nextLine();//change input
		Integer AcctNum=Integer.parseInt(actnum);
		System.out.println("How much would u like to withdraw");
		String mon = in.nextLine();//change input
		Double money=Double.parseDouble(mon);
		Accounts newAcct = new Accounts();
		
		newAcct.setBalance(-money);
		newAcct.setAccount_num(AcctNum);	
		newAcct.setUser_id(user.getUser_id());
		newAcct = ADao.WithdrawDeposit(newAcct);
		System.out.println(newAcct);
		
		System.out.println("Logging you out now...");
		BankFirst.LogOrReg();
		
		
	}
	//not necessary,will implement in  the future... to keep checking and saving type consistent wont need to ask for user input
//	public static void ScanCheckOrSav(Users user) {
//		System.out.println("1 For Checking, 2 For Saving, 3 to go back");
//		Scanner in = new Scanner(System.in);//get input
//		String choice = in.nextLine();//change input
//		switch(choice) {
//		case "1": System.out.println("Create a checking account");//temp change to function
//		withdrawFAcct();
//		break;	
//	//	return "checking";
//			
//		case "2": System.out.println("Create a saving account");
//		depositIAcct();
//			//create another switch statement
//		break;	
//		//return "saving";
//		
//		case "3": System.out.println("Return to Homepage");
//		ScanCreateCheckorView(user);
//		break;	
//		default: 
//			System.out.println("Incorrect Input, Please press 1 for Checking, 2 for Saving, 3 to go back");
//			ScanCheckOrSav(user);
//		}
//		
//	}
//	private static void depositIAcct() {
//		// TODO Auto-generated method stub
//		
//	}
//	private static void withdrawFAcct() {
//		// TODO Auto-generated method stub
//		
//	}
	
	
	
}

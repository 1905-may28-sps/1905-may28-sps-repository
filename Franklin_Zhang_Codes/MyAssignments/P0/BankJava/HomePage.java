package BankJava;

import java.sql.*;
import java.util.*;
import DAO.UserDao;
import POJO.Users;
import DAO.AccountDao;
import POJO.Accounts;
import util.ConnectionFactory;
import ExceptionBank.CustomException;

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
		try {
		Scanner scan = new Scanner(System.in);
		AccountDao ADao = new AccountDao();
		System.out.println("Please Enter your initial Deposit");
		String inSDeposit = scan.nextLine();
		double inDeposit= Double.parseDouble(inSDeposit);
		//create a check for numbers not with two decimal places later on...
		System.out.println("Please Enter wheher you want a checking or savings account");
		//String actType = scan.nextLine();
		String actType=switchCheckorSave();
		
		Accounts newAcct = new Accounts();
		newAcct.setBalance(inDeposit);
		newAcct.setAccount_Type(actType);	
		newAcct.setUser_id(user.getUser_id());
		newAcct = ADao.createaccount(newAcct);
		ScanCreateCheckorView(user);
		}catch (NumberFormatException e) {
			System.out.println("You have entered an invalid input please try again");
			createCheckOrSav(user);
		}
		
	}
	private static String switchCheckorSave() {
		// TODO Auto-generated method stub
		System.out.println("Please select 1 for checking account, 2 for saving account");
		Scanner in = new Scanner(System.in);//get input
		String choice = in.nextLine();
		switch(choice) {
		case "1": System.out.println("You have selected checking account");//temp change to function
		return "checking";
		case "2": System.out.println("you have selected saving account");
		return "saving";
		default: 
			System.out.println("Incorrect Input, Please press 1 for checking 2 for saving.");
			switchCheckorSave();
		}
		
		return null;
	}

	public static void ViewUsersAccounts(Users user) {
		// TODO Auto-generated method stub
		AccountDao aDao = new AccountDao();
		List<Accounts> viewAccounts = aDao.findUserAccounts(user.getUser_id());
		if(!viewAccounts.isEmpty()) {
			
			for(Accounts account: viewAccounts) {
				System.out.println(account);
				
			}
			WDGL(user);
			//withdraw, deposit, logout
			
		}
		else {
			System.out.println("You do not have any accounts, please create one now!");
			createCheckOrSav(user);
			 ScanCreateCheckorView(user);
		}
		//test to see if it works System.out.println(viewAccounts);
		
	}
	//withdraw deposit logout potentially also send money to other accounts 
	public static void WDGL(Users user) {
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
	
		
		case "3": 
			System.out.println("Logging out...");
			BankFirst.LogOrReg();
			break;	
		/*case"4" : sendmoney to another account num(doesn't matter to who)  will work on it if time permits
		*/
		default: 
			System.out.println("Incorrect Input, Please press 1 for Withdrawal, 2 for Deposit, 3 to Logout");
			WDGL(user);
		}
		
	}
	private static void depositMoney(Users user) {
		// TODO Auto-generated method stub
		try {
		AccountDao ADao = new AccountDao();
		System.out.println("Which account would you like to deposit into?");
		Scanner in = new Scanner(System.in);//get input
		String actnum = in.nextLine();//change input
		Integer AcctNum=Integer.parseInt(actnum);
		System.out.println("How much would you like to deposit?");
		String mon = in.nextLine();//change input
		Double money=Double.parseDouble(mon);
		try {
			CustomException.validate(money);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Excepion occured" + e);
			depositMoney(user);
			
		}
		Accounts newAcct = new Accounts();
		
		newAcct.setBalance(money);
		newAcct.setAccount_num(AcctNum);	
		newAcct.setUser_id(user.getUser_id());
		newAcct = ADao.WithdrawDeposit(newAcct);
		System.out.println("Transaction pending....");
		transactionCheck(user.getUser_id(),AcctNum);
		}catch(NumberFormatException e) {
			System.out.println("You have entered an invalid input, please try again!");
			withdrawMoney(user);
		}
	}
	private static void withdrawMoney(Users user) {
		// TODO Auto-generated method stub
		try {
		AccountDao ADao = new AccountDao();
		System.out.println("Which account would you like to withdraw from?");
		Scanner in = new Scanner(System.in);//get input
		String actnum = in.nextLine();//change input
		Integer AcctNum=Integer.parseInt(actnum);
		System.out.println("How much would u like to withdraw");
		String mon = in.nextLine();//change input
		Double money=Double.parseDouble(mon);
		try {
			CustomException.validate(money);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Excepion occured" + e);
			withdrawMoney(user);
			
		}
		Accounts newAcct = new Accounts();
		newAcct.setBalance(-money);
		newAcct.setAccount_num(AcctNum);	
		newAcct.setUser_id(user.getUser_id());
		newAcct = ADao.WithdrawDeposit(newAcct);
		//System.out.println(newAcct);
		System.out.println("Transaction pending....");
		transactionCheck(user.getUser_id(),AcctNum);
		}catch (NumberFormatException e) {
			System.out.println("You have entered an invalid input, please try again!");
			withdrawMoney(user);	
		}

		
		
	}


	private static void transactionCheck(int user_id, int acctNum) {
		Users user= new Users();
		user.setUser_id(user_id);
		//System.out.println(user_id + "check here plz");
		AccountDao ADao = new AccountDao();
		Accounts newAcct = new Accounts();
		newAcct.setUser_id(user_id);
	//	System.out.println(user_id);
		newAcct.setAccount_num(acctNum);
	//	System.out.println(acctNum);
		newAcct=ADao.checkifmyaccount(user_id,acctNum);
		System.out.println(newAcct);
		if(newAcct!=null) {
			
			logoutOrAnother(user);
//			System.out.println("Logging you out now...");
//			System.out.println("");
//			BankFirst.LogOrReg();
		}
		else {
			System.out.println("User has entered incorrect Account number. Transaction was cancelled. Too Ensure Safety, logging user out...");
			System.out.println("");
			BankFirst.LogOrReg();
		}
	}
	private static void logoutOrAnother(Users user) {
		// TODO Auto-generated method stub
		System.out.println("Transaction Sucessful!");
		System.out.println("Would you like to make another transaction? 1 for yes, 2 for no");
		Scanner in = new Scanner(System.in);//get input
		String choice = in.nextLine();//change input
		switch(choice) {
		case "1": 
//		"withdraw";
			ScanCreateCheckorView(user);
			break;	
		case "2": 
			System.out.println("Thank You for banking with us, logging user out...");
			System.out.println("");
			BankFirst.LogOrReg();
			break;
		default: 
			System.out.println("Incorrect Input, Please press 1 to make further transactions or  2 to Logout");
			logoutOrAnother(user);
		}
		
		
	}
}

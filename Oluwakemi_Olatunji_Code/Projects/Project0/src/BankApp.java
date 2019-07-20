

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.revature.dao.UserDAO;
import com.revature.dao.AccountDAO;
import com.revature.pojos.BankUser;
import com.revature.pojos.BankAccount;
import com.revature.util.ConnectionFactory;

public class BankApp {

	static Scanner scan = new Scanner(System.in);
	static UserDAO userDao = new UserDAO();
	static AccountDAO accDao = new AccountDAO();

	public static void main(String[] args) {
		menu();

	}

	public static void menu() {
		System.out.println(
				"Welcome to the Iron Bank! " + "What would you like to do?\n"
						+ "1. Log into an exisiting Account.\n"
						+ "2. Create a new account.\n");
		try {

			int option = Integer.parseInt(scan.nextLine());

			switch (option) {
			case 1:
				login();
				break;
			case 2:
				addUser();
				break;
				}
		} catch (NumberFormatException e) {
			System.out.println("Please enter 1 or 2!");
			menu();
		}
	}

	public static void addUser() {
		
		System.out.println("Iron bank account creation. Please enter your first name:");
		String firstName = scan.nextLine();
		
		System.out.println("Your last name:");
		String lastName = scan.nextLine();
		
		System.out.println("Pick your username: ");
		String userName = scan.nextLine();
		
		System.out.println("Enter your password: ");
		String password = scan.nextLine();
		
		System.out.println("Enter your email: ");
		String email = scan.nextLine();
		
		
		
		BankUser newUser = new BankUser();
		newUser.setFirstName(firstName);
		newUser.setLastName(lastName);
		newUser.setUsername(userName);
		newUser.setPassword(password);
		newUser.setEmail(email);
		
		newUser = userDao.save(newUser);
		System.out.println("You've successfully registered, " + newUser);
		accOptions();
	
		
	}

public static void login(){ 
				
			try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("Enter your userName: ");
				String userName = br.readLine();

				System.out.print("Enter your password: ");
				String password = br.readLine();

				PreparedStatement stm = conn.prepareStatement("SELECT * FROM BANK_USER WHERE USERNAME=?AND USER_PASSWORD=?");
				stm.setString(1, userName);
				stm.setString(2, password);
				int result = stm.executeUpdate();
				if (result == 1) {
					System.out.println("Welcome!");
				accOptions();

				} else {
					System.out.println("Try again");
					login();
				}
				conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());				
			}
		}
	
public static void accOptions() {
	System.out.println("Please select one of the following: \n"
			+ "1. Create Account \n"
			+ "2. Deposit \n"
			+ "3. Withdraw \n"
			+ "4. View Accounts \n"
			+ "5. All Done!"	);
	
	try {

		int option = Integer.parseInt(scan.nextLine());
		
		switch(option) {
		case 1: createAccount(); break;
		case 2: deposit(); break;
		case 3: withdraw(); break;
		//case 4: balance(); break;
		case 5: goodbye(); break;
		default:
		}
		
		
	}catch(NumberFormatException e) {
		System.out.println("Please enter a number!");
		accOptions();
	}
	
}

public static void createAccount(){

	
	System.out.println("Enter your user id:");
	int userid  = Integer.parseInt(scan.nextLine());
	
	System.out.println("Enter your starting balance: ");
	double balance = Double.parseDouble(scan.nextLine());


	BankAccount newAcc = new BankAccount();
	
	newAcc.setBalance(balance);
	newAcc.setUserId(userid);
	
	newAcc = accDao.save(newAcc);
	System.out.println(newAcc);
	accOptions();
}

public static void deposit() {
	
	System.out.println("Enter your user id:");
	int userid  = Integer.parseInt(scan.nextLine());
	
	System.out.println("Enter the deposit amount");
	double depAmt  = Double.parseDouble(scan.nextLine());
	
	System.out.println("Enter Account id:");
	int id  = Integer.parseInt(scan.nextLine());
	
	BankAccount newDep = new BankAccount();
	
	newDep.setBalance(depAmt);
	newDep.setUserId(userid);
	newDep.setId(id);
	
	newDep = accDao.updateAccount(newDep);
	System.out.println(newDep);
	accOptions();
}


public static void withdraw() {
	
	System.out.println("Enter your user id:");
	int userid  = Integer.parseInt(scan.nextLine());
	
	System.out.println("Enter the withdraw amount");
	double depAmt  = Double.parseDouble(scan.nextLine());
	
	System.out.println("Enter Account id:");
	int id  = Integer.parseInt(scan.nextLine());
	
	BankAccount newDep = new BankAccount();
	
	newDep.setBalance(depAmt);
	newDep.setUserId(userid);
	newDep.setId(id);
	
	newDep = accDao.withdrawAccount(newDep);
	System.out.println(newDep);
	accOptions();
}

@SuppressWarnings("unused")
//public static List<BankAccount> balance() {
//	
//	System.out.println("Enter your user id:");
////	int userid  = Integer.parseInt(scan.nextLine());
//	
//	 List<BankAccount> accounts = accDao.viewAccount();
//	 try {
//			int id = Integer.parseInt(scan.nextLine());
//			
//			BankAccount acc = accounts.stream().filter( a -> a.getUserId() == id)
//					.findAny().orElse(null);
//			if(accounts != null) {
//				return accounts;
//			}
//			else {
//				System.out.println("This id "+ id + " does not have any accounts"
//						+ " please enter a valid id.");
//				balance();
//			}
//			
//			
//		}catch(NumberFormatException e) {
//			//make sure user entered number 
//		}
//	 accOptions();
//	 
//	return accounts;
//	}
	 
	// for(BankAccount acc: userid) {
	// System.out.println(userid);
//	BankAccount newWith = new BankAccount();
//	newWith.setUserId(userid);
//	
//	newWith = accDao.viewAccount(newWith);
//	System.out.println(newWith);
	
	
public static void goodbye() {
	
	System.out.println("Thank you for banking with us! Goodbye!");
}

}







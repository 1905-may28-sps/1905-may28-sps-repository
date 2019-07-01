package project0.app;

import java.util.List;
import java.util.Scanner;

import project0.dao.AccountsDao;
import project0.dao.BankuserDAO;
import project0.pojos.accounts;

public class Bank {

	static Scanner scan = new Scanner(System.in);
	static AccountsDao accDao = new AccountsDao();
	static BankuserDAO bankdao = new BankuserDAO();

	public static void menu() {
		System.out.println("Welcome to Bank! What would you like to do?\n" + "1. Check Balance\n"
				+ "2. Deposit\n" + "3. withdraw\n" + "4. Add new bank account\n" + "5. log out");
		try {

			int option = Integer.parseInt(scan.nextLine());

			switch (option) {
			case 1:
				CheckBalance();
				break;
			case 2:
				Deposit();
				break;
			case 3:
				withdraw();
				break;
			case 4:
				Addnew();
				break;
			case 5:
				logout();
				break;
			default:
			}

		} catch (NumberFormatException e) {
			System.out.println("please enter a number!");
	
		}
		
	}

	private static void CheckBalance() {
		// TODO Auto-generated method stub

	}

	private static void logout() {

		System.out.println("Bye Bye!");
	}

	private static void Addnew() {
		System.out.println("Thank you for opening new account! How much do you want to deposit?");
		double balance = Double.parseDouble(scan.nextLine());



			System.out.println("please enter your userid");
			accounts newAccount = new accounts();
			int id = scan.nextInt();

			newAccount.setBalance(balance);
			newAccount.setUser_id(id);

			newAccount = AccountsDao.save(newAccount);
			System.out.println(newAccount);
			System.out.println("New Account is created. You balance = " + balance);
			
		}


	private static void withdraw() {
		// TODO Auto-generated method stub
		System.out.println("withdraw");
	}

	public static List<accounts> viewAccounts() {
		List<accounts> accounts = AccountsDao.findAll();
		for (accounts a : accounts) {
			System.out.println(a);
		}
		return accounts;
	}

private static void Deposit() {
		List<accounts> acc = viewAccounts();

		}
	}


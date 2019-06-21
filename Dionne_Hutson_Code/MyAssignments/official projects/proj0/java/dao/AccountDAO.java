package com.revature.dao;

import java.util.Scanner;

public class AccountDAO {

	
	static String fn;
	static String ln;
	static String un;
	static String pass;
	static String an;
	static double transact;
	static int opt;
	static double balance;
	static Scanner scan= new Scanner(System.in);
	


	public void createSpecAcc() {
		scan=new Scanner(System.in);
		System.out.println("Choose Account Type (1) Checkings (2) Savings");
		opt=scan.nextInt();
		
		System.out.println("Enter unique account name?");
		an=scan.nextLine();
		System.out.println("Enter an initial balance, if you are not going to add anything just put 0.");
		balance=scan.nextDouble();
		System.out.println("Sucessful Account Creation!");	
	}
	
	public void viewBal() {
		scan=new Scanner(System.in);
		System.out.println("Enter account name, that you would like to see");
		an=scan.nextLine();
		
		
	}
	
	
	
	
	
}

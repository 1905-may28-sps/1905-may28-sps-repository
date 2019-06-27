package com.animoBank.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.animoBank.app.BankMain;
import com.animoBank.pojo.BankAccount;
import com.animoBank.pojo.BankUser;
import com.animoBank.util.ConnectionFactory;

public class BankAccountDAO {

	static Scanner scan = new Scanner(System.in);


	public List<BankAccount> findAccountById(int id) {

		List<BankAccount> account = new ArrayList<BankAccount>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String query = "SELECT * FROM BANK_ACCOUNT where owner = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				BankAccount bnkAcc = new BankAccount();
				bnkAcc.setAccountId(result.getInt(1));
				bnkAcc.setBalance(result.getDouble(2));
				bnkAcc.setOwner(result.getInt(3));
				bnkAcc.setAccType(result.getInt(4));
				bnkAcc.setType(result.getString(5));

				account.add(bnkAcc);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return account;
	}

	
	public BankAccount getOneAccountById(int id) {
		BankAccount account = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "SELECT * FROM BANK_ACCOUNT where owner = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);

			ResultSet result = ps.executeQuery();

			while (result.next()) {
				account = new BankAccount();
				account.setAccountId(result.getInt(1));
				account.setBalance(result.getDouble(2));
				account.setOwner(result.getInt(3));
				account.setAccType(result.getInt(4));
				account.setType(result.getString(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return account;
	}
	
	
	
	public static boolean validateAccountId(int AcctId) {
		boolean validId = false;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "SELECT * FROM BANK_ACCOUNT where account_id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, AcctId);

			ResultSet result = ps.executeQuery();

			while (result.next()) {
				validId = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return validId;
	}

	
	
	public static BankAccount makeDeposite(BankAccount acct, double amount, int acctNumber) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			CallableStatement stmt = conn.prepareCall("{call DEPOSITE(?,?,?)}");
			stmt.setInt(1, acctNumber);
			stmt.setDouble(2, amount);
			stmt.setInt(3, acct.getOwner());
			stmt.execute();
		} catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("INVALID DEPOSITE AMOUNT...PLEASE TRY AGAIN");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return acct;
	}
	
	
	
	public static BankAccount makeWithdraw(BankAccount acct, double amount, int acctNumber, BankUser bnkUser) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			CallableStatement stmt = conn.prepareCall("{call WITHDRAW(?,?,?)}");
//			System.out.println("error 1------------" + acctNumber);
			stmt.setInt(1, acctNumber);
			stmt.setDouble(2, amount);
			stmt.setInt(3, acct.getOwner());
			stmt.execute();
		} 
		catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("INSUFFICIENT FUNDS ... REDIRECTING TO YOUR ACCOUNTS PAGE...");
		BankMain.logInSuccess(bnkUser);
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("INSUFFICIENT FUNDS ... REDIRECTING TO YOUR ACCOUNTS PAGE...");
			BankMain.logInSuccess(bnkUser);
		}
		return acct;
	}
	

	
	public BankAccount openBankAccount(BankAccount acct) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "INSERT INTO BANK_ACCOUNT (BALANCE, OWNER, ACC_TYPE)\n" + "VALUES (?, ?, ?,?)";
			String[] generatedKey = { "Account_Id" };
			PreparedStatement ps = conn.prepareStatement(query, generatedKey);
			ps.setDouble(1, acct.getBalance());
			ps.setInt(2, acct.getOwner());
			ps.setInt(3, acct.getAccType());
			ps.setString(4, acct.getType());
			ps.executeUpdate();

			ResultSet pk = ps.getGeneratedKeys();
			pk.next();
			acct.setAccountId(pk.getInt(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acct;
	}

	
	
	public void prepareBankAccount(BankUser user, int accType, String type) {
		System.out.println(
				user.getFirstname() + " " + user.getLastname() + " HOW MUCH MONEY WOULD YOU LIKE TO DEPOSITE TODAY?");
		double initDeopsite = scan.nextInt();
		BankAccount newAccount = new BankAccount();
		newAccount.setBalance(initDeopsite);
		newAccount.setOwner(user.getUserId());
		newAccount.setAccType(accType);
		newAccount.setType(type);
		newAccount = openBankAccount(newAccount);
		System.out.println("YOUR ACCOUNT WAS CREATED SUCCESSFULLY \n" + "\n" + " YOUR ACCOUNT NUM# IS : "
				+ newAccount.getAccountId() + " \n" + "\n" + " YOUR CURRENT BALANCE IS :" + newAccount.getBalance());
	}


	
	public static void prepareDeposite(BankAccount acct) {
	System.out.println("WHAT ACCOUNT WOULD YOU LIKE TO DEPOSITE INTO? \n" + "PLEASE PROVIDE ACCOUNT NUMBER#");
		try {	
		int acctNumber = Integer.parseInt(scan.nextLine());
		
		boolean valid = validateAccountId(acctNumber);
		if (valid == false) {
			System.out.println("ACCOUNT NUMBER " + acctNumber + " IS INVALID...PLEASE TRY AGAIN \n");
			prepareDeposite(acct);
		}
			System.out.println("HOW MUCH WOULD YOU LIKE TO DEPOSITE INTO ACCOUNT #" + " " + acctNumber + " ? \n"
					+ "**Please no -  *  , or any other puntuations asides from . to indicate cents **");
			double previousBalance = acct.getBalance();
			double amount = scan.nextDouble();
			makeDeposite(acct, amount, acctNumber);
			System.out.println("DEPOSITE SUCCESSFULLY \n" + "\n" + "YOUR ORIGINAL BALANCE WAS: $" + previousBalance
					+ "\n" + "\n" + "AFTER YOUR $" + amount + " WITHDRAW \n" + "\n"
					+ "YOUR CURRENT BALANCE FOR ACCOUNT #" + acctNumber + " is : $" + (acct.getBalance() - amount));
		}catch(NumberFormatException e) {
			System.out.println(" INVALID AMOUNT TYPE...PLEASE TRY AGAIN...ONLY NUMARIC VALUES!");
			prepareDeposite(acct);
		}
	}


	
	public static void prepareWithdraw(BankAccount acct, BankUser bnkUser) {
		System.out.println("WHAT ACCOUNT WOULD YOU LIKE TO WITHDRAW FROM? \n" + "PLEASE PROVIDE ACCOUNT NUMBER#");
		try { int acctNumber = Integer.parseInt(scan.nextLine());
		
		boolean valid = validateAccountId(acctNumber);
		if (valid == false) {
			System.out.println("ACCOUNT NUMBER " + acctNumber + " IS INVALID...PLEASE TRY AGAIN \n");
			prepareWithdraw(acct, bnkUser);
		}
			
//			if (acctNumber) {
//				System.out.println(" DEPOSITE AMOUNT IS INVALID...PLEASE ENTER A VALID AMOUNT");
//			}
			System.out.println("HOW MUCH WOULD YOU LIKE TO WITHDRAW FROM ACCOUNT #" + " " + acctNumber + " ? \n"
					+ "**Please no -  *  , or any other puntuations asides from . to indicate cents **");
			double previousBalance = acct.getBalance();
			double amount = scan.nextDouble();
			makeWithdraw(acct, amount, acctNumber, bnkUser);
			System.out.println("WITHDRAW SUCCESSFULLY \n" + "\n" + "YOUR ORIGINAL BALANCE WAS: $" + previousBalance
					+ "\n" + "\n" + "AFTER YOUR $" + amount + " WITHDRAW \n" + "\n"
					+ "YOUR CURRENT BALANCE FOR ACCOUNT #" + acctNumber + " is : $" + (acct.getBalance() - amount));
		}catch(NumberFormatException e) {
			System.out.println(" INVALID AMOUNT TYPE...PLEASE TRY AGAIN...ONLY NUMARIC VALUES!");
			prepareWithdraw(acct, bnkUser);
		}
	}
}

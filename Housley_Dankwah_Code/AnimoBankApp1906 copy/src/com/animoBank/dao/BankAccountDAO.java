package com.animoBank.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import com.animoBank.pojo.BankAccount;
import com.animoBank.pojo.BankUser;
import com.animoBank.util.ConnectionFactory;

public class BankAccountDAO {

	static Scanner scan = new Scanner(System.in);

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
	
	
	public  void prepareBankAccount( BankUser user, int accType) {
		System.out.println( user.getFirstname() +" " + user.getLastname()+
				" HOW MUCH MONEY WOULD YOU LIKE TO DEPOSITE TODAY?");
		double initDeopsite = scan.nextInt();
		BankAccount newAccount = new BankAccount();
		newAccount.setBalance(initDeopsite);
		newAccount.setOwner(user.getUserId());
		newAccount.setAccType(accType);
		newAccount = openBankAccount(newAccount);
		System.out.println("YOUR ACCOUNT WAS CREATED SUCCESSFULLY \n"
				+ "\n"
				+ " YOUR ACCOUNT NUM# IS : " + newAccount.getAccountId() + " \n"
				+ "\n"
				+ " YOUR CURRENT BALANCE IS :" + newAccount.getBalance());
		
		
	}

	public BankAccount  openBankAccount(BankAccount acct) {
		
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "INSERT INTO BANK_ACCOUNT (BALANCE, OWNER, ACC_TYPE)\n" + 
					"VALUES (?, ?, ?)";
			
			String[] generatedKey = {"Account_Id"};
			
			PreparedStatement ps = conn.prepareStatement(query, generatedKey);
			ps.setDouble(1, acct.getBalance());
			ps.setInt(2, acct.getOwner());
			ps.setInt(3, acct.getAccType());
			ps.executeUpdate();
			
			
			ResultSet pk = ps.getGeneratedKeys();
			pk.next();
			acct.setAccountId(pk.getInt(1));
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	return acct;

	}	

	
	
	public BankAccount makeDeposite(BankAccount acct, double amount) {
		
		try ( Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			CallableStatement stmt = conn.prepareCall("{call DEPOSITE(?,?,?)}");
		stmt.setInt(1, acct.getAccountId() );
		stmt.setDouble(2, amount);
		stmt.setInt(3, acct.getOwner());
		
		stmt.execute();
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return acct;
	}
	
	public void prepareDeposite(BankAccount acct) {
		System.out.println("HOW MUCH WOULD YOU LIKE TO DEPOSITE TODAY INTO ACCOUNT #"
				+ "" + acct.getAccountId() + " ?");
		
		double previousBalance = acct.getBalance();
		
		int amount = scan.nextInt();
		makeDeposite(acct, amount);
		System.out.println("DEPOSITED SUCCESSFULLY \n"
				+ "\n"
				+ "YOUR ORIGINAL BALANCE WAS: $" + previousBalance + "\n"
				+ "\n"
				+ "AFTER YOUR $" + amount + " DEPOSITE \n"
				+ "\n"
				+ "YOUR CURRENT BALANCE FOR ACCOUNT #" + acct.getAccountId() + " is : $"+ (acct.getBalance()+amount));
		
		
		
	}


	public BankAccount makeWithdraw(BankAccount acct, double amount) {
		
		try ( Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			CallableStatement stmt = conn.prepareCall("{call WITHDRAW(?,?,?)}");
		stmt.setInt(1, acct.getAccountId() );
		stmt.setDouble(2, amount);
		stmt.setInt(3, acct.getOwner());
		
		stmt.execute();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acct;
	}
	
	
	public void prepareWithdraw(BankAccount acct) {
		System.out.println("HOW MUCH WOULD YOU LIKE TO WITHDRAW FROM ACCOUNT #"
				+ " " + acct.getAccountId() + " ?");
		
		double previousBalance = acct.getBalance();
		
		int amount = scan.nextInt();
		makeDeposite(acct, amount);
		System.out.println("WITHDRAW SUCCESSFULLY \n"
				+ "\n"
				+ "YOUR ORIGINAL BALANCE WAS: $" + previousBalance + "\n"
				+ "\n"
				+ "AFTER YOUR $" + amount + " WITHDRAW \n"
				+ "\n"
				+ "YOUR CURRENT BALANCE FOR ACCOUNT #" + acct.getAccountId() + " is : $"+ (acct.getBalance()-amount));
		
		
		
	}


}

package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.pojos.BankAccount;
import com.revature.pojos.User;
import com.revature.util.ConnectionFactory;

public class AccountDao {

	
	public AccountDao() {};
	
	public boolean createAccount(double balance, String accountType, int userID ) {
	BankAccount account = new BankAccount();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			String query = "INSERT INTO BANK_ACCOUNT VALUES (ACCOUNT_SEQ.NEXTVAL, ?, ?, ?)";			 
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDouble(1, balance);
			ps.setString(2, accountType);
			ps.setInt(3, userID);
			ps.executeQuery();

		
			
						
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
		
		
	}
	
	
	public boolean deposit(double ammount, String accountNumber, int userID) {
		
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			double balance= 0;
			String query = "SELECT BALANCE FROM BANK_ACCOUNT WHERE CUSTOMER_ID = ? AND ACCOUNT_NUM = ?";			 
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, userID);
			ps.setString(2, accountNumber);
			ResultSet rs = ps.executeQuery();		
			while(rs.next()) {
				balance = rs.getDouble(1);
			}
			String sql = "{ call update BANK_ACCOUNT SET BALANCE = ? WHERE CUSTOMER_ID = ? AND ACCOUNT_NUM = ?}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setDouble(1, balance + ammount);
			cs.setInt(2, userID);
			cs.setString(3, accountNumber);
			cs.executeQuery();
			
			
//			String query2 = "UPDATE BANK_ACCOUNT SET BALANCE = ? WHERE CUSTOMER_ID = ? AND ACCOUNT_NUM = ?";			 
//			PreparedStatement ps2 = conn.prepareStatement(query2);
//			ps2.setDouble(1, balance + ammount);
//			ps2.setInt(2, userID);
//			ps2.setString(3, accountNumber);
//			ps2.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
	
	public boolean withdrawl(double ammount, String accountNumber, int userID) {
		
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			double balance= 0;
			String query = "SELECT BALANCE FROM BANK_ACCOUNT WHERE CUSTOMER_ID = ? AND ACCOUNT_NUM = ?";			 
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, userID);
			ps.setString(2, accountNumber);
			ResultSet rs = ps.executeQuery();	
			while(rs.next()) {
			balance = rs.getDouble(1);
			}
			if(balance >= ammount ) {
				String query2 = "UPDATE BANK_ACCOUNT SET BALANCE = ? WHERE CUSTOMER_ID = ? AND ACCOUNT_NUM = ?";			 
				PreparedStatement ps2 = conn.prepareStatement(query2);
				ps2.setDouble(1, balance - ammount);
				ps2.setInt(2, userID);
				ps2.setString(3, accountNumber);
				ps2.executeQuery();
			}else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}

	public double checkbalance( String accountNumber, int userID) {
		double balance= 0;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			String query = "SELECT BALANCE FROM BANK_ACCOUNT WHERE CUSTOMER_ID = ? AND ACCOUNT_NUM = ?";			 
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, userID);
			ps.setString(2, accountNumber);
			ResultSet rs = ps.executeQuery();	
			while(rs.next()) {
			balance = rs.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		
		return balance;
		
	}
	
	
	
}

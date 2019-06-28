package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.BankAccount;
import com.revature.util.ConnectionFactory;


public class AccountDAO {
	
	
	
	public BankAccount getBankById(int userid) {
		return null;
		
		
	}
	public BankAccount save (BankAccount b) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){		
		
		
		String sql = "INSERT INTO BANK_ACCOUNT (BALANCE, USER_ID) "
				+ "VALUES (?, ?)";
		String[] generatedKeys = {"ACCOUNT_ID"};
		
		PreparedStatement ps = conn.prepareStatement(sql,generatedKeys);
		
		ps.setDouble(1, b.getBalance());
		ps.setInt(2, b.getUserId());
		
			ps.executeUpdate();
			
			ResultSet pk = ps.getGeneratedKeys();
			pk.next();
			b.setId(pk.getInt(1));	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return b;
	}


public BankAccount update (BankAccount b, double balance) {
	try(Connection conn = ConnectionFactory.getInstance().getConnection()){		
	String query = "UPDATE Bankaccount SET balance = balance + ? WHERE userid = ?";
	
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setDouble(1, balance);
		ps.setInt(2, b.getUserId());
		int rowsChanged = ps.executeUpdate();
		if (rowsChanged == 1) {
			b.setBalance(balance); 
		}
		
	}catch(SQLException e) {
		System.out.println("ERROR: User Id not found.");
	}
	System.out.println("SUCCESSFUL!");
	return b;
}

public  BankAccount updateAccount (BankAccount account) {
	try(Connection conn = ConnectionFactory.getInstance().getConnection()){
		String sql = "{ call  UPDATE_BANK_ACCOUNT(?, ?, ?) }";
		CallableStatement cs = conn.prepareCall(sql);
		
		cs.setInt(1, account.getId() );
		cs.setDouble(2, account.getBalance());
		cs.setInt(3, account.getUserId() );
		
		cs.execute();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return account;
	
}


public  BankAccount withdrawAccount (BankAccount account) {
	try(Connection conn = ConnectionFactory.getInstance().getConnection()){
		String sql = "{ call  WITHDRAW_BANK_ACCOUNT(?, ?, ?) }";
		CallableStatement cs = conn.prepareCall(sql);
		
		cs.setInt(1, account.getId() );
		cs.setDouble(2, account.getBalance());
		cs.setInt(3, account.getUserId() );
		
		cs.execute();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return account;
	
}

public  List<BankAccount> viewAccount() {
	List<BankAccount> accounts = new ArrayList<BankAccount>();
	try(Connection conn = ConnectionFactory.getInstance().getConnection()){
		Statement st = conn.createStatement();
		
		ResultSet rs = st.executeQuery("select * from BANK_ACCOUNT where user_id = ?");	
		while(rs.next()) {
			BankAccount acc = new BankAccount();
			acc.setId(rs.getInt(1));
			acc.setBalance(rs.getDouble(2));
			acc.setUserId(rs.getInt(3) );
			accounts.add(acc);
		
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return accounts;
}


//public  List<BankAccount> viewAccount (){
//List<BankAccount> accounts = new ArrayList<BankAccount>();
//
//try(Connection conn = ConnectionFactory.getInstance().getConnection()){
//	Statement st = conn.createStatement();
//
//	
//	ResultSet rs = st.executeQuery ("select * from BANK_ACCOUNT where user_id = ?");
//	while(rs.next()) {
//		BankAccount acc = new BankAccount();
//		acc.setUserId(((Object) rs).getUserId(1));
//	}
//	
//} catch (SQLException e) {
//	e.printStackTrace();
//}
//return accounts;
//}


}

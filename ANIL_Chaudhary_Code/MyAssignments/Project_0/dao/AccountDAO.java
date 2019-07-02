package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Account;
import com.revature.util.ConnectionFactory;

public class AccountDAO {
	/*
	 * CALLABLE STATEMENT
	 * - statement that we use to call stored procedures and functions 
	 * - must use registerOutParameter function for OUT params
	 * - can still use setInt/String/etc for in params or output values 
	 */
	public List<Account> getAllCallable(){
		List<Account> accounts = new ArrayList<Account>();
		
		return null;
	}

	public Account checkBalance(int customer) {
		Account acc = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String query  = "select * from BANK_ACCOUNT where CUSTOMER = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, customer);
			ResultSet result = ps.executeQuery();
			while(result.next()) {
				acc = new Account();
				acc.setcustomer(result.getInt(3));
				acc.setId(result.getInt(1));
				acc.setbalance(result.getInt(2));
				acc.setacctype(result.getInt(4));
				
				System.out.println(acc);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acc;
	}
	
	




	public Account updateDbBal(int debit, int c1) {
	Account acc1 = null;	
	try(Connection conn = ConnectionFactory.getInstance().getConnection();){
		PreparedStatement ps = conn.prepareStatement("UPDATE BANK_ACCOUNT set BALANCE = BALANCE - ? where CUSTOMER  = ?");
		
		ps.setInt(1, debit);
		//System.out.println("SETTING ID TO " + c1.getCustomer());
		ps.setInt(2, c1);
		int rowsChanged = ps.executeUpdate();
		//System.out.println("EXECUTED UPDATE");
		if(rowsChanged == 1) {
		System.out.println( " ACCOUNT successfully updated\n\n");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
	}
	return acc1;
}



public Account updateCrBal(int credit, int c2) {
	Account acc2 = null;	
	try(Connection conn = ConnectionFactory.getInstance().getConnection();){
		PreparedStatement ps = conn.prepareStatement("UPDATE BANK_ACCOUNT set BALANCE = BALANCE + ? where CUSTOMER  = ?");
		
		ps.setInt(1, credit);
		//System.out.println("SETTING ID TO " + c2.getCustomer());
		ps.setInt(2, c2);
		int rowsChanged = ps.executeUpdate();
		//System.out.println("EXECUTED UPDATE");
		if(rowsChanged == 1) {
		System.out.println( " ACCOUNT successfully updated\n\n");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return acc2;
}
}



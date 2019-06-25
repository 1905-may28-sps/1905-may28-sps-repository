package com.animoBank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.animoBank.pojo.BankAccount;
import com.animoBank.util.ConnectionFactory;

public class BankAccountDAO {
	
	public BankAccount findAccountById(int id) {
		
		BankAccount account = null;
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			
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
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return account;
	}


	

}

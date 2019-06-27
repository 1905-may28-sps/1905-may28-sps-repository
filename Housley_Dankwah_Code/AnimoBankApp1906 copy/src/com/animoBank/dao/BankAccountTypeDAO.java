package com.animoBank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.animoBank.pojo.BankAccountType;
import com.animoBank.util.ConnectionFactory;

public class BankAccountTypeDAO {
	
	public List<String> findAllAccountType() {
		List<String> accountType = new ArrayList<String>();

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT * FROM ACCOUNT_TYPE";
			
			Statement statement =  conn.createStatement();
			
			ResultSet result = statement.executeQuery(query);
			while(result.next()) {
//				System.out.println(result.getInt(1) + " " + result.getString(2));
//				BankAccountType temp = new BankAccountType(
//						result.getInt(1),
//						result.getString(2));
				accountType.add(result.getString(2));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return accountType; 
	}
	
	
	
	
}

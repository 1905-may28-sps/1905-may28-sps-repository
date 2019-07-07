package com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.pojo.Account;
import com.revature.pojo.BankUser;
import com.revature.util.ConnectionFactory;

public class AccountDao {
	
	
	public Account findById(int id) {
		Account a = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query  = "SELECT * FROM USERACCOUNT WHERE ACCOUNTID = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet result = ps.executeQuery();
			while(result.next()) {
				a = new Account();
				a.setAccountId(result.getInt(1));
				a.setBalance(result.getDouble(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public Account update(Account a, Double balance) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			PreparedStatement ps = conn
					.prepareStatement("UPDATE USERACCOUNT SET BALANCE = (BALANCE + ?) WHERE ACCOUNTID = ?");
			ps.setDouble(1, balance);
			ps.setInt(2, a.getAccountId());
			System.out.println(a.getAccountId());
			int rowsChanged = ps.executeUpdate();
			System.out.println(rowsChanged);
			if(rowsChanged == 1) {
				a.setBalance(balance);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	
	public Account save(Account acc) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
		String sql = "INSERT INTO USERACCOUNT(BALANCE, ACCOUNTOWNER) VALUES (?,?)";
		String[] generatedKeys = {"ACCOUNTID"};
		
		PreparedStatement ps = conn.prepareStatement (sql, generatedKeys);
		ps.setDouble(1, acc.getBalance());
		ps.setInt(2, acc.getAccountOwner());
		
		
		ps.executeUpdate();
		ResultSet pk = ps.getGeneratedKeys();
		pk.next();
		acc.setAccountId(pk.getInt(1));
		
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		
		
		return acc;
	}

		
		public Account findByOwner(int id) {
			Account o = null;
			try(Connection conn = ConnectionFactory.getInstance().getConnection()){
				String query  = "SELECT * FROM USERACCOUNT WHERE ACCOUNTOWNER = ?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setInt(1, id);
				ResultSet result = ps.executeQuery();
				while(result.next()) {
					o = new Account();
					o.setAccountId(result.getInt(1));
					o.setBalance(result.getDouble(2));
					o.setAccountOwner(result.getInt(3));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return o;
		}


	
}

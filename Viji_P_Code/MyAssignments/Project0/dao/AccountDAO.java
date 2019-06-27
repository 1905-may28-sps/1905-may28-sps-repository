package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.revature.dao.UserDAO;
import com.revature.pojos.Account;
import com.revature.util.ConnectionFactory;


public class AccountDAO {
	
			
		public Account saveAcc(Account accountObject) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query ="INSERT INTO BANK_ACCOUNT (Balance, ACC_OWNER, ACC_TYPE) Values (?,?,?)";
			String[] generatedKeys = {"ACC_ID"};
			
		//	System.out.println("Account OBJECT..."+accountObject.toString());
			
			PreparedStatement ps = conn.prepareStatement(query, generatedKeys);
			ps.setInt(1, accountObject.getBalance());
			ps.setInt(2, accountObject.getOwner());
			ps.setString(3, accountObject.getAccType());
			
			ps.executeUpdate();
			
			ResultSet pk = ps.getGeneratedKeys();
			pk.next();
			accountObject.setAcc_id(pk.getInt(1));
			
			System.out.println("Account added Successfully...");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return accountObject;
	}
	
	public List<Account> displayAccountInfo(String username){
		List<Account> accountInfo = new ArrayList<Account>();
		
		Account obj = new Account();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT BANK_ACCOUNT.ACC_ID, BANK_ACCOUNT.BALANCE \r\n" + 
							"FROM BANK_USER JOIN BANK_ACCOUNT \r\n" + 
							"ON BANK_USER.U_ID = BANK_ACCOUNT.ACC_OWNER\r\n" + 
							"WHERE USERNAME = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
		//	System.out.println("user name ...."+username);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				obj = new Account();
				obj.setAcc_id(result.getInt(1));
				obj.setBalance(result.getInt(2));
				accountInfo.add(obj);
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return accountInfo;
	}
	
	public boolean updateBalance(int amount, int accId) {
			boolean updatedBal = false;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			System.out.println("Amount :"+ amount);
			System.out.println("AccId :"+ accId);
			
			/****
			String query = "UPDATE BANK_ACCOUNT SET BALANCE = ? WHERE ACC_ID = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, amount);
			ps.setInt(2, accId);
			
			int row = ps.executeUpdate();
			
			****/
			
			//Using Callable Statement
			
			String query = "{ call update_balance(?,?) }";
			CallableStatement cs = conn.prepareCall(query);
			
			cs.setInt(1, accId);
			cs.setInt(2, amount);
						
			cs.execute();
			
			//System.out.println("Number of row updated"+row);
			
			updatedBal = true;
		
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedBal;
	}

		
}
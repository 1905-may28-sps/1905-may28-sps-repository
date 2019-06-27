package com.revature.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Account;
import com.revature.utils.ConnectionFactory;

public class AccountDao {
	
	public static List<Account> showAccountDetails(int id) {
		List<Account> bankaccounts = new ArrayList<Account>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
	        PreparedStatement ps = conn.prepareStatement("SELECT * FROM bank_account WHERE userid=?");
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
	        while(rs.next())
	        {
	        	Account b = new Account();
	        	b.setAccountId(rs.getInt(1));
				b.setBalance(rs.getDouble(2));
				b.setUserId(rs.getInt(3));
				b.setAccountType(rs.getString(4));
	            bankaccounts.add(b);
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return bankaccounts;
	}
	
	public static Account chosenAccountDetail(int id) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
	        PreparedStatement ps = conn.prepareStatement("SELECT * FROM bank_account WHERE accountid=?");
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
	        while(rs.next())
	        {
	        	Account b = new Account();
	        	b.setAccountId(rs.getInt(1));
				b.setBalance(rs.getDouble(2));
				b.setUserId(rs.getInt(3));
				b.setAccountType(rs.getString(4));
	            return b;
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return null;
	}
	
	public Account newAccount(Account bku) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "INSERT INTO Bank_Account (BALANCE, USERID, ACCOUNTTYPE) VALUES (?, ?, ?)";
			String[] generatedKeys = {"ACCOUNTID"}; //takes an array just in case we have more than 1 key
			
			PreparedStatement ps = conn.prepareStatement(sql, generatedKeys);
			ps.setDouble(1, bku.getBalance());
			ps.setInt(2, bku.getUserId());
			ps.setString(3, bku.getAccountType());
			ps.executeUpdate();
			ResultSet pk = ps.getGeneratedKeys();
			pk.next();
			bku.setAccountId(pk.getInt(1));
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bku;
	}
	
	public Account updateAccount(Account bku) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "INSERT INTO Bank_Account (BALANCE) VALUES (?)";
			String[] generatedKeys = {"ACCOUNTID"}; //takes an array just in case we have more than 1 key
			
			PreparedStatement ps = conn.prepareStatement(sql, generatedKeys);
			ps.setDouble(1, bku.getBalance());
			ps.executeUpdate();
			ResultSet pk = ps.getGeneratedKeys();
			pk.next();
			bku.setAccountId(pk.getInt(1));
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bku;
	}

	public Double withdrawMoney(double bal, Integer uid, String acctype) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			CallableStatement stmt = conn.prepareCall("{call WITHDRAW(?,?,?)}");
			stmt.setDouble(1, bal);
			stmt.setInt(2, uid);
			stmt.setString(3, acctype);
			stmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return bal;
	}
	
	public Double depositMoney(double bal, Integer uid, String acctype) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			CallableStatement stmt = conn.prepareCall("{call DEPOSIT(?,?,?)}");
			stmt.setDouble(1, bal);
			stmt.setInt(2, uid);
			stmt.setString(3, acctype);
			stmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return bal;
	}

}

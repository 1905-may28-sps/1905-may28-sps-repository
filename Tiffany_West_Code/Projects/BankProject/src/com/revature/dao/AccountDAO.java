package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Account;
import com.revature.util.ConnectionFactory;

public class AccountDAO {

	public static String table = "bank_account";
	public static String id = "account_id";
	public static String balance = "balance";
	public static String accountNumber = "account_number";

	//public static int userId = "user_id";
	public static String typeId = "type_id";
	
	public ArrayList<Account> getLogin(Account accUser){
		ArrayList<Account> accs = new ArrayList<Account>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

		String sql =  String.format("select bank_user.first_name, bank_user.last_name, bank_account.balance,bank_account.account_number\n" + 
				"from bank_account\n" + 
				" join bank_user on bank_user.user_id = bank_account.user_id "
				+ " where  username =  ? and password = ?" ,
				UserDAO.table,
				UserDAO.id,
				UserDAO.firstName,
				UserDAO.lastName,
				UserDAO.userName,
				UserDAO.password,
				AccountDAO.table,
				AccountDAO.id,
				//AccountDAO.userId,
				AccountDAO.typeId,
				AccountDAO.balance,
				AccountDAO.accountNumber
				);
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, UserDAO.firstName);
		ps.setString(2, UserDAO.lastName);
		ps.setString(3,	AccountDAO.balance);
		ps.setString(4, AccountDAO.accountNumber);
		
		ps.execute();
	
				System.out.println(accs);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return accs;
		
	}
	
	public Account save (Account acc) {

		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			
			
			String sql = "insert into bank_account_ (username, balance, type_id) values(?,?,?)";
			
			String[] generatedkeys = {"Account_id"};

			PreparedStatement ps = conn.prepareStatement(sql,generatedkeys);
			ps.setString(1, acc.getUsername());
			ps.setDouble(2, acc.getBalance());
			ps.setInt(3, acc.getTypeId());
		
			
			
			ps.executeUpdate();
			
			ResultSet pk = ps.getGeneratedKeys();
			pk.next();
			acc.setId(pk.getInt(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return acc;
		
	}

	public Account findByUser(String username) {
		Account a = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query  = "select * from bank_account_ where username= ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ResultSet result = ps.executeQuery();
			while(result.next()) {
				a = new Account();
				a.setId(result.getInt(1));
				a.setUsername(result.getString(2));
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
		
	}

	public Account update (Account a, double depo) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			PreparedStatement ps = conn.prepareStatement("update bank_account_ set balance = ? where username = ?");
			ps.setDouble(1, depo);
			System.out.println("addind dep to " + a.getUsername());
			ps.setString(2,a.getUsername());
			int rowsChanged = ps.executeUpdate();
			System.out.println("exc up");
			if (rowsChanged ==1) {
				a.setBalance(depo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return a;
		
	}
	
	
	public Account withdraw (Account acc) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String sql = "{call WITHDRAW(?,?)}";			
			CallableStatement call = conn.prepareCall(sql);
			
			//(u_id IN number,acc_num in number, dep IN NUMBER) 
			call.setInt(1, acc.getAccountNumber());
			call.setDouble(2, acc.getBalance());
			
			call.executeUpdate();
			
			
			}  catch (SQLIntegrityConstraintViolationException e) {
						System.out.println("Insufficient funds available.");
        }
		catch (SQLException e) {
				e.printStackTrace();
			}
		return acc;
			
	}
	public Account deposit (Account acc) {
try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String sql = "{call WITHDRAW(?,?)}";			
			CallableStatement call = conn.prepareCall(sql);
			
			//(u_id IN number,acc_num in number, dep IN NUMBER) 
			call.setInt(1, acc.getAccountNumber());
			call.setDouble(2, acc.getBalance());
			//call.setInt(1, acc.getUserId());
			
			call.executeUpdate();
			
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return acc;
			
	
	}
}

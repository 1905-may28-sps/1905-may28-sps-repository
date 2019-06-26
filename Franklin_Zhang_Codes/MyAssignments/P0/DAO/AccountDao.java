package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.accessibility.AccessibleAction;

import POJO.Users;
import POJO.Accounts;
import util.ConnectionFactory;

public class AccountDao {
	public static void main(String[] args) {
		//System.out.println(findUserAccounts(37));
	}
	public List<Accounts> findUserAccounts(int user){
		List<Accounts> accounts = new ArrayList<Accounts>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from BankAccounts where Userid="+user;
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);			
			while(rs.next()) {
				Accounts temp = new Accounts(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getString(4), rs.getInt(5));
				
				//Accounts temp= new Accounts(rs.getInt(2), rs.getString(4), rs.getInt(5));
				accounts.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}
	
	public Accounts createaccount(Accounts acct) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "INSERT INTO BankAccounts (UserId, balance, account_Type) VALUES (?, ?, ?)";
			String[] generatedKeys = {"ACCOUNTID"}; //takes an array just in case we have more than 1 key
			PreparedStatement ps = conn.prepareStatement(sql, generatedKeys);
			ps.setInt(1, acct.getUser_id());
			ps.setDouble(2, acct.getBalance());
			ps.setString(3, acct.getAccount_Type());
			
			ps.executeUpdate();
			ResultSet pk = ps.getGeneratedKeys();
			pk.next();
			acct.setUser_id(pk.getInt(1));
			System.out.println("Bank Account Created!!");
		} 
		catch (SQLIntegrityConstraintViolationException e)
		{System.out.println("Balance cannot be negative");}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return acct;
	}

	public Accounts WithdrawDeposit(Accounts acct) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			//insql(uId IN Number, ANum IN NUMBER, WithDep in number) 
			String sql = "{call BalanceWithDep(?,?,?)}";
		
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, acct.getUser_id());
			cs.setInt(2, acct.getAccount_num());
			cs.setDouble(3, acct.getBalance());
		
			cs.executeUpdate();
		
		} 
		catch (SQLIntegrityConstraintViolationException e)
		{System.out.println("Cannot Withdraw more then you have");}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return acct;
	
	}
	
	
	
}

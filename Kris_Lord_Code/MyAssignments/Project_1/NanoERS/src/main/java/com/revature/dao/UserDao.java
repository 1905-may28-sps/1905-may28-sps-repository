package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Account;
import com.revature.pojos.Account2;
import com.revature.pojos.AccountInfo;
import com.revature.pojos.User;
import com.revature.pojos.UserInformation;
import com.revature.util.ConnectionFactory;

public class UserDao {
	
	public List<User> findAll(){
		List<User> Users = new ArrayList<User>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from nano_user");
			while(rs.next()) {
				User a = new User();
				a.setUserId(rs.getInt(1));
				a.setFirstName(rs.getString(2));
				a.setLastName(rs.getString(3));
				a.setEmail(rs.getString(4));
				a.setUsername(rs.getString(5));
				a.setPassword(rs.getString(6));
				a.setUserRoleId(rs.getInt(7));
				Users.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Users;
	}

	public User getUserByUserName(String user) {
		User b =  null;// declare reference to an object of class User
		//the variable name, b, plus a reference pointing to null
		//A null User object is possible (User b = null;)
		//The value of b is null
		//and could be useful as a place-holder, 
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
	        PreparedStatement ps = conn.prepareStatement("SELECT * FROM nano_user WHERE lower(username)=?");
	        /*
	         * The PreparedStatement interface is a subinterface of Statement.
	         * It is used to execute parameterized query. we are passing parameter
	         * (?) for the values. Its value will be set by calling the setter
	         * methods of PreparedStatement.
	         */
	        ps.setString(1, user.toLowerCase());/*1 specifies the first parameter
	        * in the query. Since I only have one question mark, I only have one
	        * of these statements. If I had 2 question marks in the SQL query above
	        * then I would need another statement with a ...(2,...
	        * user.toLowerCase() takes the input String, turns it lowercase and
	        * places it in lieu of the first question mark in the above SQL query.
	        */
	        ResultSet rs = ps.executeQuery();/*
	        * ResultSet is an interface available in java.sql package. ResultSet
	        * object will be created by using the aforementioned prepared
	        * statement method. When ResultSet object is created the ResultSet
	        * point initially Points to before the first record. A ResultSet is
	        * a Java object that contains the results of executing an SQL query.
	        * In other words, it contains the rows that satisfy the conditions of
	        * the query.
	        */
	        if(rs.next())/*
	        * To move the ResultSet Pointer, you can use next() method (rs.next()).
	        * rs.next() method does the following things:
	        * 1) checks whether the next record is available or not.
	        * 2) If the next record is available then:
	        * 	a) moves the pointer to next record
	        * 	b) returns true
	        * 3) If the next record is not available then:
	        * 	a) moves the pointer to next record
	        * 	b) returns false
	        * 4) when ResultSet pointer is pointing to one record then you can
	        * access the column value of that record using getXX() methods.
	        */
	        {
	        	b = new User();//acquire an actual, physical copy of the object
	        	//and assign it to the b variable. This is done using the new
	        	//operator.
	        	b.setUserId(rs.getInt(1));/* Set the value of the UserId variable
	        	* to rs.getInt(1) where 1 is the first column named "UserId". The
	        	* data stored in the ResultSet object is retrieved through a set of
	        	* get methods that allows access to the various columns of the
	        	* current row.
	        	*/
				b.setFirstName(rs.getString(2));
				b.setLastName(rs.getString(3));
				b.setEmail(rs.getString(4));
				b.setUsername(rs.getString(5));
				b.setPassword(rs.getString(6));
				b.setUserRoleId(rs.getInt(7));
	            return b;/*return the entire Java object with all name value pairs.
	            * ie., b [userId=1, firstName=Kris, lastName=Lord...]
	            */
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return b;// null
	}

	public List<Account> findAllReimb(){
		List<Account> Accounts = new ArrayList<Account>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from nano_reimbursement");
			while(rs.next()) {
				Account a = new Account();
				a.setAccountId(rs.getInt(1));
				a.setBalance(rs.getDouble(2));
				a.setSubmitted(rs.getTimestamp(3));
				a.setResolved(rs.getTimestamp(4));
				a.setDescription(rs.getString(5));
				a.setReceipt(rs.getBlob(6));
				a.setAuthor(rs.getInt(7));
				a.setResolver(rs.getInt(8));
				a.setStatusId(rs.getInt(9));
				a.setAccountType(rs.getInt(10));
				Accounts.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Accounts;
	}
	
	public UserInformation getUserInfo(User u) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select reimb.reimbid, reimb.reimbamount, resolver.firstname as resolverfn, resolver.lastname, reimb.reimbsubmitted, reimb.reimbresolved, reimb.reimbdescription, reimb.reimbreceipt, rtype.reimbtype, rstatus.reimbstatus, reimb.reimbauthor, reimb.reimbresolver " + 
					"from nano_reimbursement reimb " + 
					"inner join nano_reimbursement_type rtype " + 
					"on rtype.reimbtypeid = reimb.reimbtypeid " +
					"inner join nano_reimbursement_status rstatus " +
					"on rstatus.reimbstatusid = reimb.reimbstatusid " +
					"inner join nano_user resolver on resolver.userid = reimb.reimbresolver " +
					"where reimb.reimbauthor = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getUserId());

			UserInformation info = new UserInformation();
			info.setUser(u);
			List<AccountInfo> accounts = new ArrayList<AccountInfo>();

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				AccountInfo temp = new AccountInfo();
				temp.setId(rs.getInt(1));
				temp.setBalance(rs.getDouble(2));
				temp.setResolverfn(rs.getString(3));
				temp.setResolverln(rs.getString(4));
				temp.setSubmitted(rs.getTimestamp(5));
				temp.setResolved(rs.getTimestamp(6));
				temp.setDescription(rs.getString(7));
				temp.setReceipt(rs.getBlob(8));
				temp.setRtype(rs.getString(9));
				temp.setRstatus(rs.getString(10));
				temp.setAuthor(rs.getInt(11));
				temp.setResolver(rs.getInt(12));
				accounts.add(temp);
			}
			info.setAccounts(accounts);
			return info;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public UserInformation getMgrInfo(User u) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select reimb.reimbid, reimb.reimbamount, author.FIRSTNAME as authorfn, author.lastname, resolver.firstname as resolverfn, resolver.lastname, reimb.reimbsubmitted, reimb.reimbresolved, reimb.reimbdescription, reimb.reimbreceipt, rtype.reimbtype, rstatus.reimbstatus, reimb.reimbauthor, reimb.reimbresolver " + 
					"from nano_reimbursement reimb " + 
					"inner join nano_reimbursement_type rtype " + 
					"on rtype.reimbtypeid = reimb.reimbtypeid " +
					"inner join nano_reimbursement_status rstatus " +
					"on rstatus.reimbstatusid = reimb.reimbstatusid " +
					"inner join nano_user author on author.USERID = reimb.reimbauthor " +
					"inner join nano_user resolver on resolver.userid = reimb.reimbresolver " +
					"where reimb.reimbresolver = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getUserId());

			UserInformation info = new UserInformation();
			info.setUser(u);
			List<AccountInfo> accounts = new ArrayList<AccountInfo>();

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				AccountInfo temp = new AccountInfo();
				temp.setId(rs.getInt(1));
				temp.setBalance(rs.getDouble(2));
				temp.setAuthorfn(rs.getString(3));
				temp.setAuthorln(rs.getString(4));
				temp.setResolverfn(rs.getString(5));
				temp.setResolverln(rs.getString(6));
				temp.setSubmitted(rs.getTimestamp(7));
				temp.setResolved(rs.getTimestamp(8));
				temp.setDescription(rs.getString(9));
				temp.setReceipt(rs.getBlob(10));
				temp.setRtype(rs.getString(11));
				temp.setRstatus(rs.getString(12));
				temp.setAuthor(rs.getInt(13));
				temp.setResolver(rs.getInt(14));
				accounts.add(temp);
			}
			info.setAccounts(accounts);
			return info;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Account2 save(Account2 acc) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO NANO_REIMBURSEMENT (REIMBAMOUNT, REIMBSUBMITTED, REIMBDESCRIPTION, REIMBAUTHOR, REIMBRESOLVER, REIMBSTATUSID, REIMBTYPEID)"
					+ "VALUES(?,?,?,?,?,?,?)";
		
			String[] generatedKeys = {"REIMBID"};
			PreparedStatement ps = conn.prepareStatement(sql, generatedKeys);
		
			ps.setDouble(1, acc.getBalance());
			ps.setTimestamp(2, acc.getSubmitted());
			ps.setString(3, acc.getDescription());
			ps.setInt(4, acc.getAuthor());
			ps.setInt(5, acc.getResolver());
			ps.setInt(6, acc.getStatusId());
			ps.setInt(7, acc.getAccountType());
			
			ps.executeUpdate();
			ResultSet pk = ps.getGeneratedKeys();
			 pk.next();
			 acc.setAccountId(pk.getInt(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acc;
	}
	
}

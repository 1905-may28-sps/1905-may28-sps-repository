package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.pojo.Account;
import com.revature.util.ConnectionFactory;

public class AccountDAO {

	
	static String fn;
	static String ln;
	static String un;
	static String pass;
	static String an;
	static double transact;
	static String opt;
	static double balance;
	static Scanner scan= new Scanner(System.in);
	static String username;
	public static Account newAcc=new Account();
	
	


	public static void createSpecAcc(String un) {
		username=un;
		System.out.println("Choose Account Type (1) Checkings (2) Savings");
		opt=scan.nextLine();
		
		System.out.println("Enter unique account name?");
		an=scan.nextLine();
		System.out.println(an);
		System.out.println("Enter an initial balance, if you are not going to add anything just put 0.");
		balance=scan.nextDouble();
		System.out.println("Creating Your Account...");	
		
		if(accType(opt) != null && !accType(opt).equals("")&&an != null && !an.equals("")&&un != null && !un.equals("")){
			
			newAcc.setType(accType(opt));
			newAcc.setName(an);
			newAcc.setBal(balance);
			newAcc.setUsername(un);
			newAcc = save(newAcc);
			System.out.println("Sucessful Creation!");
			System.out.println(newAcc);
			UserDAO.postLog(un);
			}else {
				System.out.println("Please Enter Valid Inputs");
				createSpecAcc(username);
			}
	}
	
	public static Account save(Account acc) {
		try(Connection conn=ConnectionFactory.getInstance().getConnection()){
					
					
					//conn.setAutoCommit(false);
					
					String sql="insert into BaNK_ACCOUNT (ACCOUNT_TYPE,ACCOUNT_NAME,ACCOUNT_BALANCE,USERNAME) VALUES (?,?,?,?)";
					String[] generatedKeys= {"ACCOUNT_ID"};
					PreparedStatement ps=conn.prepareStatement(sql, generatedKeys);
					ps.setString(1,acc.getType());
					ps.setString(2,acc.getName());
					ps.setDouble(3,acc.getBal());
					ps.setString(4,acc.getUsername());
					
					ps.executeUpdate();
					
					ResultSet pk= ps.getGeneratedKeys();
					
					pk.next();//move to first row
					acc.setId(pk.getInt(1));
					
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return acc;
				}
	
	public Account viewBal(String un) {
		System.out.println("Enter account name, that you would like to see");
		an=scan.nextLine();
		
		Account a= null;
		try(Connection conn=ConnectionFactory.getInstance().getConnection()){
			String query="SELECT * FROM BANK_ACCOUNT WHERE  lower(USERNAME)=? AND lower(ACCOUNT_NAME)=? "; 
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1,un);//number,value
			ps.setString(2,an);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {//or if
				a=new Account();
				a.setId(rs.getInt(1));
				a.setType(rs.getString(2));
				a.setName(rs.getString(3));
				a.setBal(rs.getDouble(4));
				a.setUsername(rs.getString(5));
			}
			
			System.out.println(a);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {UserDAO.postLog(un);}
		
		return a;
		
		
	}
	
	public static String accType(String type) {
		switch (type) {
		case "1":return "Checking";
		case "2":return "Savings";
		default: createSpecAcc(username);
		}
		return null;
	}
	
	public static List<Account> viewAllAcc(String un){
		List<Account> accs=new ArrayList<Account> ();
	
	try(Connection conn=ConnectionFactory.getInstance().getConnection()){
		String query="SELECT * FROM BANK_ACCOUNT WHERE  lower(USERNAME)='"+un+"'";
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next()) {
			Account temp=new Account(rs.getString(2),rs.getDouble(4),rs.getString(3),rs.getString(5),rs.getInt(1));
			accs.add(temp);
		}
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}finally {
		System.out.println(accs);
		UserDAO.postLog(un);}
	
	return accs;
	}
	
}

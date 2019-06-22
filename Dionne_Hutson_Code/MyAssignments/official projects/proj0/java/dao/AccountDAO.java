package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.pojo.Account;
import com.revature.pojo.User;
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
	
	public void viewBal() {
		scan=new Scanner(System.in);
		System.out.println("Enter account name, that you would like to see");
		an=scan.nextLine();
		
		
	}
	
	public static String accType(String type) {
		switch (type) {
		case "1":return "Checking";
		case "2":return "Savings";
		default: createSpecAcc(username);
		}
		return null;
	}
	
	
	
}

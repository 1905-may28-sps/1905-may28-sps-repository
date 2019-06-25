package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.app.OverdraftException;
import com.revature.pojo.Account;
import com.revature.util.ConnectionFactory;

public class AccountDAO {


	static String fn;
	static String ln;
	static String un;
	static String pass;
	static int id;
	static double transact;
	static String opt;
	static double balance;
	static Scanner scan= new Scanner(System.in);
	static String username;
	public static Account newAcc=new Account();
	static Scanner scanD= new Scanner(System.in);

	public static double myDoub() {
		scanD= new Scanner(System.in);
		double doub = 0;
		
		try {
			doub=Double.parseDouble(scanD.nextLine());
			if(doub>=0) {
			return doub;}
			else {
				System.out.println("This value cannot be less than zero\nEnter a value greater than or equal to zero");
				return myDoub();
				
			}
		}catch(NumberFormatException e) {
			System.out.println("Enter a Double value");
			doub=myDoub();
		}
		return doub;
	}

	public static void createSpecAcc(String un) {
		username=un;
		System.out.println("Choose Account Type (1) Checkings (2) Savings");
		opt=accType();

		System.out.println("Enter an initial balance, if you are not going to add anything just put 0.");
		balance=myDoub();
		System.out.println("Creating Your Account...");	

		if(opt != null && !opt.equals("")&&un != null && !un.equals("")){

			newAcc.setType(opt);
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
	public static String accType() {
		String type=scan.nextLine();
		switch (type) {
		case "1":return "Checking";
		case "2":return "Savings";
		default: 
			System.out.println("You have entered an invalid value. ");
			System.out.println("Choose Account Type (1) Checkings (2) Savings");
			return accType();}

	}
	public static Account save(Account acc) {
		try(Connection conn=ConnectionFactory.getInstance().getConnection()){


			//conn.setAutoCommit(false);

			String sql="insert into BaNK_ACCOUNT (ACCOUNT_TYPE,ACCOUNT_BALANCE,USERNAME) VALUES (?,?,?)";
			String[] generatedKeys= {"ACCOUNT_ID"};
			PreparedStatement ps=conn.prepareStatement(sql, generatedKeys);
			ps.setString(1,acc.getType());
			ps.setDouble(2,acc.getBal());
			ps.setString(3,acc.getUsername());

			ps.executeUpdate();

			ResultSet pk= ps.getGeneratedKeys();

			pk.next();//move to first row
			acc.setId(pk.getInt(1));


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acc;
	}
	public static double viewBal(String un, int id) {
		Double a= 0.0;
		try(Connection conn=ConnectionFactory.getInstance().getConnection()){
			String query="SELECT * FROM BANK_ACCOUNT WHERE  lower(USERNAME)=? AND ACCOUNT_ID=? "; 
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1,un);//number,value
			ps.setInt(2,id);
			ResultSet rs=ps.executeQuery();

			while(rs.next()) {//or if
				a=rs.getDouble(3);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return a;


	}
	public static Account viewSAcc(String un) {
		System.out.println("Enter account id, that you would like to see");
		id=scan.nextInt();
		Account a= null;
		if (validId(un, id)) {

			
		try(Connection conn=ConnectionFactory.getInstance().getConnection()){
			String query="SELECT * FROM BANK_ACCOUNT WHERE  lower(USERNAME)=? AND ACCOUNT_ID=? "; 
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1,un);//number,value
			ps.setInt(2,id);
			ResultSet rs=ps.executeQuery();

			while(rs.next()) {//or if
				a=new Account();
				a.setId(rs.getInt(1));
				a.setType(rs.getString(2));
				a.setBal(rs.getDouble(3));
				a.setUsername(rs.getString(4));
			}

			System.out.println(a);
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {UserDAO.postLog(un);}
	}else {
		UserDAO.postLog(un);}

		return a;


	}

	public static List<Account> viewAllAcc(String un){
		List<Account> accs=new ArrayList<Account> ();

		try(Connection conn=ConnectionFactory.getInstance().getConnection()){
			String query="SELECT * FROM BANK_ACCOUNT WHERE  lower(USERNAME)='"+un+"'";
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				Account temp=new Account(rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getInt(1));
				accs.add(temp);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			System.out.println(accs);
			UserDAO.postLog(un);}

		return accs;
	}



	public static void deposit(String un) {
		System.out.println("Enter the id of the account you would like to make a deposit in:");
		id=scan.nextInt();
		System.out.println("Enter the amount you would like to deposit");
		double deposit=myDoub();
		if (validId(un,id)) {
		
			System.out.println("Making a Deposit...");
			try (Connection conn=ConnectionFactory.getInstance().getConnection()){
				String query=" {call deposit(?,?,?) }";//calling call statement
				CallableStatement cs=conn.prepareCall(query);
				cs.setString(1,un);
				cs.setInt(2,id);
				cs.setDouble(3, deposit);
				cs.execute();
				System.out.println("Deposit Complete");


			} catch (SQLException e) {
				System.out.println("Unsucessful Deposit");
				e.printStackTrace();
			}finally {
				UserDAO.postLog(un);
			}	
		
		}else {
			UserDAO.postLog(un);}
	}
	public static void withdrawl(String un) {
		System.out.println("Enter the id of the account you would like to make a withdrawl from:");
		id=scan.nextInt();
		System.out.println("Enter the amount you would like to withdraw");
		double withdraw=myDoub();
		if (validId(un,id)) {
				try {	
					if (withdraw<=viewBal(un,id)) {
						System.out.println("Making a Withdrawl...");
						try (Connection conn=ConnectionFactory.getInstance().getConnection()){
							String query=" {call withdraw(?,?,?) }";//calling call statement
							CallableStatement cs=conn.prepareCall(query);
							cs.setString(1,un);
							cs.setInt(2,id);
							cs.setDouble(3, withdraw);
							cs.execute();
							System.out.println("Withdrawl Complete");


						} catch (SQLException e) {
							System.out.println("Unsucessful Withdrawl");
							e.printStackTrace();
						}finally {
							UserDAO.postLog(un);
						}
					}else {
						System.out.println("This withdrawl amount exceeds your balance");
						throw new OverdraftException();}
				}catch(OverdraftException e) {
					
					UserDAO.postLog(un);
				}
			

		}else {
			UserDAO.postLog(un);}


	}


	public static boolean validId(String un,int id) {

		try(Connection conn=ConnectionFactory.getInstance().getConnection()){
			String query="select * From Bank_Account WHERE lower(USERNAME)=? AND ACCOUNT_ID=?";

			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1,un);

			ps.setInt(2,id);
			ResultSet rs=ps.executeQuery();

			if(rs.next()) {
				return true;
			}else {
				System.out.println("Invalid ID");
				return false;}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}

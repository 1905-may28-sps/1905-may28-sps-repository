package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.pojo.User;
import com.revature.util.ConnectionFactory;

public class UserDAO {
	

	
	static String fn;
	static String ln;
	static String un;
	static String pass;
	static String an;
	static double transact;
	static String opt;
	static double balance;
	static Scanner scan= new Scanner(System.in);
	static AccountDAO aDAO= new AccountDAO();
	public static User newUser=new User();
	
	public static void crelogopt() {
		System.out.println("Enter 1 if you want to create an account with us. Enter 2 if you want to log into an account");
		opt=scan.nextLine();	
		
		switch (opt) {
		case "1": createAcc();break;
		case "2": logIn();break;
		default: crelogopt();
		}
	}
	public static void createAcc() {
		scan=new Scanner(System.in);
		System.out.println("Welcome! Enter your first name?");
		fn=scan.nextLine();
		System.out.println("Enter your last name?");
		ln=scan.nextLine();
		System.out.println("Enter a username (if this is taken you cannot use it).");
		un=scan.nextLine();
		System.out.println("Enter a password. It could be as weak as you want, but remember this is your bank.");
		pass=scan.nextLine();
		System.out.println("Creating your account...");
		
//		User newUser=new User();
		if(fn != null && !fn.equals("")&&ln != null && !ln.equals("")&&un != null && !un.equals("")&&pass != null && !pass.equals("")){
		if(!validUsername(un))	{
		newUser.setFn(fn);
		newUser.setLn(ln);
		newUser.setUn(un);
		newUser.setPass(pass);
		newUser = save(newUser);
		System.out.println("Sucessful Creation!");
		System.out.println(newUser);
		postLog(un);
		}
		else {
			System.out.println("This Username is Taken");
			createAcc();
		}
		}else {
			System.out.println("Please Enter Valid Inputs");
			crelogopt();
		}
		
		
	}
	
	public static User save(User user) {
try(Connection conn=ConnectionFactory.getInstance().getConnection()){
			
			
			//conn.setAutoCommit(false);
			
			String sql="insert into bank_user(first_name, last_name, username,password)values(?,?,?,?)";
			String[] generatedKeys= {"USER_ID"};
			PreparedStatement ps=conn.prepareStatement(sql, generatedKeys);
			ps.setString(1,user.getFn());
			ps.setString(2,user.getLn());
			ps.setString(3,user.getUn());
			ps.setString(4,user.getPass());
			
			ps.executeUpdate();
			
			ResultSet pk= ps.getGeneratedKeys();
			
			pk.next();//move to first row
			user.setId(pk.getInt(1));
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
		}
		
	
	

	public static void logIn() {
			scan=new Scanner(System.in);
			System.out.println("Enter your username.");
			un=scan.nextLine();
			System.out.println("Enter your password. ");
			pass=scan.nextLine();
			System.out.println("Logging in..");
			
			
			if(validUsername(un)&&validPass(un,pass)) {
			System.out.println("Sucessfull Log In!");
			
			
			postLog(un);}else {

				logIn();
			}
			
		}
	public static boolean validUsername(String un) {
		
		try(Connection conn=ConnectionFactory.getInstance().getConnection()){
			String query="select USERNAME From Bank_User WHERE lower(USERNAME)=?";
			
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1,un);
			ResultSet rs=ps.executeQuery();
		
			if(rs.next()) {
			if(rs.getString(1).equalsIgnoreCase(un)) {
				return true;
			}
			}else {
				System.out.println("Invalid Username");
				return false;}
		} catch (SQLException e) {
			System.out.println("Invalid Username");
			e.printStackTrace();
		}
		return false;
	}
	public static boolean validPass(String un, String pass) {
		
		try(Connection conn=ConnectionFactory.getInstance().getConnection()){
			String query="select password From Bank_User WHERE lower(USERNAME)=?";
			
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1,un);
			ResultSet rs=ps.executeQuery();
		
			if(rs.next()) {
			if(rs.getString(1).equals(pass)) {
				return true;
			}else {
				System.out.println("Invalid Password");
				return false;}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	 public static void postLog(String un) {
		  scan=new Scanner(System.in);
		  System.out.println("Woud you like to (1) Create New Account, (2) View Account Balance(3) View All Accounts (4) Make a Deposit (5)Log Out");//account as in bank account
		  opt=scan.nextLine();	
			
			switch (opt) {
			case "1":AccountDAO.createSpecAcc(un);break;
			case "2":aDAO.viewBal(un);break;
			case "3":AccountDAO.viewAllAcc(un); break;
			case "4":AccountDAO.deposit(un);break;
			case "5":logOut();break;
			default:postLog(un);
			}
	

}
	 public static void logOut() {
		 System.out.println("Would you like to log out (1)Yes (2)No");
		 opt=scan.nextLine();
		 switch (opt) {
		 case "1":
		 System.out.println("Logging out...");
		 newUser.setFn(null);
		 newUser.setId(0);
		 newUser.setLn(null);
		 newUser.setPass(null);
		 newUser.setUn(null);
		 System.out.println("Goodbye, Your Money is safe with us!");
		 break;
		 case "2":
			 default:
			 postLog(un);
			 break;
		 }
		
	}
}
	

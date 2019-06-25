package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import BankJava.BankFirst;
import BankJava.HomePage;
import POJO.Users;
import util.ConnectionFactory;
import java.sql.SQLIntegrityConstraintViolationException;

public class UserDao {
//	
//	public List<Users> findAll(){
//		List<Users> users = new ArrayList<Users>();
//		
//		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
//			Statement st = conn.createStatement();
//			
//			ResultSet rs = st.executeQuery("select * from Bank_User");
//			while(rs.next()) {
//				Users a = new Users();
//				a.setUser_id(rs.getInt(1));
//				a.setFName(rs.getString(2));
//				a.setLName(rs.getString(3));
//				a.setUName(rs.getString(4));
//				a.setPWord(rs.getString(5));
//				users.add(a);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return users;
//	}
//Prepared statement safe from injection	
	public Users register(Users uSer) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "INSERT INTO Bank_User (FIRSTNAME, LASTNAME, USERNAME, PASSWORD) VALUES (?, ?, ?, ?)";
			String[] generatedKeys = {"USERID"}; //takes an array just in case we have more than 1 key
			PreparedStatement ps = conn.prepareStatement(sql, generatedKeys);
			ps.setString(1, uSer.getFName());
			ps.setString(2, uSer.getLName());
			ps.setString(3, uSer.getUName());
			ps.setString(4, uSer.getPWord());
			ps.executeUpdate();
			ResultSet pk = ps.getGeneratedKeys();
			pk.next();
			uSer.setUser_id(pk.getInt(1));
		} 
		catch (SQLIntegrityConstraintViolationException e)
		{System.out.println("Username has been taken");}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return uSer;
	}
	//create returning user login statement warning** prone to injection
	public Users returning(Users uSer) {
		//Users u=null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "Select * From Bank_User where Username=? and Password =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uSer.getUName());
			ps.setString(2, uSer.getPWord());
			ResultSet pk = ps.executeQuery();
			
			//if(pk.next()) {
			if(pk.next()) {
			uSer.setUser_id(pk.getInt(1));
			uSer.setFName(pk.getString(2));
			uSer.setLName(pk.getString(3));
			uSer.setUName(pk.getString(4));
			uSer.setPWord(pk.getString(5));
			}
		//	}
			//System.out.println(pk.getInt(1));
			//System.out.println("Login Success "+pk.getString(2));
			//move screen to next page
			
			
			
//			}
			else {
				System.out.println("Username/Password mismatch, would you like to try again or create a new account");
				System.out.println("Please Enter 1 to try again, 2 to register");
				BankFirst.LogOrReg();
			}
			
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return uSer;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

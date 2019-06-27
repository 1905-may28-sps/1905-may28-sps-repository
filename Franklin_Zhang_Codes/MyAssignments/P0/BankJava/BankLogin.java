package BankJava;

import java.sql.*;

import java.util.*;


import DAO.UserDao;
import POJO.Users;
import util.ConnectionFactory;

public class BankLogin {

	static Scanner scan = new Scanner(System.in);
	static UserDao uDao = new UserDao();

	
	
//	public static void main(String[] args) {
//		checkUser();
//		//System.out.println(findAll());
//	}

	public static void checkUser(){
		System.out.println("Enter Username: ");
		String un = scan.nextLine();
		un=un.replaceAll("\\s","").toLowerCase();
		// test if this works System.out.println(un);
		System.out.println("Enter Password:");
		String pw = scan.nextLine();
		//System.out.println("broke?");
		Users returningUser = new Users();
		returningUser.setUName(un);
		returningUser.setPWord(pw);
		returningUser=uDao.returning(un,pw);
		//System.out.println(returningUser);
		if(returningUser!=null) {
			//System.out.println("Welcome " + returningUser.getFName()+" "+returningUser.getLName()); 
			HomePage.CreateOrView(returningUser);
		}
		else {
			System.out.println("Username/Password Mismatch! Please try again.");
			//System.out.println("Please Enter 1 to try again, 2 to register");
			BankFirst.LogOrReg();	
		}
	};
}
		
	
	
	
	


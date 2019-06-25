package BankJava;

import java.sql.*;

import java.util.*;


import DAO.UserDao;
import POJO.Users;
import util.ConnectionFactory;

public class BankLogin {

	static Scanner scan = new Scanner(System.in);
	static UserDao uDao = new UserDao();

	
	
	public static void main(String[] args) {
		checkUser();
		//System.out.println(findAll());
	}

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
		returningUser=uDao.returning(returningUser);
		System.out.println(returningUser);
	};
}
		
	
	
	
	


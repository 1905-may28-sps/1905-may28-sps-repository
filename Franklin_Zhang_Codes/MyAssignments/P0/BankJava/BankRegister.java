package BankJava;

import java.util.Scanner;
import java.lang.String;
import DAO.UserDao;
import POJO.Users;

public class BankRegister {
	static Scanner scan = new Scanner(System.in);
	static UserDao uDao = new UserDao();
	
	
	
	public static void main(String[] args) {

		addUser();
	}
	

	public static void addUser() {
		System.out.println("Please Enter your First Name");
		String fn = scan.nextLine();
		System.out.println("Please Enter your Last Name");
		String ln = scan.nextLine();
		System.out.println("Please Enter your User-Name:");
		String un = scan.nextLine();
		un = un.toLowerCase().replaceAll("\\s", "");
		System.out.println("Please Enter your Password:");
		String pw = scan.nextLine();
		Users newUser = new Users();
		newUser.setFName(fn);
		newUser.setLName(ln);	
		newUser.setUName(un);
		newUser.setPWord(pw);
		newUser = uDao.register(newUser);
		System.out.println("Congrats! User Account created! redirecting to login....");
		BankFirst.LogOrReg();
	}
}

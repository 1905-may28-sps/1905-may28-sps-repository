package com.revature.app;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.revature.dao.UserDAO;
import com.revature.dao.AccountDAO;
import com.revature.dao.GenreDAO;
import com.revature.pojos.User;
import com.revature.util.ConnectionFactory;
import com.revature.pojos.Account;


public class BankTransact {
	
	static Scanner scan = new Scanner(System.in);
	static UserDAO custDao = new UserDAO();
	static UserDAO userLog = new UserDAO();
	static AccountDAO accDao = new AccountDAO();
	static AccountDAO acc1Dao = new AccountDAO();
	static AccountDAO acc2Dao = new AccountDAO();

public static void main(String[] args) {
	mainmenu();
}
	
static void mainmenu() {
		System.out.print("Welcome to My Bank !\n"
				+"Enter a choice (What you want to do)"
				+ "\n 1 ....for login (if you are already registered)"
				+ "\n 2 ....for Registeration as new User \n");
		System.out.println("\n(...........Please enter 1 or 2...........)");
		
		
		Scanner ch = new Scanner(System.in);
				int choice =ch.nextInt();
				
				
				
			   switch(choice)
		      {
		 case 1:
				
			 System.out.println("Enter username");
				String username = scan.nextLine();
				
				System.out.println("Enter password");
				String password = scan.nextLine();
				
				User myObj = new User();
				myObj.setUsername(username);
				myObj.setPassword(password);
				
				boolean UserExists =  userLog.userLogin(myObj);
				if (UserExists == false) {
					System.out.println("\nInvalid Username/Password. Please Try Again!\n\n");
					
					mainmenu();
					break;
				}
				
				else {
				
				System.out.println("You are successfully logged in !\n");
				
				
				usermenu();
				}
				
				break;
				
	
	
		 case 2:
				//New Registration Save User
			 System.out.println("\n Welcome to New Registration  !");
				System.out.println("\n PLEASE NOTE: To Register new as user, Username has to be Unique...");
				System.out.println("\n Enter your new Username");
				String username1 = scan.nextLine();
				
				UserDAO exObj = new UserDAO();
				User myObj1= new User();
				myObj1.setUsername(username1);
				boolean UserExists1 = exObj.userValidate(myObj1);
				if (UserExists1==true){
					System.out.println("Username alraedy taken. Try another!...\n");
					mainmenu();
					break;
					}
				else {
				System.out.println("Password");
				String password1 =scan.nextLine();
					
				
				System.out.println("First Name");
				String fname = scan.nextLine();
				
				
				System.out.println("Last Name");
				String lname = scan.nextLine();
				
				
				System.out.println("Email");
				String email =scan.nextLine();
					
				User newUser = new User();
				newUser.setFirstName(fname);
				if(lname != null && !lname.equals("")) newUser.setLastName(lname);
				newUser.setEmail(email);
				newUser.setUsername(username1);
				newUser.setPassword(password1);
				
				newUser = custDao.save(newUser);
				
				System.out.println ("Thank you "+ fname+" "+ lname +" for banking with us. \n\n");
				mainmenu();
					break;
				}					
		default:
			// Default 
			System.out.println ("Please enter a valid choice...\n");
			
			mainmenu();
		      }				
		}


static void usermenu() {
	
	System.out.print("Hi ! Welcome .........."  
			+"Enter a choice (What you want to do)"
			+ "\n 1 ....for Balance Enquiry"
			+ "\n 2 ....for Deposit"
			+" \n 3 ....for Withdrawl"
			+ "\n 4 ....Log Out \n");
	System.out.println("( Please enter choice 1 to 4)");
		
	Scanner ch1 = new Scanner(System.in);
	int choice1 = ch1.nextInt();
   switch(choice1)
		      {
		      case 1:
//				 CHECK BALANCE
		    	  Scanner sc2= new Scanner(System.in);
		    	  System.out.println("Enter Customer ID");
					int custid =sc2.nextInt();
		    	  Account accounts = accDao.checkBalance(custid);
	 		  //System.out.println(accounts);
		    	 System.out.println("Have a great day !\n "); 				
						usermenu();				
				  		break; 
			 case 2:
					//Deposit
				 
				 System.out.println("Enter Deposit amount");
				 int credit =scan.nextInt();
				 System.out.println("Please Confirm Customer ID");
					int c2 =scan.nextInt();
					Account acc2 = acc2Dao.updateCrBal(credit,c2);
			 		 // System.out.println(acc2);
				 usermenu();
				 break;
				 
			 case 3:
					//Widhdrawl
				 
				 System.out.println("Enter Withdrawl amount");
				 int debit =scan.nextInt();
				 System.out.println("Please Confirm Customer ID");
					int c1 =scan.nextInt();
					Account acc1 = acc1Dao.updateDbBal(debit,c1);
			 		  //System.out.println(acc1);
				 
				 usermenu();
				 break;
				 
			 case 4:
				 System.out.println("\n You are successfully logged out");		 
				 default:
				 System.out.println("Thanks for visiting My Bank\n\n\n\n");
					mainmenu(); 
					
		      }
	}
}







	
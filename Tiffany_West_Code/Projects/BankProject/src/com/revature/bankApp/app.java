package com.revature.bankApp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import com.revature.dao.AccountDAO;
import com.revature.dao.TypeDAO;
import com.revature.dao.UserDAO;
import com.revature.pojos.Account;
import com.revature.pojos.Type;
import com.revature.pojos.User;
import com.revature.util.ConnectionFactory;

public class app {

	static Scanner scan = new Scanner(System.in);
	static UserDAO userDao = new UserDAO();
	static TypeDAO typeDao = new TypeDAO();
	static AccountDAO accDao = new AccountDAO();

	public static void main(String[] args)  throws MyException {
		
		welcomeView();
		
		
		
		//list Account types might have to put this in a switch statement
		TypeDAO tdao = new TypeDAO();
		List<Type> types =tdao.findAll();
	//System.out.println("Account Types: " + types );
		
	}
	
	
	public static void welcomeView() {
		
		System.out.println("Welcome to West Investments, would you like to sign in "
				+ "or create an account?\n "
				+ "Press 1 : Sign-In \n "
				+ "Press 2 : Create a New Account");
		String welcome = scan.nextLine();
		switch(welcome) {
		case "1": signIn();
		break;
		case "2": createAccount();
		break;
		default:
			System.out.println("please enter 1 or 2");
			welcomeView();
		}
		
	}

	 public static void signIn() {
		 
		
		
		System.out.println("Enter your Username: ");
		String un = scan.nextLine();
	
		Valuser(un);
		un=un.replaceAll("\\s", "").toLowerCase();
		
		System.out.println("Enter your Password: ");
		String pw = scan.nextLine();
		
		Valpass(pw);
		
		
		if(Valpass(pw)) {
			System.out.println("Login Successful!");
			
			dashboard();
		}
		
	
		

	}
	
	
	static void createAccount() {

		  	System.out.println("Follow these instructions to create an account");
		  	System.out.println("First Name: ");
		  	String fn = scan.nextLine();
		  	System.out.println("Last Name: ");
		  	String ln = scan.nextLine();
		  	System.out.println("Choose a username: ");
		  	String un = scan.nextLine();
		  	System.out.println("Choose a password: ");
		  	String pw = scan.nextLine();
		  	
		  	User newUser = new User();
		  	
		  	if(fn !=null && !fn.equals("")) newUser.setFirstName(fn);
		  	if(ln !=null && !ln.equals("")) newUser.setLastName(ln);
		  	if(un !=null && !un.equals("")) newUser.setUserName(un);
		  	if(pw !=null && !pw.equals("")) newUser.setPassword(pw);

		  		
		  	newUser = userDao.addUser(newUser);
		  	//System.out.println(newUser);
		  	System.out.println("Congratulations "+ newUser.getFirstName() +", use your new username: " + newUser.getUserName() + " to sign in and add to your account");
		  	//if (fn==null || fn.isEmpty()) 
		  	//put this in a try catch  finally to make sure the input isn't null or empty
		  	
		  	
		  	//after account is created go back to the welcome view to sign in
		  	dashboard();
		}
	  
	  public static void Display() {
		  /*
			try(Connection conn = ConnectionFactory.getInstance().getConnection()){
				
				
				
				
				 * 				Statement stmt = conn.createStatement();

				 * 
				 * 	String sql = " select bank_user.first_name, bank_user.last_name, bank_account.balance,bank_account.account_number,bank_account_type.type\n" + 
						"from bank_account\n" + 
						" join bank_user on bank_user.user_id = bank_account.user_id \n" + 
						" join bank_account_type on bank_account.type_id = bank_account_type.type_id\n" + 
						" where  username =  ? and password = ? ";
				
				
				
				
				
					
					
					
					System.out.println("Account Info:\n "
							+ "First Namae: "+fname +  "Last Name: " + lname+ " Balance: $"+bal+
							" Account Number: "+ acn+ " Account Type: "+ type);
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
				 */
			
		
	  }
		
	
	   static boolean Valuser(String username) {
		  //User users = new User();
		  User users = null;
		  boolean valid = false;
		  
		  try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			 String sql = "select username from bank_user where username = ? ";
			 
			 PreparedStatement ps = conn.prepareStatement(sql);
			 	ps.setString(1, username);
			 
	            ResultSet rs = ps.executeQuery();
	            while(rs.next()) {
	            	users = new User();
	            	users.setUserName(rs.getString(1));
	            }
	            		
	            	
		  } catch (SQLException e) {
			e.printStackTrace();
		}	 try { 
			  if(users.getUserName().equals(username)) {
				  valid = true;
			  }
			  
			  else {
				  System.out.println("else wrong password");
				//signIn();  
			  }
			 }
			 catch(Exception e) {
				System.out.println("Wrong username"); 
				signIn();
			 }
			return valid;
	
	  }
	   
	   static boolean Valpass(String password) {
			  //User users = new User();
			  User users = null;
			  boolean valid = false;
			  
			  try (Connection conn = ConnectionFactory.getInstance().getConnection()){
				 String sql = "select password from bank_user where password = ?";
				 
				 PreparedStatement ps = conn.prepareStatement(sql);
				 	ps.setString(1, password);
				 
		            ResultSet rs = ps.executeQuery();
		            while(rs.next()) {
		            	users = new User();
		            	users.setPassword(rs.getString(1));
		            }
		            		
		            	
			  } catch (SQLException e) {
				e.printStackTrace();
			}
			 try { 
			  if(users.getPassword().equals(password)) {
				  valid = true;
			  }
			  
			  else {
				  System.out.println("else wrong password");
				//signIn();  
			  }
			 }
			 catch(Exception e) {
				System.out.println("wrong password"); 
				signIn();
			 }
			return valid;
		  }


	   static void dashboard() {
	   		System.out.println("What would you like to do?");
	   		System.out.println("1: Account Information");
	   		System.out.println("2: Add Account");
	   		System.out.println("3: Withdraw");
	   		System.out.println("4: Deposit");
	   		System.out.println("5: Sign out");
	   		
			String dash = scan.nextLine();
			switch(dash) {
			case "1": accountInfo();
			break;
			case "2": addAccount();
			break;
			case "3": withdraw();
			break;
			case "4": deposit();
			break;
			case "5": 
				System.out.println("Goodbye !");
				// System.out.println("The goal is to have an asset to pay for every liability");
				System.exit(0);
			break;
			}

}



	static void accountInfo() {
		/*
		 * 		   testing this w/o having to "log user in again" nope - maybe I can call the withdraw and deposit from here  or get rid of login and do 
					everything here
		 */
		
		   
		System.out.println("Enter your username again.");
		String un = scan.nextLine();
		Valuser(un);
		System.out.println("Now  your password.");
		String pw = scan.nextLine();
		Valpass(pw);
		
		   String fname;
		   String lname;
		   double bal; //mght have to set to 0
		   int 	  acnum;
		   String type;
		   String username = un; //?
		   User uinfo = null;
		   Type tinfo = null;
		   Account ainfo = null;
		   
		   try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			   
			   String sql = "select bank_user.first_name, bank_user.last_name, bank_account_.balance,bank_account_.account_number, bank_account_type.type\n" + 
			   		"			   		from bank_account_\n" + 
			   		"			   		 join bank_user on bank_user.username = bank_account_.username  \n" + 
			   		"                 join bank_account_type on bank_account_.type_id = bank_account_type.type_id\n" + 
			   		"			   		 where  bank_user.username = ?";
			   
			   PreparedStatement ps = conn.prepareStatement(sql);
			   ps.setString(1, username);
			   ResultSet rs = ps.executeQuery();
			   while(rs.next()) {
				   uinfo = new User();
				   tinfo = new Type();
				   ainfo = new 	Account();
				   
				   uinfo.setFirstName(rs.getString(1));
				   uinfo.setLastName(rs.getString(2));
				   ainfo.setBalance(rs.getDouble(3));
				   ainfo.setAccountNumber(rs.getInt(4));
				   tinfo.setType(rs.getString(5));
				   
				   
				   // this prints out "first last" idk why
				 // System.out.println("Hello "+ uinfo.getFirstName()+ " "+ uinfo.getLastName()+ ",");
				   
				   System.out.println("Your " + tinfo.getType() + " :Account Number: "+ ainfo.getAccountNumber() 
				   + " Has a balance of $" + ainfo.getBalance());
				   
				  // addAccount();
				   
				   dashboard();
			   }
			   
			   
		   } catch (SQLException e) {
			e.printStackTrace();
		}
		   
	   }

	static void addAccount() {
		
		System.out.println("Enter your username again.");
		String un = scan.nextLine();
		Valuser(un);	
		
		System.out.println("How much for your initial deposit ? \n $");
		double init = Double.parseDouble(scan.nextLine());
		
		TypeDAO tdao = new TypeDAO();
		List<Type> types =tdao.findAll();
		System.out.println("Would you like to create any of these Account types:" + types );
		
		System.out.println("Press 1:  For Checking");
		System.out.println("Press 2: For Savings");
		System.out.println("Press 3: for CD");
		System.out.println("Press 4: for Business Checking");
		int accid = Integer.parseInt(scan.nextLine());
		
	
		Account newacc = new Account();
		
		 newacc.setUsername(un);
		newacc.setBalance(init);
	    newacc.setTypeId(accid);
	    newacc = accDao.save(newacc);
	    
	    //System.out.println(newacc);
	    System.out.println("Account Number: " + newacc.getId());
	   System.out.println("Your new balance: $"+ newacc.getBalance() );
	    dashboard();
	    
	    
	  }
	
	
	 static void  withdraw() {
		    AccountDAO AccDao = new AccountDAO();
	        System.out.println("Which account would you like to withdraw from?");
	        Scanner in = new Scanner(System.in);
	        String actnum = in.nextLine();
	        Integer accNum=Integer.parseInt(actnum);
	        System.out.println("How much would you like to withdraw?");
	        String money = in.nextLine();//change input
	        Double amount=Double.parseDouble(money);
	        
	        Account newwith = new Account();
	        
	        newwith.setBalance(amount);
	        newwith.setAccountNumber(accNum);
	        newwith= AccDao.withdraw(newwith);
	    System.out.println("You withdrew or attempted to withdraw $"+ newwith.getBalance());

	        
		dashboard();
	}

	
    public static void deposit() {
    	AccountDAO AccDao = new AccountDAO();
        System.out.println("Which account would you like to deposit to?");
        Scanner in = new Scanner(System.in);
        String actnum = in.nextLine();
        Integer accNum=Integer.parseInt(actnum);
        System.out.println("How much would u like to deposit");
        String money = in.nextLine();//change input
        Double amount=Double.parseDouble(money);
        
        Account newdep = new Account();
        
        newdep.setBalance(-amount);
        newdep.setAccountNumber(accNum);
            
        newdep = AccDao.deposit(newdep);
	   System.out.println("You deposited: $"+ newdep.getBalance() );
	   //System.out.println("Your new balance is : $" + );

	dashboard();	
	}
}




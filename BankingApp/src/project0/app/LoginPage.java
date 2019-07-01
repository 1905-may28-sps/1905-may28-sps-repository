package project0.app;

import java.util.Scanner;

import project0.dao.BankuserDAO;
import project0.pojos.Bankuser;

public class LoginPage {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		System.out.println("Welcome to Revature Books! What would you like to do?\n" + "1. login\n"
				+ "2. create Bank user\n" + "3. exit");

		login();
	}

	public static void login() {
			try {

				int num = Integer.parseInt(scan.nextLine());

				switch (num) {
				case 1:
					Logger();
					break;
				case 2:
					CreateAcc();
					break;
				case 3:
					System.out.println("Bye Bye!");
					break;
				
				default:
				}

			} catch (NumberFormatException e) {
				System.out.println("please enter a number! 1. login 2.join us 3. exit");
				login();
			}
	}

		
		public static void Logger()  {
		
			System.out.println("Log in...");

			
				System.out.println("Enter your user name: ");
				String username = scan.nextLine();
				System.out.println("Enter your password: ");
				String password = scan.nextLine();
				Bankuser newBankuser = new Bankuser();
				
				newBankuser = BankuserDAO.findByUsernameAndPassword(username, password);
				
				if(newBankuser == null) {
					System.out.println();
					System.out.println("INVALID USERNAME OR PASSWORD...");
					login();
				}else {
					Bank.menu();
				}
				
		}

	public static void CreateAcc() {
		System.out.println("Hey! What's your name?");
		String n = scan.nextLine();
		System.out.println("And make up your user name?");
		String un = scan.nextLine();
		System.out.println("choice a password:");
		String pw = scan.nextLine();
		Bankuser newBankuser = new Bankuser();
		newBankuser.setName(n);
		if(un != null && !n.equals("")) newBankuser.setUsername(un);
		newBankuser.setPassword(pw);
		
		newBankuser = BankuserDAO.save(newBankuser);
		System.out.println(newBankuser);
		System.out.println("User Account is created. Try Login! Also, you might want a Checking acc? Just saying!");
		login();
		
	}
}


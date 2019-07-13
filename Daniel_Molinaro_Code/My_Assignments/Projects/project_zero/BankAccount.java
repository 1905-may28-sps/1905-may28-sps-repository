package com.revature.app;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.revature.dao.UserDAO;
import com.revature.dao.AcctDAO;
import com.revature.pojos.User;
import com.revature.pojos.Acct;

public class BankAccount {

	static User user = new User();
	static Acct acc = new Acct();
	static UserDAO uDao = new UserDAO();
	static AcctDAO aDao = new AcctDAO();
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		switchB();
	}

	public static void switchB() {

		int exit = 2;
		while (exit == 2) {

			System.out.println("Main Menu\n" + "(1)Create an account\n" + "(2)Login");
			String number = scan.nextLine();
			if (number.equals("1") || number.equals("2")) {

				switch (number) {

				case "1":
					// ENTER ACCOUNT INFO
					System.out.println("Enter a First Name: ");
					String fn = scan.nextLine();
					System.out.println("Enter a Last Name: ");
					String ln = scan.nextLine();

					// CHECK IF USERNAME EXISTS
					List<User> users = uDao.findAll();
					boolean bool = true;
					String un;
					int count;
					do {
						count = 0;
						System.out.println("Enter a Username: ");
						un = scan.nextLine();

						for (User user : users) {
							if (user.getUserName().equals(un)) {

								count++;

							} else
								continue;
						}
						if (count > 0)
							System.out.println("Username exists!");

					} while (count != 0);

					// CONFIRM PASSWORD
					String pw;
					String pw1;
					boolean bool2 = true;
					do {
						System.out.println("Enter a Password: ");
						pw = scan.nextLine();
						System.out.println("Confirm Password: ");
						pw1 = scan.nextLine();
						if (!pw.equals(pw1)) {
							System.out.println("Passwords Do Not Match!");
						} else
							bool2 = false;
					} while (bool2);

					// SET USER CREDENTIALS
					Random randId = new Random();
					user.setId(randId.nextInt(1000));
					user.setFirstName(fn);
					user.setLastName(ln);
					user.setUserName(un);
					user.setPw(pw);

					// UPDATE DATABASE
					uDao.save(user);
					System.out.println("Username/Password have been created\n");

					// CREATE ACCOUNT TYPE
					System.out.println("Enter an Account Type:\n" + "(1)Savings\n" + "(2)Checking\n" + "(3)Retirement");
					String type = scan.nextLine();

					switch (type) {
					case "1":
						type = "Savings";
						break;
					case "2":
						type = "Checking";
						break;
					case "3":
						type = "Retirement";
						break;
					}

					// ENTER INITIAL DEPOSIT
					System.out.println("Enter intial deposit: ");
					double dep = Double.parseDouble(scan.nextLine());

					// SET ACCOUNT TYPE AND BALANCE
					Random randAcc = new Random();
					acc.setAcct_id(randAcc.nextInt(1000));
					acc.setType(type);
					acc.setUser_id(user.getId());
					acc.setBal(dep);

					// UPDATE DATABASE
					aDao.save(acc);
					System.out.println("A " + type + " Account has been created\n");
					System.out.println(acc + "\n");
					break;

				case "2":

					System.out.println("Enter Account Username: ");
					String un2 = scan.next();
					System.out.println("Enter Account Password: ");
					String pw2 = scan.next();
					UserDAO validUser = new UserDAO();

					User u = validUser.findByUn(un2);

					while (!u.getUserName().equals(un2) || !u.getPw().equals(pw2)) {
						System.out.println("Unsuccessful login");
						System.out.println("Enter Account Username: ");
						un2 = scan.next();
						System.out.println("Enter Account Password: ");
						pw2 = scan.next();
					}

					System.out.println(u + "\n");

					System.out.println("Select Option :\n" + "(1)Deposit\n" + "(2)Withdrawl\n" + "(3)Add Account\n"
							+ "(4)View Account(s)\n");

					String number2 = scan.next();

					switch (number2) {
					case "1":
						// DEPOSIT
						System.out.println(
								"Enter an Account Type:\n" + "(1)Savings\n" + "(2)Checking\n" + "(3)Retirement");
						String typeD = scan.next();

						System.out.println("Enter amount to deposit: ");
						double amountD = scan.nextDouble();

						switch (typeD) {
						case "1":
							Acct a = aDao.findByType("Savings");
							System.out.println(a);
							Acct b = aDao.deposit(a, amountD);
							System.out.println("UPDATED: " + b + "\n");
							break;

						case "2":
							Acct c = aDao.findByType("Checking");
							System.out.println(c);
							Acct d = aDao.deposit(c, amountD);
							System.out.println("UPDATED: " + d + "\n");
							break;

						case "3":
							Acct e = aDao.findByType("Retirement");
							System.out.println(e);
							Acct f = aDao.deposit(e, amountD);
							System.out.println("UPDATED: " + f + "\n");
							break;
						}
						break;

					case "2":
						// WITHDRAW
						System.out.println(
								"Enter an Account Type:\n" + "(1)Savings\n" + "(2)Checking\n" + "(3)Retirement");
						String typeW = scan.next();

						System.out.println("Enter amount to withdraw: ");
						double amountW = scan.nextDouble();

						switch (typeW) {
						case "1":
							Acct a = aDao.findByType("Savings");
							System.out.println(a);
							Acct b = aDao.withdraw(a, amountW);
							System.out.println("UPDATED :" + b + "\n");
							break;

						case "2":
							Acct c = aDao.findByType("Checking");
							System.out.println(c);
							Acct d = aDao.withdraw(c, amountW);
							System.out.println("UPDATED :" + d + "\n");
							break;

						case "3":
							Acct e = aDao.findByType("Retirement");
							System.out.println(e);
							Acct f = aDao.withdraw(e, amountW);
							System.out.println("UPDATED :" + f + "\n");
							break;
						}
						break;

					case "3":
						// CREATE ACCOUNT TYPE
						System.out.println(
								"Enter an Account Type:\n" + "(1)Savings\n" + "(2)Checking\n" + "(3)Retirement");
						String type3 = scan.next();

						switch (type3) {
						case "1":
							type3 = "Savings";
							break;
						case "2":
							type3 = "Checking";
							break;
						case "3":
							type3 = "Retirement";
							break;
						}

						// ENTER INITIAL DEPOSIT
						System.out.println("Enter intial deposit: ");
						double dep3 = scan.nextDouble();

						Random randAcc2 = new Random();
						acc.setAcct_id(randAcc2.nextInt(1000));
						acc.setType(type3);
						acc.setUser_id(u.getId());
						acc.setBal(dep3);

						// UPDATE DATABASE
						aDao.save(acc);

						System.out.println(acc + "\n");
						break;

					// VIEW ACCOUNTS
					case "4":
						List<Acct> numAcc = aDao.findAll(u.getId());
						for (Acct numAccs : numAcc) {
							System.out.println(numAccs);
						}
						System.out.println();
						break;
					}

					break;

				}
				System.out.println("Enter 1 to exit, 2 to continue\n");
				exit = Integer.parseInt(scan.next());

			} else
				System.out.println("Enter a valid choice\n");
		}
	}
}

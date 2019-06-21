package com.revature.introduction;

public class OOPReview {

	public static void main(String[] args) {
		
		// Creating a new bank account >> think instantiate an object... we're going go use constructors
		
		BankAccount acc1 = new BankAccount();
		acc1.accountNumber ="34567";
		acc1.accountType = "Checking";
		acc1.setName("Sophia Lee");
		acc1.setSsn("098742");
		acc1.setRate();
		System.out.println( "Welcome, "+ acc1.getName());
		acc1.balance= 1200;
		int a = 4;
		System.out.println(a++);
		
		acc1.deposit(1500);
		acc1.deposit(1000);
		acc1.withdraw(250);
		
		 System.out.println(acc1.toString());
		/*
		BankAccount acc2 = new BankAccount("Checking Account");
		
		BankAccount acc3 = new BankAccount("Savings Account", 5000);
		acc3.checkBalance();
		
		
		
		//Demo for inheritance
		CDAccount cd1 = new CDAccount();
		cd1.balance = 3000;
		cd1.interestRate = "2.5";
		cd1.name = "Amani";
		cd1.accountType = "CD Account";
		System.out.println(cd1.toString());
		*/
	}
	
	
}


/*
 * Static can be used for methods and properties: if you want to access something directly as pertaining t
 * o the class not specific instance then use the static keyword
 */

class BankAccount implements IRate {
//define variables
	String accountNumber;
	
	// static value belongs to the class (not the object)- its true 
	//final is like constant
	
	private  static final  String routingNumber = "021000022"; 
	private String name;
	private String ssn;
	 String accountType;
	double balance;
	
	/*
	//Contructor definition: 
	//1. are used to define / setup/ initialize properties of an object.
	//2. constructors are IMPLICITYLY called upon instantiation.
	//3. the same name as the class itself.
	//4. constructors have no return type.
	*/
	BankAccount(){
		System.out.println("new account created");
	}
	
	//Overloading: call same method name w/ diff arguements
	BankAccount( String accountType){
		System.out.println("New acount :" + accountType);
	}
	BankAccount(String accountType, double initDeposit){
		System.out.println("New Account :" + accountType + " Initial Deposit : " + initDeposit);
		String Msg = null;
		if (initDeposit < 1000) {
			Msg = "Minumum balance must be $1000";
		} else {
				Msg= "Thanks for your deposit of: $" +initDeposit;
		}
		System.out.println(Msg);
		 balance = initDeposit;
	}
	
	//Encapsulation
	/*
	 * this refers to the class (name)
	 * .name were going to put it there
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", name=" + name + ", ssn=" + ssn + ", accountType="
				+ accountType + ", balance=" + balance + "]";
	}

	/*
	 * 	//define methods  .. 
		public - in the project
		default - in the package
		private -  only available within the class
		protected -


	 */
	 public void deposit( double amount) {
		balance = balance + amount;
		showActivity("Deposit");
	}
	
	 public void withdraw( double amount) {
		balance = balance - amount;
		showActivity("Withdraw");
	}
	void checkBalance() {
		System.out.println("Balance : $" + balance);
	}
	// private can only be called within the class.
	private void showActivity(String activity) {
		System.out.println("You're recent transction: " + activity );
		System.out.println("You're new Balance: $" + balance);
	}

	@Override
	public void setRate() {
			System.out.println("Setting Rate ");		
	}

	@Override
	public void increaseRate() {
			System.out.println("Increasing Rate ");  		
	}
}

//for inheritance
 class CDAccount extends BankAccount implements IRate{
	 
	 String interestRate;
	 
	  void compound() {
		  System.out.println("compounding Interest");
	  }
	 
 }
 
 //interface
  interface  IRate{
	  public void setRate();
	  public void increaseRate();
  }
  
  class LoanAccount implements IRate  {

	@Override
	public void setRate() {
			System.out.println("rate");
	}

	@Override
	public void increaseRate() {
				System.out.println("increase rate");		
	}
	  
  }
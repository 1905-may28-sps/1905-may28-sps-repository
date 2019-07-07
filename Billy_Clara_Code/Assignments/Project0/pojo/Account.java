package com.revature.pojo;

public class Account {
	
	
		
		private int AccountId;
		private double Balance;
		private int AccountOwner;
		
		public Account() {};
		
		


		public Account(int accountId, double balance, int accountOwner) {
			super();
			AccountId = accountId;
			Balance = balance;
			AccountOwner = accountOwner;
		}




		public int getAccountId() {
			return AccountId;
		}


		public void setAccountId(int accountId) {
			AccountId = accountId;
		}


		public double getBalance() {
			return Balance;
		}


		public void setBalance(double balance) {
			Balance = balance;
		}


		public int getAccountOwner() {
			return AccountOwner;
		}


		public void setAccountOwner(int accountOwner) {
			AccountOwner = accountOwner;
		}


		@Override
		public String toString() {
			return "Your ACCOUNT ID for Transactions is: " + AccountId + "\r Your Available balance is: " + Balance;
		}
		
		
		
		



		
	}



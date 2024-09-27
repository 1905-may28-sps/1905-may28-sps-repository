package com.revature.pojo;

public class BankUser {
		
		private int id;
		private String FirstName;
		private String LastName;
		private String Email;
		private String UserName;
		private String Password;
		
		public BankUser() {};
		
		public BankUser(int id, String firstName, String lastName, String email, String userName, String password) {
			super();
			this.id = id;
			this.FirstName = firstName;
			this.LastName = lastName;
			this.Email = email;
			this.UserName = userName;
			this.Password = password;
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getFirstName() {
			return FirstName;
		}


		public void setFirstName(String firstName) {
			FirstName = firstName;
		}


		public String getLastName() {
			return LastName;
		}


		public void setLastName(String lastName) {
			LastName = lastName;
		}


		public String getEmail() {
			return Email;
		}


		public void setEmail(String email) {
			Email = email;
		}


		public String getUserName() {
			return UserName;
		}


		public void setUserName(String userName) {
			UserName = userName;
		}


		public String getPassword() {
			return Password;
		}


		public void setPassword(String password) {
			Password = password;
		}

		@Override
		public String toString() {
			return  "Welcome" + " " + FirstName + " " + LastName + "\r" + "Please use the following \r"
					+ "BANKUSERID to deposit or withdraw: " +"[ " +id+  " ]";
			
		}


		


}


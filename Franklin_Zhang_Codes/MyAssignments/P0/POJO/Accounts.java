package POJO;

public class Accounts {
	private int Account_id;
	private int User_id;
	private Double Balance;
	private String Account_Type;
	private int Account_num;
	
	public Accounts() {}
//Work on this if time permits for only displaying account type, num, and balance
//	public Accounts(Double balance, String account_Type, int account_num) {
//		super();
//
//		Balance = balance;
//		Account_Type = account_Type;
//		Account_num = account_num;
//	}
	
	
	public Accounts(int account_id, int user_id, Double balance, String account_Type, int account_num) {
		super();
		Account_id = account_id;
		User_id = user_id;
		Balance = balance;
		Account_Type = account_Type;
		Account_num = account_num;
	}
	



	public int getAccount_id() {
		return Account_id;
	}

	public void setAccount_id(int account_id) {
		Account_id = account_id;
	}

	public int getAccount_num() {
		return Account_num;
	}

	public void setAccount_num(int account_num) {
		Account_num = account_num;
	}

	public int getUser_id() {
		return User_id;
	}

	public void setUser_id(int user_id) {
		User_id = user_id;
	}

	public Double getBalance() {
		return Balance;
	}

	public void setBalance(Double balance) {
		Balance = balance;
	}

	public String getAccount_Type() {
		return Account_Type;
	}

	public void setAccount_Type(String account_Type) {
		Account_Type = account_Type;
	}

//	@Override
//	public String toString() {
//		return "Accounts [Account_id=" + Account_id + ", Account_num=" + Account_num + ", User_id=" + User_id
//				+ ", Balance=" + Balance + ", Account_Type=" + Account_Type + "]";
//	}
	@Override
	public String toString() {
		return "BankAccounts [Account Number=" + Account_num + ", Balance=" + Balance + ", Acct Type=" + Account_Type + "]";
	}
	


	
}
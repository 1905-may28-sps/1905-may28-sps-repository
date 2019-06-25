package POJO;

public class Accounts {
	private int Account_id;
	private int User_id;
	private Double Balance;
	
	public int getAccount_id() {
		return Account_id;
	}
	public void setAccount_id(int account_id) {
		Account_id = account_id;
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
	public String getAccount_type() {
		return Account_type;
	}
	public void setAccount_type(String account_type) {
		Account_type = account_type;
	}
	private String Account_type;
	public Accounts() {}
	public Accounts(int account_id, int user_id, Double balance, String account_type) {
		super();
		Account_id = account_id;
		User_id = user_id;
		Balance = balance;
		Account_type = account_type;
	}
	@Override
	public String toString() {
		return "Accounts [Account_id=" + Account_id + ", User_id=" + User_id + ", Balance=" + Balance
				+ ", Account_type=" + Account_type + "]";
	}
	
}

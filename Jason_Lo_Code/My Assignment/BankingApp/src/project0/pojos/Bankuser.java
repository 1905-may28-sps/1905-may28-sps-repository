package project0.pojos;

public class Bankuser {

	private int used_id;
	private String name;
	private String username;
	private String password;

	public Bankuser() {
	}

	public Bankuser(int used_id, String name, String username, String password) {
		super();
		this.used_id = used_id;
		this.name = name;
		this.username = username;
		this.password = password;
	}

	public int getUsed_id() {
		return used_id;
	}

	public void setUsed_id(int used_id) {
		this.used_id = used_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Bankuser [used_id=" + used_id + ", name=" + name + ", username=" + username + ", password=" + password
				+ "]";
	}

}
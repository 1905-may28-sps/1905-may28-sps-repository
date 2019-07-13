package com.revature.pojos;

public class ReimbStatus {

	private int id;
	private String status;

	public ReimbStatus() {
	}

	public ReimbStatus(int id, String status) {
		super();
		this.id = id;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ReimbStatus [id=" + id + ", status=" + status + "]";
	}

}

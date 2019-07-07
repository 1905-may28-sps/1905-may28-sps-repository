package com.revature.app;

public class OverdraftException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OverdraftException() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("This withdrawl amount exceeds your balance");
	}


}

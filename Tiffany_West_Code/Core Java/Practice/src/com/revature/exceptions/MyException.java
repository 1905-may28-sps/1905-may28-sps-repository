package com.revature.exceptions;

/*
 * In order to create custom exceptions, all you 
 * must do is extend Exception 
 * 
 * In order to give it a meaningful message for when 
 * it appears in a stack trace, we can give it 
 * a constructor calling the super(message) constructor
 */
public class MyException extends Exception {

	public MyException() {
		super("This is my custom exception message!");
	}
	

	
	@Override
	public synchronized Throwable initCause(Throwable cause) {
		// TODO Auto-generated method stub
		return super.initCause(cause);
	}
}

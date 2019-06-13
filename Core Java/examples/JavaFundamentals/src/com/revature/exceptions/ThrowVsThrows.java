package com.revature.exceptions;

public class ThrowVsThrows {
	/*
	 * One out of two ways to handle an exception is to 
	 * throw is up the call stack 
	 * 
	 * this is done in the method signature with the THROWS 
	 * keyword 
	 * 
	 * this process is called "ducking" or "propagating" an
	 * exception 
	 * 
	 * the THROW keyword allows us to create and literally 
	 * throw the exception up the call stack at the line we use it 
	 * if the exception is never caught (the method "throws" it, 
	 * and every method that calls that method "throws" it) then 
	 * it will halt the execution of our code
	 */
	
	public static void main(String[] args) throws MyException {
		withdraw(-6);
	}
	
	public static void useThrowWithCatch(int money) {
		if(money < 0) {
			try {
				System.out.println("here's things we want to do w money");
				throw new MyException();
			} catch (MyException e) {
				/*
				 * Here is where i would provide functionality 
				 * that i want to happen if something went wrong 
				 * for me to want to throw my custom exception
				 * aka if im broke 
				 * i want to let my user know they have no money here
				 */
				e.printStackTrace();
			}
		}
	}
	
	public static void useThrowWithThrows(int money) throws MyException {
		if(money < 0) {
			//broke again 
			throw new MyException();
		}
		System.out.println("do things with peoples money");
	}
	
	public static int withdraw(int money) throws MyException{
		useThrowWithThrows(money);		
		System.out.println("withdawing money");
		return money;
		
	}

}

package com.revature.exceptions;

public class UnderstandingExceptions {
	/*
	 * Exceptions in Java are objects that are thrown 
	 * up the stack at runtime halting the execution of 
	 * your application when something goes wrong 
	 * They are typically recoverable if handled properly
	 * 
	 * An exception can be "handled" by either catching 
	 * it at the moment it's thrown or by having the 
	 * method that it is thrown in further throw it up 
	 * the stack or "propagate" it. (also known as ducking)
	 * 
	 * 
	 * Topics to cover:
	 * - throwable API
	 * - Errors vs Exceptions
	 * RuntimeExceptions (unchecked) vs compile-time (checked)
	 * - how to handle exceptions - cath vs throw
	 * - throws vs throw
	 * 
	 */
	public static void main(String[] args) {
		method2(args);
		System.out.println("made it to the end of main");
	}

	static void method2(String[] args) {
		try {
			System.out.println("WE ARE TRYING RISKY CODE HERE ");
			System.out.println(args[10]);
			
			Integer.parseInt("test");
			/*
			 *  the throw keyword allows us to instantiate exceptions and throw them up the call stack at the line it is written
			 *  
			 *  if we want to catch non-Runtime
			 */
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("caught aioobe");
		}
		catch(NumberFormatException e) {
			System.out.println("CAUGHT NFE");
		}
		catch(Exception e) {
			System.out.println("WE CAUGHT AN EXCEPTION!!!!");
			//	e.printStackTrace();
		}

		System.out.println("made to end of method2");
	}
}

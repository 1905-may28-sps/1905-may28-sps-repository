package com.revature.exceptions;

import java.io.FileNotFoundException;

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
	 * Topics to cover:
	 * - Throwable API
	 * - Errors vs Exceptions 
	 * - RuntimeExceptions(unchecked) vs compile-time(checked)
	 * - how to handle exceptions - catch vs throw 
	 * - throw vs throws 
	 * - try-catch, try-catch-finally 
	 * - create our own exceptions
	 * - common exceptions to know 
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
			 * the throw keyword allows us to instantiate 
			 * exceptions and throw them up the call stack 
			 * at the line it is written 
			 * 
			 * If we want to catch non-RuntimeExceptions 
			 * that are not thrown from another method, we 
			 * must throw it ourselves as we see here
			 */
			throw new FileNotFoundException();
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("caught aioobe");
		}
		catch(NumberFormatException e) {
			System.out.println("CAUGHT NFE");
		}
		catch(NullPointerException e) {
			
		}
		catch(NegativeArraySizeException e) {
			
		}
		catch(FileNotFoundException e) {}
			
		catch(Exception e) {
		
			System.out.println("WE CAUGHT AN EXCEPTION!!!!");
			//	e.printStackTrace();
		}

		System.out.println("made to end of method2");
	}

	static void compileExceptionThrows() throws FileNotFoundException {
		/*
		 * For any method that could potentially cause
		 * an excpetion, we can make it "THROWS" an exception 
		 * which basically makes the method that calls it 
		 * have to "handle"
		 */
		System.out.println("Here, we never actually encounter "
				+ "something that throws an exception, but "
				+ "lets pretend that this method does something "
				+ "risky with files. We can say that our method"
				+ "throws FNFE to ensure that any method calling "
				+ "it is PREPARED for a FNFE");
		
		
	}

}

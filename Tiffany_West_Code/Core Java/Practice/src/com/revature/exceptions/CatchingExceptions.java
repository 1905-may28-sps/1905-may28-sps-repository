package com.revature.exceptions;

public class CatchingExceptions {
	/*
	 * One out of two ways to handle an exception is to 
	 * CATCH it 
	 * we do this by surrounding our "risky" code with a 
	 * try{} block, and catching our expected exception 
	 * 
	 * we will see try-catch, try-catch-finally,
	 * try-finally and since Java 1.6, 
	 * try-with-resources
	 */
	
	public static void main(String[] args) {
		theFinallyBlock();
	}

	public static void catchRuntimeException(int index) {
		try {
			int[] arr = {1, 2, 3};
			//the following line of code will throw exception
			System.out.println(arr[index]);
			System.out.println("reached the end of try block");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("here is where we'd have fallback"
					+ "code for if something wrong happens, which "
					+ "we know will  ");
			e.printStackTrace();
			System.out.println(e.getCause());
		}
	}
	
	public static void theFinallyBlock() {
		/*
		 * When we catch exceptions, we can use try blocks
		 * with as many catch blocks as we want but only one 
		 * will actually catch the exception that exits the 
		 * code from the try block. However if there is some 
		 * code that we NEED to execute regardless of the 
		 * outcome of the try block, we put that code in the 
		 * finally block, which ALWAYS executes unless the 
		 * computer crashes or you exit your application 
		 * programmatically with System.exit() (do not do lol)
		 */
		try {
			Integer.parseInt("test");
		}
		catch(ArrayIndexOutOfBoundsException e) {
			//e.printStackTrace();
			System.out.println("caught exception ");
		}
		finally {
			System.out.println("in finally block");
		}
		
	}
}

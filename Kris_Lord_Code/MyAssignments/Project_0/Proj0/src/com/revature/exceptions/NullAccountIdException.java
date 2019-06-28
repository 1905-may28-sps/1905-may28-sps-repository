package com.revature.exceptions;

public class NullAccountIdException extends Exception {
	
	public NullAccountIdException(String errorMessage) 
    { 
        // Call constructor of parent Exception 
        super(errorMessage); 
    } 
	
}
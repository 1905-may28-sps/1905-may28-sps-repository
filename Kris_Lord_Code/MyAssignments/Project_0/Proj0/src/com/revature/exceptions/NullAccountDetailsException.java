package com.revature.exceptions;

@SuppressWarnings("serial")
public class NullAccountDetailsException extends Exception {
	
	public NullAccountDetailsException(String errorMessage) 
    { 

        super(errorMessage); 
    } 
	
}

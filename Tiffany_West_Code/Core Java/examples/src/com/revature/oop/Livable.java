package com.revature.oop;

public interface Livable {
/*
 * an interface is Java is an abstract type that is used soecify behavior that classes
 * must implement.
 * 
 * Interfaces are commonly referred to as "contracts"
 * and if some class implements as interface, it is signing the contract and agreeing to
 *  provide functionality specified in the contract.
 *  
 *  In interfaces, every method IMPLICITLY has the modifiers 
 *  abstract and public
 *  
 *  Since Java 8, we now have the ablility to give methods
 *  default implementatio. we can also make static methods in interfaces, but they do not get overridden
 */
	
	int reproduce();
	String communicate();
	/*
	 * DEFAULT METHOD IMPLEMENTATION 
	 * any concrete class (not abstract) that implements this interface 
	 * MUST implement reproduce() and communicate() BUT they do not 
	 * have to implement stayAlive() if we dont want them to. 
	 * We can override it 
	 */
	default void stayAlive() {
		System.out.println("Staying alive");
	}
}

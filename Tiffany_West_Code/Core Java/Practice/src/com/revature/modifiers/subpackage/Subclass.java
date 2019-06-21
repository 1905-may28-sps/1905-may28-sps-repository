package com.revature.modifiers.subpackage;

import com.revature.modifiers.AccessModifiers;

/*
	 * Inheritance! one of our four oop pillars!
	 * The ability for a class to gain functionality 
	 * from another class or interface
	 * 
	 * class extends class
	 * class implents interface 
	 * interface extends interface 
	 */
	public class Subclass extends AccessModifiers{
		
		public static void main(String[] args) {
			AccessModifiers mod = new AccessModifiers();
			mod.publicVar = 5;
		
			
			AccessModifiers.staticVar = 10;
		
			Subclass sub = new Subclass();
			sub.publicVar = 10;
			sub.protectedVar = 10;

		
		}
}

package com.revature.modifiers;

public class SamePackage extends AccessModifiers{
	
	public static void main(String[] args) {
		AccessModifiers mod = new AccessModifiers();
		mod.protectedVar = 10;
		mod.packageVar = 10;
		
		AccessModifiers.staticVar = 10;
		
		SamePackage same = new SamePackage();
		same.publicVar = 8;
		same.protectedVar = 1;
		same.packageVar = 2;
		
	}

}

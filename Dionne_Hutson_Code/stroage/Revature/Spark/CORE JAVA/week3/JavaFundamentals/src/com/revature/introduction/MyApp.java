package com.revature.introduction;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * default constructors look like
		 * public ClassName(){
		 * super();
		 * }
		 * 
		 * super calls the constructor of the class's super class
		 * 
		 * for example Object is a super class
		 */
		ClassBasics myInstance=new ClassBasics();
		myInstance.instanceVar="This instance is myInstance";
		myInstance.staticVar="This is a static variable from my Instance";
		
		ClassBasics secondInstance=new ClassBasics();
		secondInstance.instanceVar="this is second instance";
		secondInstance.staticVar="this is staic var from second my instance";// this also changes static var for the class and the first instance
		ClassBasics.staticVar="we can acess static feilds from the class in stead of from theinstance";
		//ClassBasics.instanceVar will not work since you cannot acess instance feild directly form a class you need an instance
		
		

	}

}

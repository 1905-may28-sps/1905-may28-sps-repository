package com.revature.designpatterns;

public class DesignPatterns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singleton single=Singleton.getInstance();
		single.name="MY FIRST INSTANCE";
		Singleton single2=Singleton.getInstance();// this is still refrenceing the same instance as the first
		single2.name="MY sec INSTANCE";

		System.out.println(single.name);
		System.out.println(single2.name);
	}

}
package com.revature.threads;

public class ExtendsThread extends Thread{
	/*
	 * This class will serve as the starting point as 
	 * a separate thread of execution 
	 * 
	 * in order for us to make this happen, we will extend 
	 * the thread class and override the run() method that 
	 * we inherit from the Runnable interface (which Thread 
	 * implements)
	 * 
	 * 
	 */
	
	
	@Override
	public void run() {
		for(int i = 0; i < 25; i++) {
			System.out.println(i + ": EXTENDS THREAD");
		}
	}	
	public static void main(String[] args) {
		System.out.println("MAIN IN SEPARATE THREAD. NOT CALLED FROM START");
	}

}

package com.revature.thread;

public class ImplementsRunnable implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<25;i++) {
			System.out.println(i+": Implements runnable");
		}

	}

}

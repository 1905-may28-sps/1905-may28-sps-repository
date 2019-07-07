package com.revature.thread;

public class UnderstandingThreads {

	public static void main(String[] args) {
		System.out.println("Main method , starting point of an ap in java. the main method in a "
				+ "multithread application is considered to be the strating point f a main thread. "
				+ "we can spin up(branch off) into seperate threads. the staring point of the new thread is the run method");
		extendThreadClassThread();
		
	}
	static void extendThreadClassThread() {
		ImplementsRunnable ir=new ImplementsRunnable();
		Thread runnableThread= new Thread(ir);
		
		ExtendsThread et=new ExtendsThread();// new thread since this extends thread
		et.start();//start calls the run method ad executes it on its own path of execution(thread). if we use run instead of start, run is treated like a method
		runnableThread.start();
		for(int i=0;i<25;i++) {
			System.out.println(i+": MainThread");
		}
		
	}

}

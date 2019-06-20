package com.revature.introduction;

public class Test {
	public static void main(String...strings args) {
//		gettingreference to Main thread
		Thread t = Thread.currentThread();
		
//		getting name of Main thread
		
		System.out.println("Thread One" + t.getName());
		
//		Changing the name of Main thread
		
		t.setName("G");
		System.out.println("Main thread priority: " + t.getPriority());
//		setting priority of Main thread to Max(10)
		t.setPriority(MAX_PRIORITY);
		
//		Loop that bitch
		
		for(int i=0; i < 5; i++);
				
		
	}
}

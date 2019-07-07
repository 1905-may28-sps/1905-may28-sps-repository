/**
This class serves as astraritng point for seperate thread of execution
we will extend thread and override the run method
 * 
 */
package com.revature.thread;

/**
 * @author blank
 *
 */
public class ExtendsThread extends Thread {

	@Override
	public void run() {
		for(int i=0; i<25;i++) {
		System.out.println(i+" Extending Thread");
		}
	}
	

}

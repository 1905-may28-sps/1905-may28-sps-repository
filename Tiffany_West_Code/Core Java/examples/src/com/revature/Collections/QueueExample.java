package com.revature.Collections;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;




public class QueueExample {

	public static void main(String[] args) {
			 LinkedList<String> leavingQueue = new LinkedList<String>();
			
			// Add new element at the end of the list
			 leavingQueue.add("Tiffany");
			 leavingQueue.add("Dionne");
			 leavingQueue.add("Jason");
			 System.out.println("In Leaving Queue : " +  leavingQueue);
			 
			 //Add last method
			 leavingQueue.addLast("Nico");
			 System.out.println("Added last to leavingQueue is : " + leavingQueue);
			 
			 //AddLast method
			 leavingQueue.addFirst("Kimi");
			 System.out.println("Added first to the leavingQueue is :" + leavingQueue);

			 
			 
			
			 
	}

}

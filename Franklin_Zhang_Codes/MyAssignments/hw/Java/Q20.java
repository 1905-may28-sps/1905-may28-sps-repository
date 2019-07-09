package com.revature.hw;

// create a txt file, read text file
import java.io.*;
import java.util.*;



public class Q20 {
	//name of the file to open
	
	public static void main(String[] args) {
		File file =new File("src/com/revature/hw/Data.txt");
		 
		try {
		
		Scanner sc = new Scanner(file);
		
		String txt=sc.nextLine();
		String[] ln1=txt.split(":");
		//prints name
		System.out.println("Name: "+ln1[0]+" "+ln1[1]);
		//prings age
		System.out.println("Age: "+ln1[2]);
		//prints state
		System.out.println("State: "+ln1[3]+" state");
		//sc.useDelimiter(":|\n");
		//name
		//System.out.print("Name: "+sc.next()+sc.next());	
		//age
		//System.out.println("Age: "+sc.next());
		//state
		//System.out.print("State: "+ sc.next()+ "state");
		//System.out.print(sc.nextLine());
		
		 
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("what?");
		}
	
	}
}
	
package com.billy.readfromfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadFromFile {

	public static void main(String[] args) throws Exception {
		
		File myFile = new File("D:\\JavaHomework\\data.txt");
		BufferedReader br = new BufferedReader(new FileReader(myFile));
		
		String myString;
		myString = br.readline();
		for(int i = 0; i<= myString.length;i++)
		  while ((myString = br.readLine()) != null) 
		    System.out.println(myString);
		
		
	}
	
}

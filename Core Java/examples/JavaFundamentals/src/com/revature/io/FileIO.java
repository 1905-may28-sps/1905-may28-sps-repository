package com.revature.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileIO {
	/*
	 * File IO in Java is the mechanism we use to read from and 
	 * write to files. 
	 * 
	 * Classes associated with writing to files are: 
	 * BufferedWriter 
	 * FileWriter 
	 * 
	 * Classes associated with reading from files are:
	 * BufferedReader 
	 * FileReader
	 * 
	 * Associated topic of discussion:
	 * try-with-resources 
	 * - this is a parameterized try block where we the parameter 
	 * is the instantiation of a "resource"(object we need) that 
	 * implements the autocloseable interface
	 * - we now no longer need to explicitly close this resource 
	 */
	static String filePath = "src/com/revature/io/text.txt";
	
	public static void main(String[] args) {
		//writeString("Welcome to File IO again");
		
		List<String> strings = readStrings();
		int count  = 0;
		for(String str : strings) {
			System.out.println(++count + " " + str);
		}
	}
	
	static void writeString(String text) {
		try(BufferedWriter bw = 
				new BufferedWriter(new FileWriter(filePath, true))){
			
			bw.write(text + "\n");
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	static List<String> readStrings(){
		List<String> strings = new ArrayList<String>();
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			String currString = null;
			
			while((currString = br.readLine())!=null) {
				strings.add(currString);
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return strings;
	}

}

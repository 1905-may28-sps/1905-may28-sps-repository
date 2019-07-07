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
	 * Associated classes with writing/reading to fiiles
	 * BufferedWriter/Reader FileWriter/Reader
	 * means by which we can create a connection with a noter resource
	 * ASSOCIATE WITH:try-with resources
	 * this is a parameterized try block where the parameter is the instantiation of a resource, object that iplements the autoclosabke interface, we no onger need to explicityl close this resource
	 */
	public static void main(String[] args) {
		writeString("Welcome to FileI0! again");
	}
	
	static String filePath="src/com/revature/io/text.txt";//relative file path
	
	static void writeString(String text) {
		//file we=riter is instatiated in the buffered writer constructor// file writer throw an except
		//try with resources auto closes//autoclosable is an interface; if we use try with resources we dont need a close or catch
		
		try(BufferedWriter bw=new BufferedWriter(new FileWriter(filePath, true))) {// try with resources; otherwise we close in finally with many try catch blocks
		bw.write(text+"\n");// if we dont append our file will be written	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


static List<String> readStrings(){
	List<String> strings=new ArrayList<String>();// refrence to interface because we are returning that type
	
	
	try(BufferedReader br=new BufferedReader(new FileReader(filePath))){
		String currString=null;
		while((currString=br.readLine())!=null) {
			strings.add(currString);
		}
		
	}catch(FileNotFoundException e) {
		e.printStackTrace();
		
	}catch(IOException e) {
		e.printStackTrace();
		
	}
	return strings;
}
}
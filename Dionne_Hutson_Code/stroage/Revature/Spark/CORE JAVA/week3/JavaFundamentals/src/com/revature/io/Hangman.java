package com.revature.io;

import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Hangman {
	///read from random file
	//give us the chance to guess letters
	/*
	 * get a word// read word into array or list and get a random word, math.random
	 * display spaces for each letter
	 * guess/keep going
	 * 
	 * change spaces to show letters
	 */
	static int length;
	
	static String opt;
	static Scanner scan;
	static String word;
	static String space="";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getWord());
		getSpace();
		guess();

	}
	static String filePath="src/com/revature/io/Hangman.txt";//relative file path
	
	static String getWord() {
		List<String> words=new ArrayList<String>();
		try(BufferedReader br=new BufferedReader(new FileReader(filePath))){
			String currString=null;
			while((currString=br.readLine())!=null) {
				words.add(currString);
			}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}
		int index=(int)(Math.random()*words.size()-1); //index is oe less than size
		length=words.get(index).length();
		word=words.get(index);
		
		return words.get(index);
		
	}
	
	
	
	
	static void getSpace() {
		
		for (int i=0;i<length;i++) {
			System.out.print("_ ");
		}
		
	}
	
	
	static void letSpace(int space2, char guess) {
		
		
		
	}
	
	static void guess() {
		
	scan=new Scanner(System.in);
	char guess=scan.nextLine().charAt(0);
	System.out.println("Pre for");
		for(int i=0;i<length;i++) {
			System.out.println("in for");
			System.out.println(guess);
			System.out.println(word.charAt(i));
			if (guess==(word.charAt(i))) {
				System.out.println("Correct!");
				letSpace(i,guess);
			} else {
				System.out.println("Wrong!");
				
			
			}
		}


	

		
	}
	

}

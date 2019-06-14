package com.revature.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Hangman {
	
	static String filepath = "src/com/revature/io/words.txt";

	public static void main(String[] args) {
		System.out.println("Welcome to Hangman! You have 5 incorrect guesses before you looooooooooooose");
		guess(getWord(), 5);
	}

	static void guess(String word, int numGuesses) {

	}

	static void print(char[] letters) {
		String out = "";
		for(char c : letters) {
			out += c + " "; 
		}
		System.out.println(out);
	}

	static String getWord() {
		List<String> words = new ArrayList<String>();
		try(BufferedReader br = new BufferedReader(
				new FileReader(filepath))){
			String currLine = null;
			while((currLine=br.readLine())!=null) {
				words.add(currLine);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int index = (int) (Math.random() * words.size()-1);

		return words.get(index);
	}



	

}

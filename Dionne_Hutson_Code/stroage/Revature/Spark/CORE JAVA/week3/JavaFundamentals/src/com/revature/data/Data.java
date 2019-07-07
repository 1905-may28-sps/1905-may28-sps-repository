package com.revature.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Data {
	static List<String> noCol=new ArrayList<>();

	public static void main(String[] args) {
		  try(BufferedReader br=new BufferedReader(new FileReader("Data.txt"))){
		  } catch (FileNotFoundException e) { // TODO Auto-generated catch block
		  e.printStackTrace(); } 
		  catch (IOException e1) { // TODO Auto-generated catch
		e1.printStackTrace(); }
		 
	}

	public static  List<String> removeCol(){
		 try(BufferedReader br=new BufferedReader(new FileReader("Data.txt"))){
			 try(BufferedWriter)
			 
			 
			 
		  } catch (FileNotFoundException e) { // TODO Auto-generated catch block
		  e.printStackTrace(); } 
		  catch (IOException e1) { // TODO Auto-generated catch
		e1.printStackTrace(); }
		
	}
}

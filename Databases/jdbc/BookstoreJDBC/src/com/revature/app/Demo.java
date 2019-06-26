package com.revature.app;

import java.util.List;
import java.util.Scanner;

import com.revature.dao.AuthorDAO;
import com.revature.dao.GenreDAO;
import com.revature.pojos.Author;

public class Demo {
	
	static Scanner scan = new Scanner(System.in);
	static AuthorDAO authDao = new AuthorDAO();
	static GenreDAO gDao = new GenreDAO();
	
	
	public static void main(String[] args) {
menu();
	}
	
	
	public static void menu() {
		System.out.println("Welcome to Revature Books! What would you like to do?\n"
				+ "1. View authors\n"
				+ "2. Update Authors\n"
				+ "3. Add new author");
		try {
			int option = Integer.parseInt(scan.nextLine());
			
			switch(option) {
			case 1: viewAuthors(); break;
			case 2: updateAuthors(); break;
			case 3: addAuthor(); break;
			default:
			}
			
			
		}catch(NumberFormatException e) {
			System.out.println("please enter a number!");
			menu();
		}
		
	}
	
	public static List<Author> viewAuthors() {
		List<Author> authors = authDao.findAll();
		for(Author a : authors) {
			System.out.println(a);
		}
		return authors;
	}
	
	public static void updateAuthors() {
		List<Author> authors = viewAuthors();
		System.out.println("Please enter the ID of the author you'd like to update");
		
		try {
			int id = Integer.parseInt(scan.nextLine());
			
			Author auth = authors.stream().filter( a -> a.getId() == id)
					.findAny().orElse(null);
			if(auth != null) {
				System.out.println("What would you like to change the first name to, "
						+ "if nothing. please enter n");
				String fn = scan.nextLine();
				System.out.println("What would you like to change the last name to, "
						+ "if nothing. please enter n");
				String ln = scan.nextLine();
				System.out.println("What would you like to change the bio to, "
						+ "if nothing. please enter n");
				String bio = scan.nextLine();
				
				if(!fn.equalsIgnoreCase("n")) auth.setFirstName(fn);
				if(!ln.equalsIgnoreCase("n")) auth.setLastName(ln);
				if(!bio.equalsIgnoreCase("n")) auth.setBio(bio);
				
				System.out.println(auth);
					
			}
			else {
				System.out.println("Author with id "+ id + " does not exist. please enter"
						+ " a valid author.");
				updateAuthors();
			}
			
			
		}catch(NumberFormatException e) {
			//make sure user entered number 
		}
	}
	
	public static void addAuthor() {
		System.out.println("Hey! What's the first name of the author you'd like to add?");
		String fn = scan.nextLine();
		System.out.println("And last name?");
		String ln = scan.nextLine();
		System.out.println("Award-winning bio:");
		String bio = scan.nextLine();
		Author newAuthor = new Author();
		newAuthor.setFirstName(fn);
		if(ln != null && !ln.equals("")) newAuthor.setLastName(ln);
		newAuthor.setBio(bio);
		
		newAuthor = authDao.save(newAuthor);
		System.out.println(newAuthor);
		
	}

}

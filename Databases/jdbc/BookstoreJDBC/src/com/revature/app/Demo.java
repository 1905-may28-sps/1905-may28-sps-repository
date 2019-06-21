package com.revature.app;

import java.util.Scanner;

import com.revature.dao.AuthorDAO;
import com.revature.pojos.Author;

public class Demo {
	
	static Scanner scan = new Scanner(System.in);
	static AuthorDAO authDao = new AuthorDAO();
	public static void main(String[] args) {
		addAuthor();

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

package com.revature.app;

import java.util.List;
import java.util.Scanner;

import com.revature.doa.AuthorDAO;
import com.revature.doa.GenreDAO;
import com.revature.pojos.Author;
import com.revature.pojos.Genre;

public class Demo {
	
	static Scanner scan = new Scanner(System.in);
	static AuthorDAO authDao = new AuthorDAO();
	static GenreDAO gDao = new GenreDAO();
	
	
	public static void main(String[] args) {
		Genre g = gDao.findById(3);
		//Genre g = gDao.findById(24);
		System.out.println(g);
		//System.out.println(gDao.update(g, "nameChange"));
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

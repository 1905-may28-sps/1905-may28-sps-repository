package com.revature.app;

import java.util.List;
import java.util.Scanner;

import com.revature.dao.AuthorDAO;
import com.revature.dao.GenreDAO;
import com.revature.pojo.Author;
import com.revature.pojo.Genre;

public class Demo {
	static Scanner scan= new Scanner(System.in);
	static AuthorDAO aDAO= new AuthorDAO();
	static GenreDAO gDAO=new GenreDAO();
	static Genre g=new Genre(1,"test");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(gDAO.getAllCallable());
//		System.out.println(gDAO.findById(1));
//		System.out.println(gDAO.update(g, "Jazz"));
//		GenreDAO gdao= new GenreDAO();
//		List<Genre> genres=gdao.findAll();
//		System.out.println(genres);
//		AuthorDAO adao=new AuthorDAO();
//		List<Author> authors=adao.findAll();
//		System.out.println(authors);
//		addAuthor();
//		List<Author> authors2=adao.findAll();
//		System.out.println(authors2);

	}
	public static void addAuthor() {
		System.out.println("What is the first name?");
		String fn=scan.nextLine();
		System.out.println("What is the last name?");
		String ln=scan.nextLine();
		System.out.println("Award-winning bio:");
		String bio = scan.nextLine();
		Author newAuthor = new Author();
		newAuthor.setFirstName(fn);
		if(ln != null && !ln.equals("")) newAuthor.setLastName(ln);
		newAuthor.setBio(bio);
		newAuthor = aDAO.save(newAuthor);
		System.out.println(newAuthor);
	}
}

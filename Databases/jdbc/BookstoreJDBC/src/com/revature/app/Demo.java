package com.revature.app;

import com.revature.dao.AuthorDAO;

public class Demo {

	public static void main(String[] args) {
//		GenreDAO dao = new GenreDAO();
//		List<Genre> genres = dao.findAll();
//		System.out.println(genres);
		
		AuthorDAO dao = new AuthorDAO();
		System.out.println(dao.findAll());

	}

}

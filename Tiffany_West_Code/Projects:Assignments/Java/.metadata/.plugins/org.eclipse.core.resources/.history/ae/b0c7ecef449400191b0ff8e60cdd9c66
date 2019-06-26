package com.revature.app;

import java.util.List;

import com.revature.doa.AuthorDOA;
import com.revature.doa.GenreDOA;
import com.revature.pojos.Author;
import com.revature.pojos.Genre;

public class Demo {

	public static void main(String[] args) {
		//Genres
		GenreDOA dao = new GenreDOA();
		List<Genre> genres = dao.findAll();
		System.out.println(genres);
		
		//authors
		AuthorDOA adao = new AuthorDOA();
		List<Author> authors = adao.findAll();
		System.out.println(authors);

	}


}

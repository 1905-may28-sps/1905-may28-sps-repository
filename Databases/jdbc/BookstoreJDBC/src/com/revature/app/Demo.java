package com.revature.app;

import java.util.List;

import com.revature.dao.GenreDAO;
import com.revature.pojos.Genre;

public class Demo {

	public static void main(String[] args) {
		GenreDAO dao = new GenreDAO();
		List<Genre> genres = dao.findAll();
		System.out.println(genres);

	}

}

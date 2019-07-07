package com.revature.dao;

import java.util.List;

import com.revature.pojo.Author;
import com.revature.pojo.Book;
import com.revature.pojo.Genre;

public class BookDAO {

	public Book save (Book b) {
		
		insert into store_book(isbn,title,price,genre);
	}
	public void addAuthors(Book b,List<Author> authors) {
	
		return null;
	}
	public void getBooksByGenre(Genre g) {
		return null;
	}

}

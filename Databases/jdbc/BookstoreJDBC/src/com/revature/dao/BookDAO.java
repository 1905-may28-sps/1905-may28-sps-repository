package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.pojos.Author;
import com.revature.pojos.Book;
import com.revature.pojos.Genre;
import com.revature.util.ConnectionFactory;

public class BookDAO {
	
	public Book save(Book b) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String keys[] = { "book_id" };
			PreparedStatement ps = conn.prepareStatement
					("insert into store_book (isbn, title, price, genre)" + 
					" values (?, ?, ?, ?)", keys);
			ps.setString(1,  b.getIsbn());
			ps.setString(2, b.getTitle());
			ps.setDouble(3, b.getPrice());
			ps.setInt(4, b.getGenre());
			ps.executeUpdate();
			
			ResultSet primaryKey = ps.getGeneratedKeys();
			
			primaryKey.next();
			b.setId(primaryKey.getInt(1));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return b;
	}
	
	public void addBookAuthors(Book b, List<Author> authors) {
		
	}
	
	public List<Book> getBooksByAuthor(Author a){
		return null;
	}
	
	public List<Book> getBooksByGenre(Genre g){
		return null;
	}

}

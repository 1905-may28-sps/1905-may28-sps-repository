package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Author;
import com.revature.pojos.Book;
import com.revature.pojos.BookInfo;
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
	
	public void addBookAuthors(int bookId, int authId) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			PreparedStatement ps = conn.prepareStatement("insert into store_book_author"
					+ "(book_id, author_id) values (?, ?)");
			ps.setInt(1,  bookId);
			ps.setInt(2, authId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Book> getBooksByAuthor(Author a){
		return null;
	}
	
	public List<Book> getBooksByGenre(Genre g){
		return null;
	}
	
	public List<BookInfo> getBookInfo(){
		List<BookInfo> info = new ArrayList<BookInfo>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select book.title, auth.first_name, auth.last_name, gen.name " + 
					"from store_book book " + 
					"join store_book_author ba on book.book_id = ba.book_id " + 
					"join store_author auth on auth.AUTHOR_ID = ba.AUTHOR_ID " + 
					"join store_genre gen on gen.genre_id = book.GENRE";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				BookInfo temp = new BookInfo();
				temp.title = rs.getString(1);
				temp.fn = rs.getString(2);
				temp.ln = rs.getString(3);
				temp.genre = rs.getString(4);
				info.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return info;
	}

}

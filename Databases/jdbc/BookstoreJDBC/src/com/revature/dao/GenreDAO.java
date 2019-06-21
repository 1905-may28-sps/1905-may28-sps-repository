package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Genre;
import com.revature.util.ConnectionFactory;

public class GenreDAO {
	
	/*
	 * STATEMENT - important interface in JDBC API
	 * - takes an SQL statement as a string, executes it, and 
	 * returns the result 
	 * - allow SQL injection. These are not ideal to use. Definitely 
	 * do NOT use for any SQL command that uses a parameter/variable
	 * 
	 * SQL injection - common hacking technique. it is the insertion of
	 * code as input that affects your database 
	 */

	public List<Genre> findAll(){
		List<Genre> genres = new ArrayList<Genre>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			//do NOT include semi-colon in your sql command!
			String query = "select * from store_genre";
			
			//STATEMENT interface 
			Statement statement = conn.createStatement();
			
			/*
			 * RESULT SET interface
			 * holds the RESULTS of a QUERY
			 * special data structure used with jdbc that we must 
			 * iterate over with the .next() method that returns 
			 * to us a row of cells that we can access by col index 
			 * (starts with 1) or by column name 
			 */
			ResultSet rs = statement.executeQuery(query);
			
			//rs.next moves pointer to next row, returns false when no more rows
			while(rs.next()) {
				Genre temp = new Genre(rs.getInt(1), rs.getString(2));
				genres.add(temp);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return genres;
	}
	
	public Genre findById(int id) {
		Genre g = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query  = "select * from store_genre where genre_id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet result = ps.executeQuery();
			while(result.next()) {
				g = new Genre();
				g.setId(result.getInt(1));
				g.setName(result.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return g;
	}

}






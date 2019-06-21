package com.revature.doa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Genre;
import com.revature.util.ConnectionFactory;

public class GenreDOA {

	
	
	public List<Genre> findAll(){
		
		
		List <Genre> genres = new ArrayList<Genre>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String query = "select * from store_genre";
			
			//statement interface
			//Statement statement = conn.createStatement();
			Statement statement = conn.createStatement();

			
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				Genre temp = new Genre(rs.getInt(1), rs.getString(2));
				genres.add(temp);
			}

			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return genres;
	}
}

package com.revature.doa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Author;
import com.revature.pojos.Genre;
import com.revature.util.ConnectionFactory;

public class AuthorDOA {

	
	
public List<Author> findAll(){
		
		
		List <Author> authors = new ArrayList<Author>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String query = "select * from STORE_AUTHOR";
			
			//statement interface
			//Statement statement = conn.createStatement();
			Statement statement = conn.createStatement();

			
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				Author temp = new Author(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getNString(4));
				authors.add(temp);
			}

			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return authors;
	}}

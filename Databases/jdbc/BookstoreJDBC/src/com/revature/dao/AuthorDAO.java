package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Author;
import com.revature.util.ConnectionFactory;

public class AuthorDAO {

	
	public List<Author> findAll(){
		List<Author> authors = new ArrayList<Author>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from store_author");
			while(rs.next()) {
				Author a = new Author();
				a.setId(rs.getInt(1));
				a.setFirstName(rs.getString("FIRST_NAME"));
				a.setLastName(rs.getString(3));
				a.setBio(rs.getString(4));
				authors.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return authors;
	}
}

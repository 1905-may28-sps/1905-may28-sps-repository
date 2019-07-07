package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Author;
import com.revature.util.ConnectionFactory;

public class AuthorDAO {
	
	public List<Author> findAll(){
		List<Author> authors=new ArrayList<Author> ();
	
	try(Connection conn=ConnectionFactory.getInstance().getConnection()){
		String query="select*from store_author";
		Statement statement=conn.createStatement();
		ResultSet rs=statement.executeQuery(query);
		while(rs.next()) {
			Author temp=new Author(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
			authors.add(temp);
		}
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return authors;
	}
	//Create method with prepare stmt
	public Author save(Author auth) {//return author to get id
	try(Connection conn=ConnectionFactory.getInstance().getConnection()){
		
		
		//conn.setAutoCommit(false);
		
		String sql="insert into store_author(first_name, last_name, BIO)values(?,?,?)";
		String[] generatedKeys= {"Author_ID"};
		PreparedStatement ps=conn.prepareStatement(sql, generatedKeys);
		ps.setString(1,auth.getFirstName());
		ps.setString(2,auth.getLastName());
		ps.setString(3,auth.getBio());
		
		ps.executeUpdate();
		
		ResultSet pk= ps.getGeneratedKeys();
		
		pk.next();//move to first row
		auth.setId(pk.getInt(1));
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return auth;
	}
	
}

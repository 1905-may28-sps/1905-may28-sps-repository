package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	
	
	//CREATE 
	/*
	 * Prepared Statement
	 */
	
	public Author save(Author auth) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			/*
			 * Connection has a property of autoCommit set to true
			 * which automatically commits your changes before it closes
			 * if we want to do some sort of error checking before we commit, 
			 * we must setAutoCommit to false
			 * 
			 * ie conn.setAutoCommit(false);
			 */
	
			/*
			 * Prepared statements allow us to replace variables with ? to 
			 * be able to have variable arguments and prevent SQL injection
			 * 
			 * Also, when inserting data into our DB, we want to obtain the 
			 * automatically generated ID. we do this by "preparing" our 
			 * PreparedStatement with the name(s) of the keys (columns) that 
			 * will be automatically generated, and obtaining them from the
			 * ResultSet returned from ps.getGeneratedKeys() method
			 */
			
			String sql = "INSERT INTO STORE_AUTHOR (FIRST_NAME, LAST_NAME, BIO) "
					+ "VALUES (?, ?, ?)";
			String[] generatedKeys = {"AUTHOR_ID"}; //takes an array just in case we have more than 1 key
			
			PreparedStatement ps = conn.prepareStatement(sql, generatedKeys);
			ps.setString(1, auth.getFirstName());
			ps.setString(2, auth.getLastName());
			ps.setString(3, auth.getBio());
			
			
			/*
			 * executeQuery returns RESULT SET 
			 * executeUpdate returns NUM ROWS AFFECTED
			 * we do not have to do anything w the number of rows 
			 * but we can 
			 * 
			 * ie. int NumRowsAffected = ps.executeUpdate();
			 */
			 ps.executeUpdate();
			 
			 /*
			  * get autogenerateed ID
			  */
			 
			 ResultSet pk = ps.getGeneratedKeys();
			 pk.next();
			 auth.setId(pk.getInt(1));
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return auth;
	}
	
	
	public void updateAuthor(Author a) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "{ call update_author(?, ?, ?, ?) }";
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.setInt(1, a.getId() );
			cs.setString(2,  a.getFirstName());
			cs.setString(3, a.getLastName());
			cs.setString(4, a.getBio());
			
			cs.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}

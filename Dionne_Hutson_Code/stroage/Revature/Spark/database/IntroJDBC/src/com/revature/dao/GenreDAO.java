package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Genre;
import com.revature.util.ConnectionFactory;

import oracle.jdbc.OracleTypes;
//use a statement to speak to database

public class GenreDAO {
	public List<Genre> findAll(){
		List<Genre> genres=new ArrayList<Genre>();
		try(Connection conn=ConnectionFactory.getInstance().getConnection()){
			String query="select*from store_genre";
			
			//Statment interface
			Statement statement=conn.createStatement();
			
			// reesult set interface hold the result of a query
			ResultSet rs=statement.executeQuery(query);
			//interate over result set next return false if thee is no other row
			while(rs.next()) {
				Genre temp=new Genre(rs.getInt(1),rs.getString(2));
				genres.add(temp);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return genres;
		
	}
	public Genre findById(int id) {
		Genre g= null;
		try(Connection conn=ConnectionFactory.getInstance().getConnection()){
			String query="select*from store_genre where genre_id=?"; 
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1,id);//number,value
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {//or if
				g=new Genre();
				g.setId(rs.getInt(1));
				g.setName(rs.getString(2));
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return g;
		
	}
	
	public Genre update(Genre g, String nameChange) {

		
		try(Connection conn=ConnectionFactory.getInstance().getConnection()){
			
			//conn.setAutoCommit(false);
			
			String sql="UPDATE store_genre set name=? where genre_id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,nameChange);
			ps.setInt(2,g.getId());
			System.out.println("here");
			ps.executeUpdate();
			System.out.println("post");
			g.setName(nameChange);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return g;
	}

	
	public List<Genre> getAllCallable(){
		List<Genre> genres=new ArrayList<Genre>();
		
		try (Connection conn=ConnectionFactory.getInstance().getConnection()){
			String query=" {call get_genres(?) }";//calling call statement
			
					CallableStatement cs=conn.prepareCall(query);
					
				// if we had an in parameter we woulD still do cs.setInt	BUT HERE WERE SPECIFYING THE OUT PARAMETER
					cs.registerOutParameter(1, OracleTypes.CURSOR);
					cs.execute();
					ResultSet rs=(ResultSet) cs.getObject(1);// GET OBJECT TO OBTIN OUT PARAMETER AND CAST IT TO RESULT SET
					
					while(rs.next()) {
						Genre temp=new Genre();
						temp.setId(rs.getInt(1));//1 and 2 is column order you can also use the name
						temp.setName(rs.getString(2));
						genres.add(temp);
					}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return genres;
	}
}

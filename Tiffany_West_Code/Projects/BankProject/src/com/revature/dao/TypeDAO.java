package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.UserDAO;
import com.revature.pojos.Type;
import com.revature.util.ConnectionFactory;

public class TypeDAO {

	
	
	public List<Type> findAll(){
		List<Type> types = new ArrayList<Type>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("select * from bank_account_type");
			
			while(rs.next()) {
				Type t = new Type();
				t.setId(rs.getInt(1));
				t.setType(rs.getString(2));
				types.add(t);
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return types;
		
	}
	
	

}

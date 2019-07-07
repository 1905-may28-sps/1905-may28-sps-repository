package src.com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import src.com.revature.pojo.ERS_USERS;
import src.com.revature.util.ConnectionFactory;

public class ERS_USERSDAO {
 static ERS_USERSDAO userDAO=new ERS_USERSDAO();
 static ERS_USERS user=new ERS_USERS();
 
 public ERS_USERS getUserByUN(String ERS_USERNAME) {
	 ERS_USERS user=new ERS_USERS();
	 try(Connection conn=ConnectionFactory.getInstance().getConnection()){
			String query="SELECT*FROM ERS_USERS WHERE LOWER(ERS_USERNAME)=? "; 
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1,ERS_USERNAME);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				
				user.setUserID(rs.getInt(1));
				user.setUn(rs.getString(2));
				user.setPass(rs.getString(3));
				user.setFn(rs.getString(4));
				user.setLn(rs.getString(5));
				user.setEmail(rs.getString(6));
				user.setRole(rs.getInt(7));
				System.out.println(user);
				return user;
				} else {user=null;}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return user;
 }
}

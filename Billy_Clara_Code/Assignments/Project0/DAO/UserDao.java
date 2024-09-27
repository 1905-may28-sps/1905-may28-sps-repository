package com.revature.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.BankUser;
import com.revature.util.ConnectionFactory;


public class UserDao {
//	
//	public List<BankUser> findAll (){
//	List<BankUser> users = new ArrayList<BankUser>();
//	try(Connection conn = ConnectionFactory.getInstance().getConnection()){
//		String query = "SELECT * FROM BANKUSER";
//		
//		Statement statement = conn.createStatement();
//		
//		ResultSet rs = statement.executeQuery(query);
//		
//		while(rs.next()) {
//			BankUser temp = new BankUser(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
//			users.add(temp);
//		}
//	} catch (SQLException e) {
//		e.printStackTrace();
//	}
// 
//	
//	return users;
//	
//	
//}
//}

	
	
	
	
	
//	public BankUser findById(int id) {
//		BankUser b = null;
//		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
//			String query  = "SELECT * FROM BANKUSER WHERE USERID = ?";
//			PreparedStatement ps = conn.prepareStatement(query);
//			ps.setInt(1, id);
//			ResultSet result = ps.executeQuery();
//			while(result.next()) {
//				b = new BankUser();
//				b.setId(result.getInt(1));
//				b.setFirstName(result.getString(2));
//				b.setLastName(result.getString(3));
//				b.setEmail(result.getString(4));
//				b.setUserName(result.getString(5));
//				b.setPassword(result.getString(6));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return b;
//	}

	public BankUser save(BankUser user) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
		String sql = "INSERT INTO BANKUSER(FIRSTNAME, LASTNAME, EMAIL, USERNAME, PASSWORD) VALUES(?,?,?,?,?)";
		String[] generatedKeys = {"USERID"};
		
		PreparedStatement ps = conn.prepareStatement (sql, generatedKeys);
		ps.setString(1,  user.getFirstName());
		ps.setString(2, user.getLastName());
		ps.setString(3,  user.getEmail());
		ps.setString(4, user.getUserName());
		ps.setString(5, user.getPassword());
		
		ps.executeUpdate();
		ResultSet pk = ps.getGeneratedKeys();
		pk.next();
		user.setId(pk.getInt(1));
		
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		
		
		return user;
		
	}
	
	public BankUser findByUsername(String Username, String Password) {
		BankUser b = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query  = "SELECT * FROM BANKUSER WHERE USERNAME = ? AND PASSWORD = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, Username);
			ps.setString(2, Password);
			ResultSet result = ps.executeQuery();
			while(result.next()) {
				b = new BankUser();
				b.setId(result.getInt(1));
				b.setFirstName(result.getString(2));
				b.setLastName(result.getString(3));
				b.setEmail(result.getString(4));
				b.setUserName(result.getString(5));
				b.setPassword(result.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
	
	public  void updateBankUser(BankUser a) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "{ call update_BANKUSER(?, ?, ?, ?) }";
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.setInt(1, a.getId());
			cs.setString(2, a.getEmail());
			cs.setString(3, a.getUserName());
			cs.setString(4, a.getPassword());
			
			cs.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

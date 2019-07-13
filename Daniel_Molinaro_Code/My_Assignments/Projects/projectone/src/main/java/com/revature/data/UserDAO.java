package com.revature.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Reimb;
import com.revature.pojos.User;
import com.revature.util.ConnectionFactory;  

public class UserDAO {

	public List<User> findAll(){
		List<User> Users = new ArrayList<User>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from ers_users");
			while(rs.next()) {
				User a = new User();
				a.setId(rs.getInt(1));
				a.setFirstName(rs.getString(4));
				a.setLastName(rs.getString(5));
				a.setEmail(rs.getString(6));
				a.setUsername(rs.getString(2));
				a.setPassword(rs.getString(3));
				a.setRoleId(rs.getString(7));
				Users.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Users;
	}

	public User getByUsername(String username) {
		User a = null;

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select * from ers_users where lower(ers_username) = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, username.toLowerCase()); 
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				a = new User();
				a.setId(rs.getInt(1));
				a.setUsername(rs.getString(2));
				a.setPassword(rs.getString(3));
				a.setFirstName(rs.getString(4));
				a.setLastName(rs.getString(5));
				a.setEmail(rs.getString(6));
				a.setRoleId(rs.getString(7));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return a;

	}

	public List<Reimb> getUserInfo(User u) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select * from ers_reimb where reimb_author = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getId());

//			Reimb reimb = new Reimb();
//			info.setUser(u);
			List<Reimb> re = new ArrayList<Reimb>();

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Reimb temp = new Reimb();
				temp.setId(rs.getInt(1));
				temp.setAmount(rs.getDouble(2));
				temp.setSubmitted(rs.getString(3));
				temp.setResolved(rs.getString(4));
				temp.setDescription(rs.getString(5));
				temp.setAuthor(rs.getString(6));
				temp.setResolver(rs.getString(7));
				temp.setStatus(rs.getString(8));
				temp.setTypeId(rs.getString(9));
				
				re.add(temp);
			}
			
			return re;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

}
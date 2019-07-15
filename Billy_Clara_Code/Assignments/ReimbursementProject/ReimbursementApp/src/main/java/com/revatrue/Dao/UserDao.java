package com.revatrue.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Manager;
import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;
import com.revature.util.ConnectionFactory;

public class UserDao {
	
//	public List<User> findAll(){
//		List<User> users = new ArrayList<User>();
//		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
//			String query = "SELECT * FROM ERS_USER";
//			
//			Statement statement = conn.createStatement();
//			
//			ResultSet rs = statement.executeQuery(query);
//			
//			while(rs.next()) {
//				User temp = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
//				users.add(temp);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	 
//		
//		return users;
//		
//		
//	}
	
	public User findByUsername(String Username) {
		User a = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query  = "SELECT * FROM ERS_USER WHERE lower(USERNAME) = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, Username.toLowerCase());
			ResultSet result = ps.executeQuery();
			while(result.next()) {
				a = new User();
				a.setUserid(result.getInt(1));
				a.setUsername(result.getString(2));
				a.setPassword(result.getString(3));
				a.setFirstname(result.getString(4));
				a.setLastname(result.getString(5));
				a.setEmail(result.getString(6));
				a.setUserrole(result.getInt(7));
				return a;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	public List<Reimbursement> getUserInfo(User a) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_AUTHOR = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, a.getUserid());


			List<Reimbursement> r = new ArrayList<Reimbursement>();

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setId(rs.getInt(1));
				temp.setAmount(rs.getInt(2));
				temp.setSubmitted(rs.getString(3));
				temp.setResolved(rs.getString(4));
				temp.setDescription(rs.getString(5));
				temp.setAuthor(rs.getInt(6));
				temp.setResolver(rs.getInt(7));
				temp.setStatusid(rs.getInt(8));
				temp.setTypeid(rs.getInt(9));
				
				r.add(temp);
			}
			
			return r;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Manager> getallRe(){
		List<Manager> reim = new ArrayList<Manager>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT REIMB_ID, FIRSTNAME, LASTNAME, EMAIL, ERS_REIMBURSEMENT.REIMB_AMOUNT, ERS_REIMBURSEMENT.REIMB_SUBMITTED, " + 
					"ERS_REIMBURSEMENT.REIMB_RESOLVED, " + 
					"ERS_REIMBURSEMENT.REIMB_DESC, ERS_STATUS.STATUS, ERS_TYPE.TYPE " + 
					"FROM ERS_REIMBURSEMENT " + 
					"INNER JOIN ERS_USER ON ERS_REIMBURSEMENT.REIMB_AUTHOR = ERS_USER.USERID " + 
					"INNER JOIN ERS_STATUS ON ERS_REIMBURSEMENT.REIMB_STATUSID = ERS_STATUS.STATUSID " + 
					"INNER JOIN ERS_TYPE ON ERS_REIMBURSEMENT.REIMB_TYPEID = ERS_TYPE.TYPEID");
			
			while (rs.next()) {
				Manager a = new Manager();
				a.setId(rs.getInt(1));
				a.setFirstname(rs.getString(2));
				a.setLastname(rs.getString(3));
				a.setEmail(rs.getString(4));
				a.setAmount(rs.getInt(5));
				a.setSubmitted(rs.getString(6));
				a.setResolved(rs.getString(7));
				a.setDescription(rs.getString(8));
				a.setStatus(rs.getString(9));
				a.setType(rs.getString(10));
				reim.add(a);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reim;
	}
	
	public void submit(int amount, String submitted, String resolved, String description, int author, 
			int resolver, int statusid, int typeid) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			Reimbursement a = new Reimbursement();

			String sql = "INSERT INTO ERS_REIMBURSEMENT(REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_RESOLVED, REIMB_DESC, REIMB_AUTHOR, " + 
					"REIMB_RESOLVER, REIMB_STATUSID, REIMB_TYPEID) " + 
					"VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			String[] generatedKeys = { "REIMB_ID" };


			PreparedStatement ps = conn.prepareStatement(sql, generatedKeys);

			ResultSet pk = ps.getGeneratedKeys();

			while (pk.next()) {
				a.setId(pk.getInt(1));
			}
			ps.setInt(1, amount);
			ps.setString(2, "CURRENT_TIMESTAMP");
			ps.setString(3, resolved);
			ps.setString(4, description);
			ps.setInt(5, author);
			ps.setInt(6, resolver);
			ps.setInt(7, 1);
			ps.setInt(8, typeid);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	

public Reimbursement updateReim(Reimbursement u) {		
try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			//Using Prepared Statement
		String query = "UPDATE ERS_REIMBURSEMENT " + 
				"SET REIMB_STATUSID = ? " + 
				"WHERE REIMB_ID = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			
				ps.setInt(1, u.getId());
				ps.setInt(2, u.getStatusid());
				ps.executeUpdate();

				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		return u;
	}

}




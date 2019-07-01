package project0.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project0.pojos.accounts;
import project0.util.ConnectionFactory;

public class AccountsDao {
	
	public static accounts save(accounts a) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "INSERT INTO Accounts (BALANCE, USER_ID)  " + "VALUES (?, ?)";
			String[] generatedKeys = { "ACCOUNT_ID" };

			PreparedStatement ps = conn.prepareStatement(sql, generatedKeys);
			ps.setDouble(1, a.getBalance());
			ps.setInt(2, a.getUser_id());

			ps.executeUpdate();

			ResultSet pk = ps.getGeneratedKeys();
			pk.next();
			a.setAccount_id(pk.getInt(1));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	
	public static List<accounts> findAll() {
		List<accounts> acc = new ArrayList<accounts>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("select * from Accounts");
			while (rs.next()) {
				accounts a = new accounts();
				a.setAccount_id(rs.getInt(1));
				a.setBalance(rs.getDouble(2));
				a.setUser_id(rs.getInt(3));
				acc.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acc;
	}
	
	public static accounts findUserID(int user_id) {
		accounts user = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from BANKUSER where user_id= ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, user_id);
			
			ResultSet log = ps.executeQuery();
			while (log.next()) {
				user = new accounts();
				user.setUser_id(log.getInt(1));
				user.setBalance(log.getDouble(2));
				user.setUser_id(log.getInt(3));
				

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	


//	public List<Accountinfo> getaccountsInfo(){
//		List<Accountinfo> info = new ArrayList<Accountinfo>();
//		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
//			String query = "select Accounts_ID, BALANCE, USER_ID " + 
//					"from ACCOUNTS ACC " + 
//					"join ACCOUTS_BANKUSER ab on ACC.account_id = ab.account_id " + 
//					"join bankuser user on user.user_ID = ab.user_ID " + 
//			PreparedStatement ps = conn.prepareStatement(query);
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				Accountinfo temp = new Accountinfo();
//				temp.title = rs.getString(1);
//				temp.fn = rs.getString(2);
//				temp.ln = rs.getString(3);
//				temp.genre = rs.getString(4);
//				info.add(temp);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return info;
//	}	
	
	public void updateAccounts(accounts a) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "{ call update_Accounts(?, ?, ?) }";
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.setInt(1, a.getAccount_id() );
			cs.setDouble(2,  a.getBalance());
			cs.setInt(3, a.getUser_id());
			
			cs.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
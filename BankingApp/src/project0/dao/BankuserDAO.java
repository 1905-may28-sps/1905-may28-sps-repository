package project0.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project0.pojos.Bankuser;
import project0.util.ConnectionFactory;

public class BankuserDAO {

	public static Bankuser findByUsernameAndPassword(String username, String password) {
		Bankuser user = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from BANKUSER where username = ? and password = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet log = ps.executeQuery();
			while (log.next()) {
				user = new Bankuser();
				user.setUsed_id(log.getInt(1));
				user.setName(log.getString(2));
				user.setUsername(log.getString(3));
				user.setPassword(log.getString(4));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public static Bankuser save(Bankuser user) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "INSERT INTO Bankuser (NAME, USERNAME, PASSWORD) " + "VALUES (?, ?, ?)";
			String[] generatedKeys = { "USER_ID" }; // takes an array just in case we have more than 1 key

			PreparedStatement ps = conn.prepareStatement(sql, generatedKeys);
			ps.setString(1, user.getName());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());

			ps.executeUpdate();

			ResultSet pk = ps.getGeneratedKeys();
			pk.next();
			user.setUsed_id(pk.getInt(1));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public static List<Bankuser> findAll() {
		List<Bankuser> users = new ArrayList<Bankuser>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("select * from Bankuser");
			while (rs.next()) {
				Bankuser a = new Bankuser();
				a.setUsed_id(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setUsername(rs.getString(3));

				users.add(a);
			}

		}catch (SQLException e) {
			e.printStackTrace();
	}
		return users;
}
}
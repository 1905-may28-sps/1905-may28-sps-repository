package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Acct;
import com.revature.pojos.Genre;
import com.revature.pojos.User;
import com.revature.util.ConnectionFactory;

public class AcctDAO {

	public List<Acct> findAll(int id) {

		List<Acct> users = new ArrayList<Acct>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from BANK_ACC where USER_ID = ?");
			ps.setInt(1, id);
			ResultSet result = ps.executeQuery();

			while (result.next()) {
				Acct temp = new Acct();
				temp.setAcct_id(result.getInt(1));
				temp.setBal(result.getInt(2));
				temp.setUser_id(result.getInt(3));
				temp.setType(result.getString(4));
				users.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	public Acct findById(int id) {
		Acct a = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from BANK_ACC where USER_ID = ?");
			ps.setInt(1, id);
			ResultSet result = ps.executeQuery();

			while (result.next()) {
				a = new Acct();
				a.setAcct_id(result.getInt(1));
				a.setBal(result.getInt(2));
				a.setUser_id(result.getInt(3));
				a.setType(result.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	public Acct findByType(String type) {
		Acct a = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from BANK_ACC where acc_type = ?");
			ps.setString(1, type);
			ResultSet result = ps.executeQuery();

			while (result.next()) {
				a = new Acct();
				a.setAcct_id(result.getInt(1));
				a.setBal(result.getInt(2));
				a.setUser_id(result.getInt(3));
				a.setType(result.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	public Acct deleteByType(String type) {
		Acct a = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			PreparedStatement ps = conn.prepareStatement("Delete * from BANK_ACC where acc_type = ?");
			ps.setString(1, type);
			ResultSet result = ps.executeQuery();

			while (result.next()) {
				a = new Acct();
				a.setAcct_id(result.getInt(1));
				a.setBal(result.getInt(2));
				a.setUser_id(result.getInt(3));
				a.setType(result.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	public Acct save(Acct a) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "INSERT INTO BANK_ACC (ACC_ID, BALANCE, USER_ID, ACC_TYPE) VALUES (?, ?, ?, ?)";
			// [] gKeys = { "ACC_ID" };

			PreparedStatement ps = conn.prepareStatement(sql/* , gKeys */);

//			ResultSet pk = ps.getGeneratedKeys();
//
//			while (pk.next()) {
//				a.setAcct_id(pk.getInt(1));
//			}
			ps.setInt(1, a.getAcct_id());
			ps.setDouble(2, a.getBal());
			ps.setInt(3, a.getUser_id());
			ps.setString(4, a.getType());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	public Acct withdraw(Acct a, double balChange) {

		double newBal = a.getBal() - balChange;
		if (newBal >= 0) {
			try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

				PreparedStatement ps = conn.prepareStatement("update BANK_ACC set balance = ? where acc_id  = ?");
				ps.setDouble(1, newBal);
				ps.setInt(2, a.getAcct_id());
				a.setBal(newBal);
				ps.executeUpdate();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		} else {
			System.out.println("Insufficient Funds");

		}
		return a;
	}

	public Acct deposit(Acct a, double balChange) {

		double newBal = a.getBal() + balChange;

		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

			PreparedStatement ps = conn.prepareStatement("update BANK_ACC set balance = ? where acc_id  = ?");
			ps.setDouble(1, newBal);
			ps.setInt(2, a.getAcct_id());
			a.setBal(newBal);
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return a;
	}

}

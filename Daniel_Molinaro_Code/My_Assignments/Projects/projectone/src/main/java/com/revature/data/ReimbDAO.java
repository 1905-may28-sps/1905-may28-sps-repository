package com.revature.data;

import java.sql.CallableStatement;
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

public class ReimbDAO {

	public List<Reimb> findAll() {
		List<Reimb> reimb = new ArrayList<Reimb>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from ERS_REIMB");
			while (rs.next()) {
				Reimb a = new Reimb();
				a.setId(rs.getInt(1));
				a.setAmount(rs.getDouble(2));
				a.setSubmitted(rs.getString(3));
				a.setResolved(rs.getString(4));
				a.setDescription(rs.getString(5));
				a.setAuthor(rs.getString(6));
				a.setResolver(rs.getString(7));
				a.setStatus(rs.getString(8));
				a.setTypeId(rs.getString(9));
				reimb.add(a);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimb;
	}

//	public Reimb getByUser(String user) {}

	public void submit(double amount, String description, String auth, String typeId) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			Reimb a = new Reimb();

			String sql = "INSERT INTO ers_reimb (reimb_amount, reimb_description, reimb_author, reimb_type_id) VALUES (?, ?, ?, ?)";
			String[] gKeys = { "reimb_ID" };

			PreparedStatement ps = conn.prepareStatement(sql, gKeys);

			ResultSet pk = ps.getGeneratedKeys();

			while (pk.next()) {
				a.setId(pk.getInt(1));
			}
			ps.setDouble(1, amount);
			ps.setString(2, description);
			ps.setString(3, auth);
			ps.setString(4, typeId);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void submit2(double amount, String description, int auth, String typeId) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			Reimb a = new Reimb();

			String sql = "INSERT INTO ers_reimb (reimb_amount, reimb_description, reimb_author, reimb_type_id) VALUES (?, ?, ?, ?)";
			String[] gKeys = { "reimb_ID" };

			PreparedStatement ps = conn.prepareStatement(sql, gKeys);

			ResultSet pk = ps.getGeneratedKeys();

			while (pk.next()) {
				a.setId(pk.getInt(1));
			}
			ps.setDouble(1, amount);
			ps.setString(2, description);
			ps.setInt(3, auth);
			ps.setString(4, typeId);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateReimb(int id, String statusId, String resolver) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{ call update_reimb(?,?,?) }";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, id);
			cs.setString(2, statusId);
			cs.setString(3, resolver);

			cs.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateReimb2(int id, String statusId, int resolver) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{ call update_reimb(?,?,?) }";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, id);
			cs.setString(2, statusId);
			cs.setInt(3, resolver);

			cs.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Reimb> getByStatus(String stat) {
			List<Reimb> reimb = new ArrayList<Reimb>();
			try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
				String sql = "select * from ERS_REIMB where STATUS_ID = ?";
				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setString(1, stat);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Reimb a = new Reimb();
					a.setId(rs.getInt(1));
					a.setAmount(rs.getDouble(2));
					a.setSubmitted(rs.getString(3));
					a.setResolved(rs.getString(4));
					a.setDescription(rs.getString(5));
					a.setAuthor(rs.getString(6));
					a.setResolver(rs.getString(7));
					a.setStatus(rs.getString(8));
					a.setTypeId(rs.getString(9));
					reimb.add(a);

				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return reimb;

		}

	public List<Reimb> approved() {
		String status = "2";
		List<Reimb> reimb = new ArrayList<Reimb>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from ERS_REIMB where REIMB_STATUS_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, status);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Reimb a = new Reimb();
				a.setId(rs.getInt(1));
				a.setAmount(rs.getDouble(2));
				a.setSubmitted(rs.getString(3));
				a.setResolved(rs.getString(4));
				a.setDescription(rs.getString(5));
				a.setAuthor(rs.getString(6));
				a.setResolver(rs.getString(7));
				a.setStatus(rs.getString(8));
				a.setTypeId(rs.getString(9));
				reimb.add(a);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reimb;

	}

	public List<Reimb> pending() {
		String status = "1";
		List<Reimb> reimb = new ArrayList<Reimb>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from ERS_REIMB where REIMB_STATUS_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, status);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Reimb a = new Reimb();
				a.setId(rs.getInt(1));
				a.setAmount(rs.getDouble(2));
				a.setSubmitted(rs.getString(3));
				a.setResolved(rs.getString(4));
				a.setDescription(rs.getString(5));
				a.setAuthor(rs.getString(6));
				a.setResolver(rs.getString(7));
				a.setStatus(rs.getString(8));
				a.setTypeId(rs.getString(9));
				reimb.add(a);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reimb;

	}

	public List<Reimb> denied() {
		String status = "3";
		List<Reimb> reimb = new ArrayList<Reimb>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from ERS_REIMB where REIMB_STATUS_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, status);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Reimb a = new Reimb();
				a.setId(rs.getInt(1));
				a.setAmount(rs.getDouble(2));
				a.setSubmitted(rs.getString(3));
				a.setResolved(rs.getString(4));
				a.setDescription(rs.getString(5));
				a.setAuthor(rs.getString(6));
				a.setResolver(rs.getString(7));
				a.setStatus(rs.getString(8));
				a.setTypeId(rs.getString(9));
				reimb.add(a);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reimb;

	}

}

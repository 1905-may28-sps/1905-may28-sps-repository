package src.com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import src.com.revature.pojo.ERS_USERS;
import src.com.revature.pojo.Info;
import src.com.revature.pojo.ReimInfo;
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
 
 
 public Info getEmpInfo(ERS_USERS u) {
	 try(Connection conn=ConnectionFactory.getInstance().getConnection()){
	 String sql="select R.REIMB_ID, R.REIMB_AMOUNT, R.REIMB_SUBMITTED,R.REIMB_RESOLVED,    "
	 		+ "R.REIMB_DESCRIPTION,U.USER_FIRST_NAME,S.REIMB_STATUS,  T.REIMB_TYPE from ERS_REIMBURSEMENT R "
	 		+ "inner join ERS_REIMBURSEMENT_STATUS S ON R.REIMB_STATUS_ID=S.REIMB_STATUS_ID "
	 		+ "inner join ERS_REIMBURSEMENT_TYPE T ON R.REIMB_TYPE_ID=T.REIMB_TYPE_ID "
	 		+ "INNER JOIN ERS_USERS U ON R.REIMB_RESOLVER=U.ERS_USERS_ID where R.REIMB_AUTHOR = ?" ;
	 PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, u.getUserID());
		Info info = new Info();
		info.setUser(u);
		List<ReimInfo> reims = new ArrayList<ReimInfo>();
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			ReimInfo temp = new ReimInfo();
			temp.setId(rs.getInt(1));
			temp.setAmount(rs.getDouble(2));
			temp.setSubmit(rs.getString(3));
			temp.setResolved(rs.getString(4));
			temp.setDescrp(rs.getString(5));
			temp.setMan(rs.getString(6));
			temp.setStatus(rs.getString(7));
			temp.setType(rs.getString(8));
			reims.add(temp);
		}
		info.setReims(reims);
		return info;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
 public Info getAllInfo(ERS_USERS u) {
	 try(Connection conn=ConnectionFactory.getInstance().getConnection()){
	 String sql="select R.REIMB_ID, R.REIMB_AMOUNT, R.REIMB_SUBMITTED,R.REIMB_RESOLVED, "
	 		+ "R.REIMB_DESCRIPTION,U.USER_FIRST_NAME as Emp,S.REIMB_STATUS, T.REIMB_TYPE "
	 		+ "from ERS_REIMBURSEMENT R inner join ERS_REIMBURSEMENT_STATUS S ON R.REIMB_STATUS_ID=S.REIMB_STATUS_ID "
	 		+ "inner join ERS_REIMBURSEMENT_TYPE T ON R.REIMB_TYPE_ID=T.REIMB_TYPE_ID "
	 		+ "INNER JOIN ERS_USERS U "
	 		+ "ON R.REIMB_AUTHOR=U.ERS_USERS_ID ";
	 Statement st = conn.createStatement();
	
		Info info = new Info();
		info.setUser(u);
		List<ReimInfo> reims = new ArrayList<ReimInfo>();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			ReimInfo temp = new ReimInfo();
			temp.setId(rs.getInt(1));
			temp.setAmount(rs.getDouble(2));
			temp.setSubmit(rs.getString(3));
			temp.setResolved(rs.getString(4));
			temp.setDescrp(rs.getString(5));
			temp.setEmp(rs.getString(6));
			temp.setStatus(rs.getString(7));
			temp.setType(rs.getString(8));
			reims.add(temp);
		}
		info.setReims(reims);
		return info;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
}


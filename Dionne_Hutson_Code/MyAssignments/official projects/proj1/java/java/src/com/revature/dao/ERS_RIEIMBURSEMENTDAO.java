package src.com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.com.revature.pojo.ERS_REIMBURSEMENT;
import src.com.revature.pojo.Info;
import src.com.revature.pojo.ReimInfo;
import src.com.revature.util.ConnectionFactory;

public class ERS_RIEIMBURSEMENTDAO {
	static ERS_RIEIMBURSEMENTDAO reimDAO=new ERS_RIEIMBURSEMENTDAO();
	static ERS_REIMBURSEMENT reim= new ERS_REIMBURSEMENT();

	public  ERS_REIMBURSEMENT addReimbursement(ERS_REIMBURSEMENT reim) {

		try(Connection conn=ConnectionFactory.getInstance().getConnection()){

			String sql="insert into ERS_REIMBURSEMENT(REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_RESOLVED, REIMB_DESCRIPTION, REIMB_RECEIPT, "
					+ "REIMB_AUTHOR,REIMB_RESOLVER, REIMB_STATUS_ID,REIMB_TYPE_ID)Values(?,CURRENT_Timestamp,null,?,null,?,"
					+ "null,1,?)";

			String[] generatedKeys= {"REIMB_ID"};
			PreparedStatement ps=conn.prepareStatement(sql, generatedKeys);
			ps.setDouble(1,reim.getAmount());
			ps.setString(2,reim.getDescrp());
			ps.setInt(3, reim.getEmp());
			ps.setInt(4,reim.getType());

			ps.executeUpdate();
			ResultSet pk= ps.getGeneratedKeys();

			pk.next();//move to first row
			reim.setId(pk.getInt(1));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reim;

	}
	public ERS_REIMBURSEMENT updateReimbursement(ERS_REIMBURSEMENT reim) {

		try(Connection conn=ConnectionFactory.getInstance().getConnection()){

			String sql="UPDATE ERS_REIMBURSEMENT SET REIMB_RESOLVED=CURRENT_Timestamp,REIMB_RESOLVER=?,"
					+ "REIMB_STATUS_ID=? WHERE REIMB_ID=?";

			PreparedStatement ps=conn.prepareStatement(sql);

			ps.setInt(1, reim.getMan());
			ps.setInt(2, reim.getStatus());
			ps.setInt(3, reim.getId());

			ps.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reim;

	}

	public List<ERS_REIMBURSEMENT> getReimbursementByUN(ERS_REIMBURSEMENT reim) {
		List<ERS_REIMBURSEMENT> reimList= new ArrayList<ERS_REIMBURSEMENT>();
		try(Connection conn=ConnectionFactory.getInstance().getConnection()){
			String query="SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_AUTHOR=? "; 
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1,reim.getEmp());
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				rs=ps.executeQuery();
				while(rs.next()) {
					ERS_REIMBURSEMENT temp=new ERS_REIMBURSEMENT(rs.getInt(1),rs.getDouble(2),rs.getString(3),rs.getString(4),
							rs.getString(5),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10));
					reimList.add(temp);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimList;
	}
	
	public List<ERS_REIMBURSEMENT> getAllReimbursement() {
		List<ERS_REIMBURSEMENT> reimList= new ArrayList<ERS_REIMBURSEMENT>();
		try(Connection conn=ConnectionFactory.getInstance().getConnection()){
			String query="SELECT * FROM ERS_REIMBURSEMENT "; 
			PreparedStatement ps=conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				rs=ps.executeQuery();
				while(rs.next()) {
					ERS_REIMBURSEMENT temp=new ERS_REIMBURSEMENT(rs.getInt(1),rs.getDouble(2),rs.getString(3),rs.getString(4),
							rs.getString(5),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10));
					reimList.add(temp);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimList;
	}

	public Info getReimbursementByStatus(ERS_REIMBURSEMENT reim) {
		Info info = new Info();
		try(Connection conn=ConnectionFactory.getInstance().getConnection()){
			 
			 String sql=" select R.REIMB_ID, R.REIMB_AMOUNT, man.user_FIRST_NAME as manfn, man.user_last_name, " + 
			 		" R.REIMB_SUBMITTED,R.REIMB_RESOLVED,R.REIMB_DESCRIPTION, T.REIMB_TYPE, S.REIMB_STATUS, r.reimb_author, r.reimb_resolver" + 
			 		" from ERS_REIMBURSEMENT R " + 
			 		"inner join ERS_REIMBURSEMENT_TYPE T ON R.REIMB_TYPE_ID=T.REIMB_TYPE_ID " + 
			 		"inner join ERS_REIMBURSEMENT_STATUS S ON R.REIMB_STATUS_ID=S.REIMB_STATUS_ID " +  
			 		"left outer  join ERS_USERS MAN on MAN.ERS_USERS_ID = R.REIMB_RESOLVER " +  
			 		" where R.REIMB_STATUS_ID = ?" ;
			 PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, reim.getStatus());
				
				List<ReimInfo> reims = new ArrayList<ReimInfo>();
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					ReimInfo temp = new ReimInfo();
					temp.setId(rs.getInt(1));
					temp.setAmount(rs.getDouble(2));
					temp.setManfn(rs.getString(5));
					temp.setManln(rs.getString(6));
					temp.setSubmit(rs.getString(7));
					temp.setResolved(rs.getString(8));
					temp.setDescrp(rs.getString(9));
					temp.setType(rs.getString(10));
					temp.setStatus(rs.getString(11));
					reims.add(temp);
				}
				info.setReims(reims);
				return info;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return info;
	}



}




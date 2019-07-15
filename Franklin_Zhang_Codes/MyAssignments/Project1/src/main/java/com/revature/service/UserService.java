package com.revature.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.revature.dao.ReimbursementDAO;
import com.revature.dao.UsersDAO;

import com.revature.pojo.ReimbursementInfo;
import com.revature.pojo.StatusInfo;
import com.revature.pojo.UserInfo;
import com.revature.pojo.Users;

public class UserService {
	
	private UsersDAO userDao = new UsersDAO();
	private ReimbursementDAO reimbursementDAO= new ReimbursementDAO();
	
	public List<Users> findAllUsers(){
		return userDao.findALL();
	}
	
	public Users login(String username, String password) {
		Users u = userDao.getByUsername(username);
		if(u == null) return null;
		if(u.getPWord().equals(password)) return u;
		return null;
	}
	public UserInfo findALLCurUserReimbursement(Users u) {
		return reimbursementDAO.getUserInfo(u);
	}
	public UserInfo findALLUserReimbursement(Users u) {
		return reimbursementDAO.getAllreimb(u);
	}
	public ReimbursementInfo addReimbursements(ReimbursementInfo user, Users usersess) {
		return reimbursementDAO.addReimbursement(user,usersess);
	}
	
	public ReimbursementInfo updateReimbursements(ReimbursementInfo user, Users usersess) {
		return reimbursementDAO.updateReimbursement(user,usersess);
	}
	public StatusInfo findReimbursementByStatus(StatusInfo user) {
		return reimbursementDAO.getReimbByStatus(user);
	}
	


//
//	public Users register(String uName) {
//		Users u = userDao.getByUsername(uName);
//		if(u == null) return u;
//		if(u.getUName().equals(uName)) return null;
//		return null;
//	}
	
//	public UserInformation getInfo(User u) {
//		return userDao.getUserInfo(u);
//	}

}
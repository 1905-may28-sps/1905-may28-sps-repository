package src.com.revature.service;

import src.com.revature.dao.ERS_USERSDAO;
import src.com.revature.pojo.ERS_USERS;
import src.com.revature.pojo.Info;

public class ERS_USERSERVICE {
	 ERS_USERSDAO userDAO= new ERS_USERSDAO();
	
	 public ERS_USERS getUserByUN(String un) {
		 return userDAO.getUserByUN(un);
	 }

	public ERS_USERS login(String username, String password) {
		ERS_USERS u= userDAO.getUserByUN(username);
		if (u==null) return null;
		if (u.getPass().equals(password))
		{ System.out.println(u);
		return u;}
		return null;
	}
	public Info getInfoThruEmp(ERS_USERS u) {
		return userDAO.getEmpInfo(u);
	}
	public Info getInfoThruMan(ERS_USERS u) {
		return userDAO.getAllInfo(u);
	}
	
	
}

package src.com.revature.service;

import src.com.revature.dao.ERS_USERSDAO;
import src.com.revature.pojo.ERS_USERS;

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
}

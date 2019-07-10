package com.revature.data;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.User;
import com.revature.util.ConnectionUtil;

public class UserDao {
	static ConnectionUtil util = ConnectionUtil.getInstance();
	
	public User save(User u) {
		return null;
	}
	
	public User getByUsername(String username) {
		return null;
	}
	
	public User getById(int id) {
		User u = null;
		Session session = util.getSession();
		try {
			Transaction tx = session.beginTransaction();
			u = (User) session.get(User.class, id);
			tx.commit();
		}finally {
			session.close();
		}
		return u;
	}
	
	

}

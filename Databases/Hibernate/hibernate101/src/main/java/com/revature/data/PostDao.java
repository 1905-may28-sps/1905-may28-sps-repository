package com.revature.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.Post;
import com.revature.model.User;
import com.revature.util.ConnectionUtil;

public class PostDao {
	
	static ConnectionUtil util = ConnectionUtil.getInstance();
	
	public Post save(Post p) {
		Session session = util.getSession();
		try {
			Transaction tx = session.beginTransaction();
			int id = (int) session.save(p);
			tx.commit();
			p.setId(id);
		}
		finally {
			session.close();
		}
		return p;
	}
	
	public List<Post> getByAuthor(User u){
		//use either query or criteria 
		return null;
	}
	
	public List<Post> getByKeyword(String keyword){
		return null;
	}

}

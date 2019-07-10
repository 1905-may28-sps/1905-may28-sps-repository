package com.revature.data;

import java.util.List;

import org.hibernate.Query;
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
		Session session = util.getSession();
		try {
			Query query = session.createQuery
					("from Post where author = :user");
			query.setParameter("user", u);
			return query.list();
		}
		finally {
			session.close();
		}
	}
	
	public List<Post> getByKeyword(String keyword){
		List<Post> posts = null;
		Session session = util.getSession();
		try {
			Query query = session.getNamedQuery("getByKeyword");
			query.setParameter("keyword", "%" + keyword.toLowerCase() +"%");
			posts = query.list();
		}finally {
			session.close();
		}
		return posts;
		
	}

}

package com.revature.data;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.reavture.app.ExploringHibernate;
import com.reavture.util.ConnectionUtil;
import com.revature.model.Post;
import com.revature.model.User;

public class PostDao {
	static ConnectionUtil util = ConnectionUtil.getInstance();
	final static Logger logger = Logger.getLogger(ExploringHibernate.class);
	
	public Post save(Post p) {
		Session session = util.getSession();
				try {
					logger.info("opened session " + session.getStatistics());
					Transaction tx = session.beginTransaction();
					int id= (int) session.save(p);
					
				
					
				}finally {
					session.close();
				}		
		return null;
		
		
	}
	
	public List<Post> getByAuthor(User u){
		Session session = util.getSession();
		try {
			Query query = session.createQuery("from post where author = :user");
			query.setParameter("user", u);
		}
		finally {
			session.close();
		}
		return null;
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


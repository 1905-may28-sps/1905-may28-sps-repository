package com.reavture.app;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.reavture.util.ConnectionUtil;
import com.revature.model.User;


public class ExploringHibernate {

	static ConnectionUtil util = ConnectionUtil.getInstance();
	final static Logger logger = Logger.getLogger(ExploringHibernate.class);
	
	public static void main(String[] args) {
		/*
		//save();
		//persist();
		 User u = getDemo();  //detached user
		 u.setUsername("goingToUpdate");
		 u.setPassword("passwordnew");
		 
		 //User u = new User("")
		 */
		System.out.println(exploringCriteria());
		
		
	}
	
	static User save() {
		User u = new User("Genesis", "123"); //TRANSIENT
		Session session = util.getSession();
		try {
			logger.info("opened session " + session.getStatistics());
			
			/*
			 * Hibernate does not automatically commit data 
			 * at the end of a session, so we must begin a
			 * transaction to commit our changes/to have
			 * control over our tx
			 */
			Transaction tx = session.beginTransaction();
			int id = (int) session.save(u); //just associated user w session. it is PERSISTENT
			
			u.setUsername("changed username");
			u.setPassword("testpassword");
			tx.commit(); //committing data 
			u.setId(id);
		}finally {
			logger.info("about to close session");
			session.close();
			/*
			 * Now session is closed, all objects associated w this 
			 * session are DETACHED
			 */
		}
		return u;
	}
	
	/**
	 * 
	 */
	
	static void persist() {
		User u = new User("updateUser", "test");
		u.setId(1);
		Session session = util.getSession();
		try {
			Transaction tx = session.beginTransaction();
			session.persist(u);
			tx.commit();
		}finally {
			session.close();
		}
	}
	/*//ADD LOAD LATER
	static User  getDemo() {
		Session session = util.getSession();
		User u = null;
		
		try {
			
			logger.info("RETRIEVING  USER W/ GET METHOD");
			 u = (User) session.get(User.class, 1);
			 
			 logger.info("RETRIEVED USER, ABOUT TO CALL METHOD ON OBJ WHILE IN SESSION");
			System.out.println(u);
			
		}finally {
			session.close();

		}
		return u;
	}*/
	
	
	// this get demo has a transactoin that  we updated the username and in the console 
	static User getDemo() {
		User u = null;
		Session session = util.getSession();
		try {
			Transaction tx = session.beginTransaction();
			u= (User) session.get(User.class, 1);
			
			//u.setUsername("changedUsernameWith");
			
			tx.commit();
		}finally {
			session.close();
		}
		return u;
	}
	
	//Update
	
	static void update(User u) {
		Session session = util.getSession();
		try {
			Transaction tx = session.beginTransaction();
			
			session.update(u);
			tx.commit();
			
		}finally {
			session.close();
		}
	}
	
	static void merge(User u) {
		Session session = util.getSession();
		try {
			Transaction tx = session.beginTransaction();
			
			session.merge(u);
			tx.commit();
			
		}finally {
			session.close();
		}
	}
	
	/*
	 * CRITERIA INTERFACE
	 * 
	 * https://docs.jboss.org/hibernate/orm/5.2/javadocs/org/hibernate/criterion/Restrictions.html
	 */
	static List<User> findAllCriteria(){
		List<User> users = null;
		Session session = util.getSession();
		try {
			Criteria criteria = session.createCriteria(User.class);
			users= criteria.list();
		}finally {
			session.close();
		}
		return users;
	}
	
	static List<User> exploringCriteria(){
		List<User> users = null;
		Session session = util.getSession();
		try {
			Criteria criteria = session.createCriteria(User.class)
					.add(Restrictions.ge("id", 2))
					.addOrder(Order.asc("username"));
			users= criteria.list();
		}finally {
			session.close();
		}
		return users;
	}
	
	/*
	 * QUERY INTERFACE
	 * write SQL queries using HQL
	 */
	static User findByUsernameQuery(String username) {
		User u = null;
		Session session = util.getSession();
		Query query = session
				.createQuery("from User where lower(username) = :param");
		query.setParameter("param", username.toLowerCase());
		u = (User) query.uniqueResult();
		return u;
	}
}

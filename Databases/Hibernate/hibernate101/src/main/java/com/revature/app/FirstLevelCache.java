package com.revature.app;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.User;
import com.revature.util.ConnectionUtil;

/*
 * Exploring Caching in Hibernate
 * 
 * Caching is a facility provided by ORM frameworks which help 
 * users to get fast running web application, while help framework 
 * itself to reduce number of queries made to database in a single 
 * transaction. Hibernate achieves the second goal by implementing 
 * first level cache.
 * 
 * First level cache in Hibernate is enabled by default and you 
 * do not need to do anything to get this functionality working. In 
 * fact, you can not disable it even forcefully.
 * 
 * Its easy to understand the first level cache if we understand 
 * the fact that it is associated with Session object. As we know 
 * session object is created on demand from session factory and it 
 * is lost, once the session is closed. Similarly, first level cache 
 * associated with session object is available only while session 
 * object is live (not closed). It is available to that specific 
 * session object only and is not accessible to any other session 
 * object in any other part of application.
 */
public class FirstLevelCache {

	static ConnectionUtil util = ConnectionUtil.getInstance();
	static final Logger logger = Logger.getLogger(FirstLevelCache.class);
	
	public static void main(String[] args) {
		newSession();
	}
	
	static void exploringL1() {
		//open our session -- as we know cache lives here
		Session session = util.getSession();
		Transaction tx = session.beginTransaction();
		
		//retrieve data for first time w get() do we hit DB?
		User u = (User) session.get(User.class, 1);
		logger.info("Just retrieved user with get(); method " + u);
		
		logger.info("about to get the same user again... do we see hibernate hit the dB?");
		u = (User) session.get(User.class, 1);
		
		logger.info("next, what happens if we UPDATE our user?");
		u.setUsername("changingmyusername");
		session.update(u);
		
		logger.info("now, if we run the same get(); method will we hit the db?");
		u = (User) session.get(User.class, 1);

		
		tx.commit();
		session.close();
	}
	
	static void newSession() {
		//open multiple sessions
		Session s1 = util.getSession();
		Session s2 = util.getSession();

		//retrieve data
		User u = (User) s1.get(User.class, 1);
		logger.info("SESSION 1: Just retrieved user " + u.toString());
		
		//retrieve data with session 2. will we hit the db?
		u = (User) s2.get(User.class, 1);
		logger.info("SESSION 2: Just retrieved user " + u.toString());
		
		//close sessions
		s1.close();
		s2.close();
	}
	
	static void remove() {
		Session session = util.getSession();
		Transaction tx = session.beginTransaction();
		logger.info("about to retrieve user");
		User u = (User) session.get(User.class, 1);
		
		//remove object from session cache
		session.evict(u);
		logger.info("just evicted user from session cache. let's try retrieving it again");
		//u = (User) session.get(User.class, 2);
		
		u.setUsername("NOT PERSISTED"); //does not persist. but why???
		
		//clear all objects from cache
		//session.clear();
		u.setUsername("our object should be detached");
		//session.update(u);
		
		tx.commit();
		session.close();
	}
	
}

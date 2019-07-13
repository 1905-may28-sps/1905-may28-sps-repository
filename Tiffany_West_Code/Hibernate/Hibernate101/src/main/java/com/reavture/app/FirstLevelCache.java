package com.reavture.app;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.reavture.util.ConnectionUtil;
import com.revature.model.User;

/*
 * Exploring Caching in Hibernate
 * 
 * Caching is a facility provided by ORM frameworks which help 
 * users to get fast running web application, while help framework 
 * itself to reduce number of queries made to database in a single 
 * transaction. Hibernate achieves the second goal by implementing 
 * first level cache.
 * 
 * First level cache in hibernate is enabled by default and you 
 * do not need to do anything to get this functionality working. In 
 * fact, you can not disable it even forcefully.
 * 
 * Its easy to understand the first level cache if we understand 
 * the fact that it is associated with Session object. As we know 
 * session object is created on demand from session factory and it 
 * is lost, once the session is closed. Similarly, first level cache 
 * associated with session object is available only till session 
 * object is live. It is available to session object only and is not 
 * accessible to any other session object in any other part of application.
 */
public class FirstLevelCache {

	static ConnectionUtil util = ConnectionUtil.getInstance();
	final static Logger logger = Logger.getLogger(ExploringHibernate.class);
	
	public static void main(String[] args) {
		exploringL1();
	}

	 static void exploringL1() {
		 //open our session -- as we know our cache lives here
		 Session session = util.getSession();
		 Transaction tx = session.beginTransaction();
		 
		 //retrieve data
		 User u =(User) session.get(User.class, 1);
		 logger.info("just retrieved user with get(); method " + u);
		 
		 logger.info("about to.......... do we see ");
		 u = (User) session.get(User.class, 1);
		 
		 logger.info("next, what happens.....");
		 u.setUsername("changingusername");
		 session.update(u);
		 
		 logger.info("now, if we run....");
		 u = (User) session.get(User.class, 1);
		 
		 
		 tx.commit();
		 session.close();
	}
}

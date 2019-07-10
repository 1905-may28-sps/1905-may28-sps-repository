package com.revature.app;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.User;
import com.revature.util.ConnectionUtil;

public class ExploringHibernate {

	static ConnectionUtil util = ConnectionUtil.getInstance();
	final static Logger logger = Logger.getLogger(ExploringHibernate.class);
	
	public static void main(String[] args) {
		persist();
	}
	
	/*
	 * SAVE
	 * - adds instance to db
	 * - persists transient instance, returns whatever Serializable
	 * identifier is used for the instance 
	 * - saving a persisted instance does nothing 
	 * - saving a detached instance creates a new persistant instance
	 * and assigns it a new identifier, which results in a duplicate
	 * record. do not do!
	 */
	static User save() {
		User u = new User("withId", "123"); //TRANSIENT
		u.setId(1000);
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
			//what happens if we update our user instance while it is persistent?
			
		/*	u.setUsername("nocommitx2");
			u.setPassword("testpassword");
			u.setUsername("hasId"); */
		
			tx.commit(); //committing data 
			u.setId(id);
		}finally {
			logger.info("about to close session");
			//before session closes, hibernate checks the state of our java instance 
			//with the properties saved in the db row 
			//if these two are out of "sync" or basically not the same, hibernate 
			//will update the row with the current state of the object
			//this is called automatic dirty checking
			session.close();
			/*
			 * Now session is closed, all objects associated w this 
			 * session are DETACHED
			 */
		}
		return u;
	}
	
	/*
	 * The persist method is intended for adding a new entity 
	 * instance to the persistence context (change object 
	 * state from transient -> persistent)
	 * Close behavior to save(), except if we attempt to call 
	 * persist on a detached object, an exception will be thrown
	 * 
	 *  org.hibernate.PersistentObjectException: detached entity passed to persist:
	 */
	static void persist() {
		User u = new User("updateUser", "test");
		u.setId(100);
		Session session = util.getSession();
		try {
			Transaction tx = session.beginTransaction();
			session.persist(u);
			tx.commit();
		}finally {
			session.close();
		}
	}

}

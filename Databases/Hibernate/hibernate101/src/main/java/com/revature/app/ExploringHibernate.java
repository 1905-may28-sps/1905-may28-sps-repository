package com.revature.app;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.revature.model.User;
import com.revature.util.ConnectionUtil;

public class ExploringHibernate {

	static ConnectionUtil util = ConnectionUtil.getInstance();
	final static Logger logger = Logger.getLogger(ExploringHibernate.class);
	
	public static void main(String[] args) {
		System.out.println(exploringCriteria());
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
	
	/*
	 * Session.get(id)
	 * - returns persisted object with specified identifier
	 * - if the object does not exist, the method will return null
	 * - method hits the database immediately(eager fetching), regardless of whether
	 *  any methods are called on the object in the persistent state
	 * - use this method to retrieve data that we are not sure exists or 
	 * if we are using objects outside of the scope of a hibernate session
	 */
	/*
	 * Session.load(id)
	 * - retrieves a persisted instance by id. 
	 * - load will throw an ObjectNotFoundException if it attempts 
	 * to load a nonexistent row 
	 * - this method returns a PROXY of the object and does not 
	 * hit the database until a method of the object is called
	 * while the session is still open (lazy fetching)
	 * - If a method is called on a proxy, we see a LazyInitializationException
	 * - a proxy is a hibernate object that allows for lazy loading
	 * of data; it is basically a shell of an object that holds the 
	 * ID of it without any actual data from DB. Gets data when it 
	 * has a method called on it 
	 */
	
	static User getvsLoad() {
		Session session = util.getSession();
		User u = null;
		try {
			logger.info("RETRIEVING USER WITH GET METHOD");
			u = (User) session.load(User.class, 1000);
	
			/*
			 * Remember that we implicitly call an object's toString() 
			 * method when we put it in a sysout
			 */
			logger.info("RETRIEVED USER, ABOUT TO CALL METHOD ON OBJ WHILE IN SESSION");
			System.out.println(u); 
			
		}finally {
			session.close();
		}
		return u;
	}
	
	static User getDemo() {
		User u = null;
		Session session = util.getSession();
		try {
			Transaction tx = session.beginTransaction();
			u = (User) session.get(User.class, 1);
			
		//	u.setUsername("closedSession");
			/*
			 * Hibernate leverages transactional write-behind
			 * and waits until the end of the transaction (tx.commit())
			 * to persist data once brought into the persistent state
			 */
			tx.commit();
		}finally {
			session.close();
		}
		return u;
	}
	
	/*
	 * session.update(Object)
	 * - transitions the object passed in as param from detached to persistent 
	 * - throws an exception if you pass it a transient entity
	 * (obj without ID or ID that doesnt exist)
	 * - org.hibernate.StaleStateException: 
	 */
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
	
	static void getVmerge() {
		/*	User u = getDemo(); //detached user
		u.setUsername("goingToUpdate");
		u.setPassword("p4ssw0rd"); */
		
		User u = new User("mergeNoId", "123");
	//	u.setId(1000); //Hibernate will treat this user as detached bc it has an id 
	
		merge(u);
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
					.add(Restrictions.ge("id", 20))
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

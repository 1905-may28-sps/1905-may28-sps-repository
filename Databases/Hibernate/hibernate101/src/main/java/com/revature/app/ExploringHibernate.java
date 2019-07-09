package com.revature.app;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.User;
import com.revature.util.ConnectionUtil;

public class ExploringHibernate {

	static ConnectionUtil util = ConnectionUtil.getInstance();
	final static Logger logger = Logger.getLogger(ExploringHibernate.class);
	
	public static void main(String[] args) {
		save();
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

}

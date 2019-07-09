package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class ConnectionUtil {
	//this class will use the Configuration interface to create a 
	//singleton instance of a SessionFactory, which will give the 
	//application the ability to use sessions
		
		/*
		 * Hibernate utilizes sessions for connections to the database.
		 * JDBC used connections.
		 * 
		 * Hibernate will implement connection pooling.
		 * 		1. Connections will be maintained.
		 * 		2. We can have 1-n connections to the database.
		 * 
		 * Spinning up a new connection to the database is expensive. By not having to spin up new
		 * connections for every transaction, you save time and resources.
		 * 
		 * Secondly, the connections will be shared across transactions over time. It's a session
		 * because our transaction is utilizing a connection for a given period. And will release
		 * that session such that other transaction can use it.
		 * 
		 * Finally, hibernate will maintain a pool of connections, so concurrent transactions can
		 * occur without having to wait for a connection to open up.
		 */
	
	private static ConnectionUtil cu;
	private SessionFactory sf;

	public synchronized static ConnectionUtil getInstance() {
		if(cu == null) {
			cu = new ConnectionUtil();
		}
		return cu;
	}
	
	private synchronized SessionFactory getSessionFactory() {
		if(sf == null) {
			//get configuration details from hibernate.cfg.xml
			/*
			 * An instance of Configuration allows the application
			 * to specify properties and mapping documents to be 
			 * used when creating a SessionFactory. Usually an 
			 * application will create a single Configuration, 
			 * build a single instance of SessionFactory and then 
			 * instantiate Sessions in threads servicing client requests. 
			 * The Configuration is meant only as an initialization-time 
			 * object. SessionFactorys are immutable and do not retain 
			 * any association back to the Configuration.
			 */
			Configuration hibConfig = new Configuration().configure();
			
			//http://docs.jboss.org/hibernate/orm/4.3/topical/html/registries/ServiceRegistries.html
			
			ServiceRegistry registry = new ServiceRegistryBuilder()
					.applySettings(hibConfig.getProperties())
					.buildServiceRegistry();
			
			sf = hibConfig.buildSessionFactory(registry);
		}
		return sf;
	}
	
	//use private getSessionFactory method to return sessions
	public Session getSession() {
		return this.getSessionFactory().openSession();
	}

}

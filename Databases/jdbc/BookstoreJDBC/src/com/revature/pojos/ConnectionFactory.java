package com.revature.pojos;

public class ConnectionFactory {
	
	/*
	 * Connections are a vital tool in JDBC
	 * We use the ConnectionFactory to establish a connection 
	 * with the database
	 * 
	 * This will use a lazy singleton design pattern to 
	 * return the same single connectionfactory instance
	 * each time one is requested so that we can monitor
	 * the amount of connections that our connectionfactory 
	 * generates 
	 * 
	 * In order to establish a connection, we need four things - 
	 * Driver, DB location (URL), DB username, db password 
	 */


}

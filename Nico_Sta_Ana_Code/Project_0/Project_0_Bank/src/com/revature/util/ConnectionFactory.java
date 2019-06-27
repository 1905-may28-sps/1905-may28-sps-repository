package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	
	
	
private static ConnectionFactory cf = null;
	
	private ConnectionFactory() {}
	
	public static synchronized ConnectionFactory getInstance() {
		if(cf == null) cf = new ConnectionFactory();
		return cf;
	}
	
	/*
	 * Connection - one of the core interfaces in the JDBC API
	 * - manages our connection to (session with) the database
	 * - allows us to execute SQL statements and return results 
	 * - has information about DB tables, stored procedures, and 
	 * all other related db objects. 
	 */
	public Connection getConnection() {
		Connection conn = null;
		
		Properties prop = new Properties();
		
			
			//the following line of code instantiates the driver by its class name
			try {
				prop.load(new FileReader("src/com/revature/util/db.properties"));
				
				String driver = prop.getProperty("driver");
				String url = prop.getProperty("url");
				String pw = prop.getProperty("pwd"); 
				String username = prop.getProperty("user");
			
				Class.forName(driver);
			/* The DriverManager provides a basic service for 
			 * managing a set of JDBC drivers. As part of its 
			 * initialization, the DriverManager class will 
			 * attempt to load the driver class referenced previously 	 */
			conn = DriverManager.getConnection(url, username, pw);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		return conn;
	}
}

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
	
	public Connection getConnection() {
		Connection conn = null;
		
		Properties prop = new Properties();
		
			try {
				prop.load(new FileReader("C:/Users/Franklin/Servlets/Project1/src/main/java/com/revature/util/database.properties"));
				
				String driver = prop.getProperty("driver");
				String url = prop.getProperty("url");
				String pw = prop.getProperty("pwd"); 
				String username = prop.getProperty("user");
			
				Class.forName(driver);
			
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
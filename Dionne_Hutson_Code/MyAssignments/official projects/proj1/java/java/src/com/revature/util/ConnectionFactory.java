
package src.com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//establish connection to database
//were using the lazy singleton design pattern, private constructor, we instantiate it the first time we call get instance

public class ConnectionFactory {//we dont want too many connections
	//need driver
	//location
	//username
	//password
	private static ConnectionFactory cf=null;
	private ConnectionFactory() {}

	public static synchronized ConnectionFactory getInstance(){//thread safe
		if (cf==null) cf=new ConnectionFactory();
		return cf;
	}
	//generate connection
	public Connection getConnection() {
		Connection conn=null;


		//instantiates the driver by class name
		try {
			Properties prop= new Properties();
			prop.load(new FileReader("C:/Users/blank/Documents/Revature/Spark/servlets/Project1/src/main/java/src/com/revature/util/db.properties"));
			String driver=prop.getProperty("driver");//hardcode this but people will see all this info we need a property file since this is sensitive we could also make this an environment variable
			String url=prop.getProperty("url");;
			String user=prop.getProperty("user");;
			String password=prop.getProperty("password");;


			Class.forName(driver);
			//attempts to load driver class refrenced previously
			//driver allows us to connect from java to database
			conn=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return conn;
	}


}



package mceletronics.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class Db {
	private static Connection connection = null; 
	public static Connection getConnection() {
		if (connection != null)
			return connection;
		else {
			Properties prop = new Properties();
			InputStream inputStream = Db.class.getClassLoader().getResourceAsStream("db.properties");
			try {
				prop.load(inputStream);
				String driver = prop.getProperty("driver");
				String url = prop.getProperty("url");
				String user = prop.getProperty("user");
				String password = prop.getProperty("password");
				Class.forName(driver);
				connection = DriverManager.getConnection(url, user, password);
				return connection;
			} catch (Exception e) { 
				e.printStackTrace();
			} 
		}
		
		return null;
	}
	public static void disconnect() {
		try {
			connection.close();
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}
	
	
}

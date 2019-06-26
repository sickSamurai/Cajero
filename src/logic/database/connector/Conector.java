package logic.database.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conector {

	private static Connection connection;
	private static String urlDatabase;
	private static String user;
	private static String password;

	private Conector() {
	}

	public static void setValues(String urlDatabase, String user, String password) {
		Conector.urlDatabase = urlDatabase;
		Conector.user = user;
		Conector.password = password;
	}	

	public static Connection getConnection() {
		return connection;
	}
		
	public static void tryConnect() {
		try {
			connection = DriverManager.getConnection(urlDatabase, user, password);
		} catch (SQLException e) {
			Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, e.getMessage());
		}
	}

	public static void tryClose() {
		try {
			connection.close();
		} catch (SQLException e) {
			Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, e.getMessage());
		}
	}

}

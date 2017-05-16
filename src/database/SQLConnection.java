package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * Class Description: Class used to connect to the database
 * 
 * @author : Eashan Tilve
 */
public class SQLConnection {

	private Connection connection;

	/**
	 * This method is used to connect to the database
	 * 
	 * @return Connection returns the Connection object after connecting to
	 *         ozlympic.db
	 */
	public Connection createConnection() {
		connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:src/database/ozlympic.db");
			connection.setAutoCommit(true);
			return connection;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
			return connection;
		} catch (Exception e) {
			return connection;
		}
	}

}

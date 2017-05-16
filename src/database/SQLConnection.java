package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {

	// public static final String DB_URL = "jdbc:sqlite:Ozlympic.db";
	// jdbc:sqlite:/Users/MacBook_Main/Documents/workspace/Ozlympic/ozlympic.db"
	private Connection connection;

	public SQLConnection() {

	}

	public Connection createConnection() {
		connection = null;

		// ADD DATA ON SCREEN
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:src/database/ozlympic.db");
			connection.setAutoCommit(true);
			return connection;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return connection;
		} catch (Exception e) {
			return connection;
		}
	}

}

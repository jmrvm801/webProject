package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * This class allows set a connection with the Mysql database
 * 
 * @author Fernando
 * @version 1.0
 *
 */
public class DataBase {
	
	/**
	 * String connection
	 */
	private static String conn = "jdbc:mysql://localhost/economic?user=root&password=";
	
	/**
	 * Represents a precompiled SQL statement
	 */
	PreparedStatement ps = null;
	
	/**
	 * Represents the SQL result
	 */
	ResultSet rs = null;

	/**
	 * This method allows to make a query.
	 * 
	 * @param query
	 *            The String SQL to do.
	 * @return The SQL result like a table.
	 */
	public ResultSet query(String query) {
		Connection connect = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(conn);
			ps = connect.prepareStatement(query);
			rs = ps.executeQuery();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
		return rs;
	}

	/**
	 * This method closes the connection.
	 */
	public void close() {
		try {
			rs.close();
			ps.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
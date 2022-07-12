package com.jasdhir.ers.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	private static ConnectionUtils connectionUtils;
	private Connection connection;

	private ConnectionUtils() throws SQLException {

		String url = System.getenv("ERS_URL");
		  try {
	            Class.forName("org.postgresql.Driver");
	            this.connection = DriverManager.getConnection(url);
	        } catch (ClassNotFoundException ex) {
	            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
	        }

	}
	public Connection getConnection() {
        return connection;
    }
	
	public static ConnectionUtils getInstance() throws SQLException {
        if (connectionUtils == null) {
        	connectionUtils = new ConnectionUtils();
        } else if (connectionUtils.getConnection().isClosed()) {
        	connectionUtils = new ConnectionUtils();
        }

        return connectionUtils;
    }
}

package com.jeffersonssousa.config.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.jeffersonssousa.config.entities.DatabaseException;
import com.jeffersonssousa.config.entities.NotFoundPropertiesException;

public class DBConnection {

	private static Connection conn = null;

	public static Connection getConnection() {
		if (conn == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);
			} catch (SQLException e) {
				throw new DatabaseException("error connecting to database: " + e.getMessage());
			}
		}
		return conn;
	}

	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DatabaseException("Error closing database connection: " + e.getMessage());
			}
		}
	}

	public static void closeStatement(Statement st)  {
		if(st != null) {
			try {
			st.close();
			}catch(SQLException e) {
				throw new DatabaseException("Error closing Statement: " + e.getMessage());
			}
		}
	}

	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DatabaseException("Error closing ResultSet: " + e.getMessage());
			}
		}
	}

	private static Properties loadProperties() {
		try (FileInputStream file = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(file);
			return props;
		} catch (IOException e) {
			throw new NotFoundPropertiesException(e.getMessage());
		}
	}

}

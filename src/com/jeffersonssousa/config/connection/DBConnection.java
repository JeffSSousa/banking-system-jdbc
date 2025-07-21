package com.jeffersonssousa.config.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.jeffersonssousa.config.exceptions.DatabaseException;
import com.jeffersonssousa.config.exceptions.NotFoundPropertiesException;

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

	        Properties resolvedProps = new Properties();

	        for (String key : props.stringPropertyNames()) {
	            String value = props.getProperty(key);
	            if (value != null && value.matches("\\$\\{.+}")) {
	                String envVar = value.substring(2, value.length() - 1);
	                String envValue = System.getenv(envVar);
	                if (envValue == null) {
	                    throw new NotFoundPropertiesException("Variável de ambiente '" + envVar + "' não definida");
	                }
	                resolvedProps.setProperty(key, envValue);
	            } else {
	                resolvedProps.setProperty(key, value);
	            }
	        }
	        return resolvedProps;
	    } catch (IOException e) {
	        throw new NotFoundPropertiesException(e.getMessage());
	    }
	}

}

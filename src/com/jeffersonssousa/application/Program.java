package com.jeffersonssousa.application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jeffersonssousa.config.connection.DBConnection;

public class Program {
	public static void main(String[] args) throws SQLException {

		System.out.println("Test Connection...");
		Connection conn = DBConnection.getConnection();
		System.out.println("Successful Connection");

		System.out.println();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM tb_type_access");

		while (rs.next()) {
			System.out.println("Access: " + rs.getString("name"));
		}

		DBConnection.closeConnection();
		DBConnection.closeResultSet(rs);
		DBConnection.closeStatement(st);

		System.out.println();
		System.out.println("Close Connection...");

	}
}
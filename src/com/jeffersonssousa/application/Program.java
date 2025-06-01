package com.jeffersonssousa.application;

import java.sql.Connection;

import com.jeffersonssousa.config.connection.DBConnection;

public class Program {
	public static void main(String[]args) {
		
		System.out.println("Test Connection...");
		Connection conn = DBConnection.getConnection();
		DBConnection.closeConnection();
		System.out.println("Successful Connection");
	}
}
package com.jeffersonssousa.application;

import java.sql.Connection;

import com.jeffersonssousa.config.connection.DBConnection;
import com.jeffersonssousa.repository.ClientRepository;

public class Program {
	public static void main(String[] args) {

		Connection conn = DBConnection.getConnection();
		ClientRepository client = new ClientRepository(conn);
		
		System.out.println(client.findById(2));
		
		DBConnection.closeConnection();

	}
}
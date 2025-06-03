package com.jeffersonssousa.application;

import java.sql.Connection;
import java.time.LocalDate;

import com.jeffersonssousa.config.connection.DBConnection;
import com.jeffersonssousa.model.entities.Client;
import com.jeffersonssousa.repository.ClientRepository;

public class Program {
	public static void main(String[] args) {

		Connection conn = DBConnection.getConnection();
		ClientRepository client = new ClientRepository(conn);
		

	     Client newClient = new Client(null, "Fulano", "Da Silva", "487.896.526-96", "fulano@gmail.com", LocalDate.parse("2024-10-24"));

	     client.insert(newClient);
	     
		
		DBConnection.closeConnection();

	}
}
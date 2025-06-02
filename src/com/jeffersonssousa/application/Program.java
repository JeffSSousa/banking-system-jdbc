package com.jeffersonssousa.application;

import java.sql.Connection;

import com.jeffersonssousa.config.connection.DBConnection;
import com.jeffersonssousa.repository.ClientRepository;

public class Program {
	public static void main(String[] args) {

		Connection conn = DBConnection.getConnection();
		ClientRepository findall = new ClientRepository(conn);
		
		findall.findAll().forEach(System.out::println);
		
		DBConnection.closeConnection();

	}
}
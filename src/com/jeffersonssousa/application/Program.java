package com.jeffersonssousa.application;

import java.sql.Connection;
import java.util.Scanner;

import com.jeffersonssousa.config.connection.DBConnection;
import com.jeffersonssousa.model.entities.Account;
import com.jeffersonssousa.repository.AccountRepository;
import com.jeffersonssousa.repository.ClientRepository;
import com.jeffersonssousa.view.menu.AdministratorView;
import com.jeffersonssousa.view.menu.ClientMenuView;
import com.jeffersonssousa.view.menu.HomeMenuView;
import com.jeffersonssousa.view.util.Screen;

public class Program {
	public static void main(String[] args) {

		Connection conn = DBConnection.getConnection();
		
		Account newAcc = new Account(null, 12345, "Jef123", 6000.0, 1, 1);
		
		AccountRepository rep = new AccountRepository(conn);
		ClientRepository repC = new ClientRepository(conn); 
		
		
		System.out.println("Find By All");
		rep.findAll().forEach(System.out::println);
		System.out.println();
		System.out.println("Find By Id");
		System.out.println(rep.findById(1));
		System.out.println();
		System.out.println("Insert");
		rep.insert(newAcc);
		System.out.println();
		System.out.println("delete");
		rep.delete(3);
		System.out.println();
		System.out.println("update");
		rep.update(newAcc);
		
	}

	public static void testScreen() {
		Scanner sc = new Scanner(System.in);

		int option;

		do {
			Screen.clearScreen();
			option = HomeMenuView.showHomeMenu(sc);

			switch (option) {
			case 1:
				AdministratorView.showAdministratorMenu(sc);
				break;

			case 2:
				ClientMenuView.showClientMenu(sc);
			}

		} while (option != 0);

		Screen.exitTheSystem(sc);
	}
}
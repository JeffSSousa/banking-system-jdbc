package com.jeffersonssousa.application;

import java.sql.Connection;
import java.time.Instant;
import java.util.Scanner;

import com.jeffersonssousa.config.connection.DBConnection;
import com.jeffersonssousa.model.entities.Transaction;
import com.jeffersonssousa.model.entities.transactions.BankTransfer;
import com.jeffersonssousa.model.enums.TypeTransaction;
import com.jeffersonssousa.repository.AccountRepository;
import com.jeffersonssousa.repository.TransactionRepository;
import com.jeffersonssousa.view.menu.AdministratorView;
import com.jeffersonssousa.view.menu.ClientMenuView;
import com.jeffersonssousa.view.menu.HomeMenuView;
import com.jeffersonssousa.view.util.Screen;

public class Program {
	public static void main(String[] args) {

		Connection conn = DBConnection.getConnection();
		TransactionRepository t = new TransactionRepository(conn);
		AccountRepository a = new AccountRepository(conn);

		Transaction transfer = new BankTransfer(null, 1000.0, Instant.now(), a.findById(1), a.findById(1), TypeTransaction.valueOf(3));

		System.out.println("Insert");
		t.insert(transfer);
		System.out.println();
		System.out.println("Update");
		//t.update(transfer);
		System.out.println();
		System.out.println("delete");
		t.delete(4);
		System.out.println();
		System.out.println("id");
		System.out.println(t.findById(5));
		System.out.println();
		System.out.println("all");
		t.findAll().forEach(System.out::println);
		

		DBConnection.closeConnection();

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
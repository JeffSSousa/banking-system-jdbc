package com.jeffersonssousa.application;

import java.time.Instant;
import java.util.Scanner;

import com.jeffersonssousa.model.entities.Account;
import com.jeffersonssousa.model.entities.Transaction;
import com.jeffersonssousa.model.entities.transactions.BankTransfer;
import com.jeffersonssousa.view.menu.AdministratorView;
import com.jeffersonssousa.view.menu.ClientMenuView;
import com.jeffersonssousa.view.menu.HomeMenuView;
import com.jeffersonssousa.view.util.Screen;

public class Program {
	public static void main(String[] args) {

		Transaction trasfer = new BankTransfer(null, 1000.0, Instant.now(), new Account(), new Account(), 3);
		
		System.out.println(trasfer.getTypeTransaction());
		
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
package com.jeffersonssousa.view.menu.client;

import java.util.Scanner;

import com.jeffersonssousa.model.entities.Account;
import com.jeffersonssousa.model.entities.Client;
import com.jeffersonssousa.model.enums.TypeAccount;
import com.jeffersonssousa.view.util.Screen;

public class CheckBalance {

	public static int show(Scanner sc, Account account, Client client) {
		System.out.println("=== SALDO DISPONÍVEL ===");
		System.out.println("Nome do Cliente: " + client.getFirstName() + " " + client.getLastName());
		System.out.println("Conta: " + account.getAccountNumber() + " - " + TypeAccount.valueOf(account.getTypeAccountId()));
		System.out.printf("Saldo Atual: R$ %.2f\n", account.getBalance());
		
		System.out.println();
		Screen.showReturnToMenu(1);

		return sc.nextInt();
	}
	
	public static void startNavigation(Scanner sc, Account account, Client client) {
		int option = 0;

		do {
			Screen.clearScreen();
			Screen.notifyInvalidOption(1, option);

			option = show(sc, account, client);

			switch (option) {
			case 1:
				Screen.showReturningToMenu();
				break;
			}

		} while (option != 1);
	}

}

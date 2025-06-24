package com.jeffersonssousa.view.menu.client;

import java.util.Scanner;

import com.jeffersonssousa.model.entities.Account;
import com.jeffersonssousa.model.entities.Client;
import com.jeffersonssousa.model.enums.TypeAccount;
import com.jeffersonssousa.view.util.Screen;

public class AccountDetailsView {
	
	public static int showDetails(Scanner sc, Account account, Client client) {
		
		
		System.out.println("=== DADOS DA CONTA ===");
		System.out.println("Nome: " + client.getFirstName() + " " + client.getLastName());
		System.out.println("Email: " + client.getEmail());
		System.out.println("CPF: " + client.getCpf());
		System.out.println("Data de Nascimento: " + Screen.formatLocalDate(client.getBirthDate()));
		System.out.println();
		System.out.println("Numero da Conta: " + account.getAccountNumber());
		System.out.println("Tipo da Conta: " + TypeAccount.valueOf(account.getTypeAccountId()));
		
		System.out.println();
		Screen.showReturnToMenu("Cliente");
		
		return sc.nextInt();
	}
	
	public static void startNavigation(Scanner sc, Account account, Client client) {
		int option = 0;

		do {
			Screen.clearScreen();
			Screen.notifyInvalidOption(1, option);

			option = showDetails(sc, account, client);

			switch (option) {
			case 1:
				Screen.showReturningToMenu();
				break;
			}

		} while (option != 1);
	}

}

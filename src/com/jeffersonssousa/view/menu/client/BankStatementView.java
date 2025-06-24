package com.jeffersonssousa.view.menu.client;

import java.util.Scanner;

import com.jeffersonssousa.model.entities.Account;
import com.jeffersonssousa.view.menu.client.subviews.TransactionsStatement;
import com.jeffersonssousa.view.util.Screen;

public class BankStatementView {

	public static int showBankStatement(Scanner sc, Account account){
		
		System.out.println("=== EXTRATO DA CONTA " + account.getAccountNumber() + " ===");
		System.out.println();
		System.out.println("1. Extratos das Transferencias Bancarias");
		System.out.println("2. Extratos dos Saques/Depositos");
		
		//System.out.println("[13/06/2025 12:45] DEPÓSITO: R$ 300,00       Saldo após: R$ 5.049,00");
		//System.out.println("[11/06/2025 10:05] SAQUE: R$ 100,00          Saldo após: R$ 4.900,00");
		
		
		System.out.println();
		Screen.showReturnToMenu("Cliente");
		
		return sc.nextInt();
	}
	
	public static void startNavigation(Scanner sc, Account account) {
		int option = 0;

		do {
			Screen.clearScreen();
			Screen.notifyInvalidOption(3, option);

			option = showBankStatement(sc, account);

			switch (option) {
			case 1:
				TransactionsStatement.startNavigation(sc, account);
				break;
			case 2:
				System.out.println("Extratos de deposito");
				break;
			case 3:
				Screen.showReturningToMenu();
				break;
			}

		} while (option != 3);
	}
	
}

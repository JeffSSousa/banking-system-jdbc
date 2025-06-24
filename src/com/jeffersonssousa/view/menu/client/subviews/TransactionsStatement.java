package com.jeffersonssousa.view.menu.client.subviews;

import java.util.Scanner;

import com.jeffersonssousa.controller.TransactionController;
import com.jeffersonssousa.model.entities.Account;
import com.jeffersonssousa.view.util.Screen;

public class TransactionsStatement {

	public static int showBankStatement(Scanner sc, Account account) {
		TransactionController controller = new TransactionController();
		
		System.out.println("=== EXTRATOS DE TRANFERENCIAS DA CONTA " + account.getAccountNumber() + " ===");
		System.out.println();
		
		controller.showBankStatement(account.getId());

		System.out.println();
		Screen.showReturnToMenu(1);

		return sc.nextInt();
	}

	public static void startNavigation(Scanner sc, Account account) {
		int option = 0;

		do {
			Screen.clearScreen();
			Screen.notifyInvalidOption(1, option);

			option = showBankStatement(sc, account);

			switch (option) {
			case 1:
				Screen.showReturningToMenu();
				break;
			}

		} while (option != 1);
	}
}

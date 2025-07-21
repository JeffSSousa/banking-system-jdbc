package com.jeffersonssousa.view.menu.adm.subviews;

import java.util.Scanner;

import com.jeffersonssousa.controller.AdmController;
import com.jeffersonssousa.view.util.Screen;

public class FindAccountByAccountNumber {
	
	public static int showAccount(Scanner sc, Integer accountNumber) {
		AdmController admController = new AdmController();

		System.out.println("======== RELATORIO DE BUSCA ===========");
		System.out.println("====== BUSCA POR:  " + accountNumber + " ========");
		System.out.println();

		admController.showAccountByAccountNumber(accountNumber);

		Screen.showReturnToMenu(1);

		return sc.nextInt();
	}

	public static void startNavigation(Scanner sc) {
		int option = 0;

		sc.nextLine();

		do {
			Screen.clearScreen();
			Screen.notifyInvalidOption(1, option);

			System.out.print("Digite o Numero da Conta: ");
			int number = sc.nextInt();

			option = showAccount(sc, number);

			switch (option) {
			case 1:
				Screen.showReturningToMenu();
				break;
			}

		} while (option != 1);
	}

}

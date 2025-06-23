package com.jeffersonssousa.view.menu.client;

import java.util.Scanner;

import com.jeffersonssousa.view.util.Screen;

public class DepositValueView {
	
	public static int amountDeposited(Scanner sc) {
		//Em processo de desenvolvimento !!!!!
		
		System.out.println("=== DEPÓSITO ===");
		System.out.println("Valor depositado: R$ 200,00");
		System.out.println("Depósito realizado com sucesso!");
		System.out.println();
		System.out.println("Novo saldo: R$ 5.450,75");
		
		System.out.println();
		Screen.showReturnToMenu("Cliente");
		
		return sc.nextInt();
	}

	public static void startNavigation(Scanner sc) {
		int option = 0;

		do {
			Screen.clearScreen();
			Screen.notifyInvalidOption(1, option);

			option = amountDeposited(sc);

			switch (option) {
			case 1:
				Screen.showReturningToMenu();
				break;
			}

		} while (option != 1);
	}
}

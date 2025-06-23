package com.jeffersonssousa.view.menu.client;

import java.util.Scanner;

import com.jeffersonssousa.view.util.Screen;

public class WithdrawValueView {
	
	public static int amountWithdrawn(Scanner sc) {
		// em processo de desenvolvimento !!!!!
		
		System.out.println("=== SAQUE ===");
		System.out.println("Valor sacado: R$ 300,00");
		System.out.println("Saque realizado com sucesso!");
		System.out.println();
		System.out.println("Novo saldo: R$ 5.150,75");
		
		System.out.println();
		Screen.showReturnToMenu("Cliente");
		
		return sc.nextInt();
	}
	
	public static void startNavigation(Scanner sc) {
		int option = 0;

		do {
			Screen.clearScreen();
			Screen.notifyInvalidOption(1, option);

			option = amountWithdrawn(sc);

			switch (option) {
			case 1:
				Screen.showReturningToMenu();
				break;
			}

		} while (option != 1);
	}

}

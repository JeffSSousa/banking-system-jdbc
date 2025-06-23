package com.jeffersonssousa.view.menu.client;

import java.util.Scanner;

import com.jeffersonssousa.view.util.Screen;

public class CheckBalance {

	public static int show(Scanner sc) {
		System.out.println("=== SALDO DISPONÍVEL ===");
		System.out.println("Nome do Cliente: Jefferson Sousa");
		System.out.println("Conta: 12345-6 - CONTA CORRENTE");
		System.out.println("Saldo Atual: R$ 5.250,75");
		
		System.out.println();
		Screen.showReturnToMenu("Cliente");

		return sc.nextInt();
	}
	
	public static void startNavigation(Scanner sc) {
		int option = 0;

		do {
			Screen.clearScreen();
			Screen.notifyInvalidOption(1, option);

			option = show(sc);

			switch (option) {
			case 1:
				Screen.showReturningToMenu();
				break;
			}

		} while (option != 1);
	}

}

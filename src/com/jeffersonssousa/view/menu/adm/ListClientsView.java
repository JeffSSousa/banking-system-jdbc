package com.jeffersonssousa.view.menu.adm;

import java.util.Scanner;

import com.jeffersonssousa.view.util.Screen;

public class ListClientsView {

	public static int showClients(Scanner sc) {

		System.out.println("======== RELATORIO DE TODOS OS CLIENTES ===========");
		System.out.println();

		for (int i = 0; i < 10; i++) {
			System.out.println("ID: 1 - " + "Name: Ana Silva, idade: 56 anos");
			System.out.println("cpf: 452.xxx.xxx-xx - email: ana.silva@gmail.com");
			System.out.println("data de nascimento: 1990-05-14");
			System.out.println();
			System.out.println("------------------------------------------------");
			System.out.println();
		}

		Screen.showReturnToMenu(1);

		return sc.nextInt();
	}

	public static void startNavigation(Scanner sc) {
		int option = 0;

		do {
			Screen.clearScreen();
			Screen.notifyInvalidOption(1, option);

			option = showClients(sc);

			switch (option) {
			case 1:
				Screen.showReturningToMenu();
				break;
			}

		} while (option != 1);
	}

}

package com.jeffersonssousa.view.menu.adm.subviews;

import java.util.Scanner;

import com.jeffersonssousa.controller.AdmController;
import com.jeffersonssousa.view.util.Screen;

public class FindClientByEmail {

	public static int showClients(Scanner sc, String email) {
		AdmController admController = new AdmController();

		System.out.println("======== RELATORIO DE BUSCA ===========");
		System.out.println("====== BUSCA POR:  " + email + " ========");
		System.out.println();

		admController.showClientByEmail(email);

		Screen.showReturnToMenu(1);

		return sc.nextInt();
	}

	public static void startNavigation(Scanner sc) {
		int option = 0;

		sc.nextLine();

		do {
			Screen.clearScreen();
			Screen.notifyInvalidOption(1, option);

			System.out.print("Digite o Email que Deseja Pesquisar: ");
			String email = sc.nextLine();

			option = showClients(sc, email);

			switch (option) {
			case 1:
				Screen.showReturningToMenu();
				break;
			}

		} while (option != 1);
	}
	
}

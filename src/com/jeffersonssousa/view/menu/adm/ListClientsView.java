package com.jeffersonssousa.view.menu.adm;

import java.util.Scanner;

import com.jeffersonssousa.controller.ClientController;
import com.jeffersonssousa.view.util.Screen;

public class ListClientsView {

	public static int showClients(Scanner sc) {
		ClientController controller = new ClientController();
		
		System.out.println("======== RELATORIO DE TODOS OS CLIENTES ===========");
		System.out.println();

		controller.showAllClients();
		

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

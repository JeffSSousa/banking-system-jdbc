package com.jeffersonssousa.view.menu.access;

import java.util.Scanner;

import com.jeffersonssousa.view.menu.access.client.ClientLoginView;
import com.jeffersonssousa.view.menu.access.client.RegistrationView;
import com.jeffersonssousa.view.util.Screen;

public class ClientAccessView {

	public static int showHomeMenu(Scanner sc) {
		System.out.println("====== MENU CLIENTE =======");
		System.out.println();
		System.out.println("1. Acessar conta existente.");
		System.out.println("2. Criar nova conta.");
		System.out.println("3. Sair.");
		
		System.out.println();
		System.out.print("Informe a opção desejada: ");
		
		return sc.nextInt();
	}
	
	
	public static void startNavigation(Scanner sc) {
		int option = 0;

		do {
			Screen.clearScreen();
			Screen.notifyInvalidOption(3, option);

			option = showHomeMenu(sc);

			switch (option) {
			case 1:
				ClientLoginView.startNavigation(sc);
				option = 3;
				break;
			case 2:
				RegistrationView.startNavigation(sc);
				option = 3;
				break;
			}

		} while (option != 3);
	}
}

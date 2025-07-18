package com.jeffersonssousa.view.menu;

import java.util.Scanner;

import com.jeffersonssousa.model.entities.Employee;
import com.jeffersonssousa.view.menu.adm.DeleteAccessView;
import com.jeffersonssousa.view.menu.adm.FindAccessView;
import com.jeffersonssousa.view.menu.adm.ListAccountsView;
import com.jeffersonssousa.view.menu.adm.ListClientsView;
import com.jeffersonssousa.view.util.Screen;

public class AdministratorMenuView {

	public static int showAdministratorMenu(Scanner sc) {
		System.out.println("=== MENU ADMINISTRADOR ===");
		System.out.println("1. Listar todos os clientes");
		System.out.println("2. Listar todas as contas");
		System.out.println("3. Apagar Acesso");
		System.out.println("4. Procurar Cliente/Conta");
		System.out.println("5. Sair");

		System.out.println();
		System.out.print("Informe a opção desejada:");
		
		return sc.nextInt();
	}

	public static void startNavigation(Scanner sc, Employee employee) {
		int option = 0;

		do {
			Screen.clearScreen();
			Screen.notifyInvalidOption(5, option);

			option = showAdministratorMenu(sc);

			switch (option) {
			case 1:
				ListClientsView.startNavigation(sc);
				break;
			case 2:
				ListAccountsView.startNavigation(sc);
				break;
			case 3:
				DeleteAccessView.startNavigation(sc);
				break;
			case 4:
				FindAccessView.startNavigation(sc);
				break;
			}

		} while (option != 5);
	}

}

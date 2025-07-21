package com.jeffersonssousa.view.menu.adm.subviews;

import java.util.Scanner;

import com.jeffersonssousa.controller.AdmController;
import com.jeffersonssousa.view.util.Screen;

public class FindAccountByCpfClient {

	public static int showAccounts(Scanner sc, String cpf) {
		AdmController admController = new AdmController();

		System.out.println("======== RELATORIO DE BUSCA ===========");
		System.out.println("====== BUSCA POR CPF:  " + cpf + " ========");
		System.out.println();

		admController.showAccountByClientCpf(cpf);

		Screen.showReturnToMenu(1);

		return sc.nextInt();
	}

	public static void startNavigation(Scanner sc) {
		int option = 0;

		sc.nextLine();

		do {
			Screen.clearScreen();
			Screen.notifyInvalidOption(1, option);

			System.out.print("Digite o CPF que Deseja Pesquisar: ");
			String cpf = sc.nextLine();

			option = showAccounts(sc, cpf);

			switch (option) {
			case 1:
				Screen.showReturningToMenu();
				break;
			}

		} while (option != 1);
	}


}

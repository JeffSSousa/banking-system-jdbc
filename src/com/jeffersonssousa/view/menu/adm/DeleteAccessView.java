package com.jeffersonssousa.view.menu.adm;

import java.util.Scanner;

import com.jeffersonssousa.controller.AdmController;
import com.jeffersonssousa.view.util.Screen;

public class DeleteAccessView {

	public static int showDeleteMenu(Scanner sc) {

		System.out.println("=========================================");
		System.out.println("       MENU DE EXCLUSÃO DE REGISTROS     ");
		System.out.println("=========================================");

		System.out.println("1. Continuar com a Exclusão.");

		Screen.showReturnToMenu(2);

		return sc.nextInt();
	}

	public static void startNavigation(Scanner sc) {
		int option = 0;

		Screen.clearScreen();
		Screen.notifyInvalidOption(2, option);

		option = showDeleteMenu(sc);

		do {
			switch (option) {
			case 1:
				option = startDelete(option, sc);
				break;
			case 2:
				Screen.clearScreen();
				Screen.showReturningToMenu();
				Screen.timeSleep(1000);
				break;
			}
		} while (option != 2);
	}

	private static int startDelete(Integer option, Scanner sc) {
		AdmController admController = new AdmController();

		boolean validate = false;

		sc.nextLine();

		do {
			Screen.clearScreen();

			System.out.print("Digite o CPF do Cliente que deseja encerrar seu vinculo com o banco: ");
			String cpf = sc.nextLine();

			do {
				System.out.println("Deseja Continuar com o Encerramento dessa conta ?");
				System.out.print("Digite Sim ou Não: ");
				String resp = sc.nextLine();

				if (resp.equalsIgnoreCase("Sim")) {
					option = 2;
					admController.showDeleteClient(cpf, sc);
					validate = true;

				} else if (resp.equalsIgnoreCase("não") || resp.equalsIgnoreCase("nao")) {
					option = 2;
					validate = true;
					Screen.showReturningToMenu();
				} else {
					Screen.clearScreen();
					System.out.println("Resposta erra tente novamente!!");
					Screen.timeSleep(1000);
				}
			} while (validate != true);

		} while (option != 2);

		return option;
	}

}

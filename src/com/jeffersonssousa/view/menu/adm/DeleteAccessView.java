package com.jeffersonssousa.view.menu.adm;

import java.util.Scanner;

import com.jeffersonssousa.view.util.Screen;

public class DeleteAccessView {

	public static int showDeleteMenu(Scanner sc) {

		System.out.println("=========================================");
		System.out.println("       MENU DE EXCLUSÃO DE REGISTROS     ");
		System.out.println("=========================================");
		System.out.println("1. Encerrar Conta Bancária (por número da conta)");
		System.out.println("2. Excluir Cliente e Contas Bancarias vinculadas(por CPF)");
		System.out.println();
		System.out.print("Informe a opção desejada: ");

		return sc.nextInt();
	}

	public static void startNavigation(Scanner sc) {
		int option = 0;

		do {
			Screen.clearScreen();
			Screen.notifyInvalidOption(2, option);

			option = showDeleteMenu(sc);

			switch (option) {
			case 1:
				System.out.println("Conta Excluida");  // criar class view com validação
				break;
			case 2:
				System.out.println("Cliente Excluido"); // criar class view com validação
				break;
			}

		} while (option != 0);
	}

	
}

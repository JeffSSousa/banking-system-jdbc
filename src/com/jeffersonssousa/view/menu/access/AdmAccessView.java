package com.jeffersonssousa.view.menu.access;

import java.util.Scanner;

import com.jeffersonssousa.view.util.Screen;

public class AdmAccessView {
	
	public static int showHomeMenu(Scanner sc) {
		System.out.println("====== MENU DO COLABORADOR =======");
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
				System.out.println("AdmLoginView");
				option = 3;
				break;
			case 2:
				System.out.println("AdmRegistrationView");
				option = 3;
				break;
			}

		} while (option != 3);
	}

}

package com.jeffersonssousa.view.menu.access;

import java.util.Scanner;

import com.jeffersonssousa.view.util.Screen;

public class LoginView {

	
	
	public static int showLogin(Scanner sc) {
		System.out.println("===================================");
		System.out.println("          LOGIN DO CLIENTE        ");
		System.out.println("===================================");

		System.out.print("CPF: ");
		String cpf = sc.nextLine();

		//System.out.print("Senha: ");
		//String senha = sc.nextLine();
		
		System.out.println();
		Screen.showReturnToMenu("Cliente");

		return sc.nextInt();
	}

	public static void startNavigation(Scanner sc) {
		int option = 0;

		do {
			Screen.clearScreen();
			Screen.notifyInvalidOption(1, option);

			option = showLogin(sc);

			switch (option) {
			case 1:
				Screen.showReturningToMenu();
				break;
			}

		} while (option != 1);
	}

}

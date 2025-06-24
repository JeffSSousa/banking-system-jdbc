package com.jeffersonssousa.view.menu.adm;

import java.util.Scanner;

import com.jeffersonssousa.view.util.Screen;

public class FindAccessView {
	
	public static int showAccessView(Scanner sc) {

		System.out.println("=========================================");
		System.out.println("       MENU DE BUSCA PERSONALIZADA  ");
		System.out.println("=========================================");
		System.out.println("1. Buscar Clientes por Nome: ");
		System.out.println("2. Buscar Cliente por cpf: ");
		System.out.println("3. Buscar Cliente por email: ");
		System.out.println("4. Buscar Conta por numero da conta: ");
		System.out.println("5. Buscar Conta por cpf do cliente: ");
		
		System.out.println();
		Screen.showReturnToMenu(6);

		return sc.nextInt();
	}
	
	
	public static void startNavigation(Scanner sc) {
		int option = 0;

		do {
			Screen.clearScreen();
			Screen.notifyInvalidOption(6, option);

			option = showAccessView(sc);

			switch (option) {
			case 1:
				System.out.println("Encontrado");  // criar class view 
				break;
			case 2:
				System.out.println("Encontrado"); // criar class view 
				break;
			case 3:
				System.out.println("Encontrado"); // criar class view 
				break;
			case 4:
				System.out.println("Encontrado"); // criar class view 
				break;
			case 5:
				System.out.println("Encontrado"); // criar class view 
				break;
			case 6:
				System.out.println("Encontrado"); // criar class view 
				break;
			}

		} while (option != 6);
	}

}

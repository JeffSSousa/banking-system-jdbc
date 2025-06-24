package com.jeffersonssousa.view.menu.adm;

import java.util.Scanner;

import com.jeffersonssousa.view.util.Screen;

public class ListAccountsView {
	
	public static int showAccounts(Scanner sc) {
		
		System.out.println("======== RELATORIO DE TODOS AS CONTAS ===========");
		System.out.println();
		
		for(int i =0 ; i<10 ; i++) {
			System.out.println("ID: 1 - " + "Numero da conta: 15489-6" );
			System.out.println("Saldo Atual: R$ 54,00 - CONTA CORRENTE");
			System.out.println("Cliente : Ana Silva - ID: ");
			System.out.println();
			System.out.println("------------------------------------------------");
			System.out.println();
		}
		
		Screen.showReturnToMenu(1);
		
		return sc.nextInt();
	}
	
	public static void startNavigation(Scanner sc) {
		int option = 0;

		do {
			Screen.clearScreen();
			Screen.notifyInvalidOption(1, option);

			option = showAccounts(sc);

			switch (option) {
			case 1:
				Screen.showReturningToMenu();
				break;
			}

		} while (option != 1);
	}

}

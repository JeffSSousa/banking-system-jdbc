package com.jeffersonssousa.view.menu.adm;

import java.util.Scanner;

import com.jeffersonssousa.controller.AdmController;
import com.jeffersonssousa.view.util.Screen;

public class ListAccountsView {
	
	public static int showAccounts(Scanner sc) {
		AdmController controller = new AdmController();
		
		System.out.println("======== RELATORIO DE TODOS AS CONTAS ===========");
		System.out.println();
		
		controller.showAllAccounts();
		
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

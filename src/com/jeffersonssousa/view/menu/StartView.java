package com.jeffersonssousa.view.menu;

import java.util.Scanner;

import com.jeffersonssousa.view.menu.access.AdmAccessView;
import com.jeffersonssousa.view.menu.access.ClientAccessView;
import com.jeffersonssousa.view.util.Screen;

public class StartView {
	
	public static int showHomeMenu(Scanner sc) {
		System.out.println("====== BEM VINDO AO CODEBANK =====");
		System.out.println("=== Um Banco Digital para Você ===");
		System.out.println();
		System.out.println("1. Sou Cliente.");
		System.out.println("2. Sou Colaborador.");
		System.out.println("3. Sair.");
		
		System.out.println();
		System.out.print("Informe a opção desejada: ");
		
		return sc.nextInt();
	}

	
	public static void startNavigation(Scanner sc) {
		int option = 0;

		do {
			Screen.notifyInvalidOption(3, option);

			option = showHomeMenu(sc);

			switch (option) {
			case 1:
				ClientAccessView.startNavigation(sc);
				break;
			case 2:
				AdmAccessView.startNavigation(sc);
				break;
			}

		} while (option != 3);
	}
}

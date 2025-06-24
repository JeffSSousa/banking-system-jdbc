package com.jeffersonssousa.view.menu.access.client;

import java.util.Scanner;

import com.jeffersonssousa.view.util.Screen;

public class RegistrationView {

	  public static int showRegistrationScreen(Scanner sc) {
	        System.out.println("===================================");
	        System.out.println("         CADASTRO DE CLIENTE       ");
	        System.out.println("===================================");
	        
	        System.out.println();
			Screen.showReturnToMenu(1);
	        
	        return sc.nextInt();
	  }
	  
	  public static void startNavigation(Scanner sc) {
			int option = 0;

			do {
				Screen.clearScreen();
				Screen.notifyInvalidOption(1, option);

				option = showRegistrationScreen(sc);

				switch (option) {
				case 1:
					Screen.showReturningToMenu();
					break;
				}

			} while (option != 1);
		}
	
}

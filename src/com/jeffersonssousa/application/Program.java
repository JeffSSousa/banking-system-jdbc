package com.jeffersonssousa.application;

import java.util.Scanner;

import com.jeffersonssousa.view.menu.ClientMenuView;
import com.jeffersonssousa.view.menu.adm.ListClients;
import com.jeffersonssousa.view.util.Screen;

public class Program {
	public static void main(String[] args) {

		ListClients.showClients(new Scanner(System.in));
		
		//testScreen();
	}

	public static void testScreen() {
		Scanner sc = new Scanner(System.in);
		try {
			ClientMenuView.startNavigation(sc);
		} finally {
			Screen.exitTheSystem(sc);
		}
	}
}

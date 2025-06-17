package com.jeffersonssousa.application;

import java.util.Scanner;

import com.jeffersonssousa.view.menu.AdministratorView;
import com.jeffersonssousa.view.menu.HomeMenuView;

public class Program {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int option ;

		do {
			option = HomeMenuView.showHomeMenu(sc);
			switch (option) {
			case 1:
				AdministratorView.showAdministratorMenu(sc);
				break;

			case 0:
				System.out.println("Saindo...");
			}

		} while (option != 0);

		sc.close();
	}
}
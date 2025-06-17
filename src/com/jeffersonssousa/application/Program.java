package com.jeffersonssousa.application;

import java.util.Scanner;

import com.jeffersonssousa.repository.DaoFactory;
import com.jeffersonssousa.view.menu.AdministratorView;
import com.jeffersonssousa.view.menu.ClientMenuView;
import com.jeffersonssousa.view.menu.HomeMenuView;
import com.jeffersonssousa.view.menu.client.AccountDetailsView;
import com.jeffersonssousa.view.menu.client.CheckBalance;
import com.jeffersonssousa.view.menu.client.DepositValueView;
import com.jeffersonssousa.view.menu.client.WithdrawValueView;
import com.jeffersonssousa.view.util.Screen;

public class Program {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		WithdrawValueView.amountWithdrawn(sc);

		sc.close();
	}

	public static void testScreen() {
		Scanner sc = new Scanner(System.in);

		int option;

		do {
			Screen.clearScreen();
			option = HomeMenuView.showHomeMenu(sc);

			switch (option) {
			case 1:
				AdministratorView.showAdministratorMenu(sc);
				break;

			case 2:
				ClientMenuView.showClientMenu(sc);
			}

		} while (option != 0);

		Screen.exitTheSystem(sc);
	}
}
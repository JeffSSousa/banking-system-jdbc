package com.jeffersonssousa.view.menu;

import java.util.Scanner;

import com.jeffersonssousa.view.menu.client.AccountDetailsView;
import com.jeffersonssousa.view.menu.client.BankStatementView;
import com.jeffersonssousa.view.menu.client.CheckBalance;
import com.jeffersonssousa.view.menu.client.DepositValueView;
import com.jeffersonssousa.view.menu.client.TransferView;
import com.jeffersonssousa.view.menu.client.WithdrawValueView;
import com.jeffersonssousa.view.util.Screen;

public class ClientMenuView {

	public static int showClientMenu(Scanner sc) {
		System.out.println("=== MENU CLIENTE ===");
		System.out.println("1. Ver dados da conta");
		System.out.println("2. Consultar saldo");
		System.out.println("3. Depositar valor");
		System.out.println("4. Sacar valor");
		System.out.println("5. Transferir para outra conta");
		System.out.println("6. Ver extrato");
		System.out.println("0. Sair da Conta");
		System.out.println();
		System.out.print("Digite: ");

		return sc.nextInt();
	}

	public static void startNavigation(Scanner sc) {
		int option = 0;

		do {
			Screen.clearScreen();
			Screen.notifyInvalidOption(6, option);
			
			option = showClientMenu(sc);

			switch (option) {
			case 1:
				AccountDetailsView.showDetails(sc);
				break;
			case 2:
				CheckBalance.show(sc);
				break;
			case 3:
				DepositValueView.amountDeposited(sc);
				break;
			case 4:
				WithdrawValueView.amountWithdrawn(sc);
				break;
			case 5:
				TransferView.transferCompleted(sc);
				break;
			case 6:
				BankStatementView.showBankStatement(sc);
				break;
			}

		} while (option != 0);
	}

}

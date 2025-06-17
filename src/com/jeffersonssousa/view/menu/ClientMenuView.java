package com.jeffersonssousa.view.menu;

import java.util.Scanner;

public class ClientMenuView {

	public static int showClientMenu(Scanner sc) {
		System.out.println("=== MENU CLIENTE ===");
		System.out.println("1. Ver dados da conta");
		System.out.println("2. Consultar saldo");
		System.out.println("3. Depositar valor");
		System.out.println("4. Sacar valor");
		System.out.println("5. Transferir para outra conta");
		System.out.println("6. Ver extrato");
		System.out.println("0. Sair");

		return sc.nextInt();
	}
}

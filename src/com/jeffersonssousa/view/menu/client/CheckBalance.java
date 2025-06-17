package com.jeffersonssousa.view.menu.client;

import java.util.Scanner;

public class CheckBalance {

	public static int show(Scanner sc) {
		System.out.println("=== SALDO DISPONÍVEL ===");
		System.out.println("Nome do Cliente: Jefferson Sousa");
		System.out.println("Conta: 12345-6");
		System.out.println("Saldo Atual: R$ 5.250,75");

		return sc.nextInt();
	}

}

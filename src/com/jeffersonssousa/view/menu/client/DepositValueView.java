package com.jeffersonssousa.view.menu.client;

import java.util.Scanner;

public class DepositValueView {
	
	public static int amountDeposited(Scanner sc) {
		
		System.out.println("=== DEPÓSITO ===");
		System.out.println("Valor depositado: R$ 200,00");
		System.out.println("Depósito realizado com sucesso!");
		System.out.println();
		System.out.println("Novo saldo: R$ 5.450,75");
		
		return sc.nextInt();
	}

}

package com.jeffersonssousa.view.menu.client;

import java.util.Scanner;

public class AccountDetailsView {
	
	public static int showDetails(Scanner sc) {
		System.out.println("=== DADOS DA CONTA ===");
		System.out.println("Nome: --------");
		System.out.println("Email: fulando@gmail.com");
		System.out.println("CPF: 123.456.789-20");
		System.out.println("Numero da Conta: 12345-6");
		System.out.println("Tipo da Conta: Conta Corrente");
		return sc.nextInt();
	}

}

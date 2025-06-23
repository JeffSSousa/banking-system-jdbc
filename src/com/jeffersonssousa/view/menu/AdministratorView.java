package com.jeffersonssousa.view.menu;

import java.util.Scanner;

public class AdministratorView {

	public static int showAdministratorMenu(Scanner sc) {
		System.out.println("=== MENU ADMINISTRADOR ===");
		System.out.println("1. Listar todos os clientes");
		System.out.println("2. Listar todas as contas");
		System.out.println("3. Apagar Acesso");
		System.out.println("4. Procurar Cliente/Conta");
		System.out.println("5. Sair");

		return sc.nextInt();
	}

}

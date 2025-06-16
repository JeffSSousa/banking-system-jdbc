package com.jeffersonssousa.view.menu;

import java.util.Scanner;

public class HomeMenuView {

	public static int showHomeMenu(Scanner sc) {
		System.out.println("===== Banco Digital ======");
		System.out.println("1. Acessar conta existente.");
		System.out.println("2. Criar nova conta.");
		System.out.println("3. Sair.");
		
		return sc.nextInt();
	}
}

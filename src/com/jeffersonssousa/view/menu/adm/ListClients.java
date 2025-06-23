package com.jeffersonssousa.view.menu.adm;

import java.util.Scanner;

public class ListClients {
	
	public static int showClients(Scanner sc) {
		
		System.out.println("======== RELATORIO DE TODOS OS CLIENTES ===========");
		System.out.println();
		
		for(int i =0 ; i<10 ; i++) {
			System.out.println("ID: 1 - " + "Name: Ana Silva, idade: 56 anos" );
			System.out.println("cpf: 452.xxx.xxx-xx - email: ana.silva@gmail.com");
			System.out.println("data de nascimento: 1990-05-14");
			System.out.println();
			System.out.println("------------------------------------------------");
			System.out.println();
		}
		
		
		return sc.nextInt();
	}

}

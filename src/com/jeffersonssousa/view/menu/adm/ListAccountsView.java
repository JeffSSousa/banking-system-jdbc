package com.jeffersonssousa.view.menu.adm;

import java.util.Scanner;

public class ListAccountsView {
	
	public static int showAccounts(Scanner sc) {
		
		System.out.println("======== RELATORIO DE TODOS AS CONTAS ===========");
		System.out.println();
		
		for(int i =0 ; i<10 ; i++) {
			System.out.println("ID: 1 - " + "Numero da conta: 15489-6" );
			System.out.println("Saldo Atual: R$ 54,00 - CONTA CORRENTE");
			System.out.println("Cliente : Ana Silva - ID: ");
			System.out.println();
			System.out.println("------------------------------------------------");
			System.out.println();
		}
		
		return sc.nextInt();
	}

}

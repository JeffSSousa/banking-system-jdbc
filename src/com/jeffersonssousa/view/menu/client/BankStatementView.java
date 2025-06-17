package com.jeffersonssousa.view.menu.client;

import java.util.Scanner;

public class BankStatementView {

	public static int showBankStatement(Scanner sc){
		
		System.out.println("=== EXTRATO DA CONTA 12345-6 ===");
		System.out.println();
		System.out.println("[10/06/2025 09:15] DEPÓSITO: R$ 500,00       Saldo após: R$ 5.000,00");
		System.out.println("[11/06/2025 10:05] SAQUE: R$ 100,00          Saldo após: R$ 4.900,00");
		System.out.println("[12/06/2025 14:22] TRANSFERÊNCIA: -R$ 150,00 Para Conta: 54321-0  Saldo após: R$ 4.749,00");
		System.out.println("[13/06/2025 12:45] DEPÓSITO: R$ 300,00       Saldo após: R$ 5.049,00");
		
		System.out.println();
		System.out.println("Total de transações: 4");
		return sc.nextInt();
	}
}

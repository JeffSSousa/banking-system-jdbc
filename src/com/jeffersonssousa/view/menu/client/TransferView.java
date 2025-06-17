package com.jeffersonssousa.view.menu.client;

import java.util.Scanner;

public class TransferView {

	public static int transferCompleted(Scanner sc) {
		
		System.out.println("=== TRANSFERÊNCIA ===");
		System.out.println("Origem: Conta 12345-6");
		System.out.println("Destino: Conta 54321-0");
		System.out.println("Valor transferido: R$ 100,00");
		System.out.println("Taxa aplicada: R$ 1,00");
		System.out.println();
		System.out.println("Transferência realizada com sucesso!");
		System.out.println();
		System.out.println("Novo saldo: R$ 5.049,75");
		
		return sc.nextInt();
	}
	
}

package com.jeffersonssousa.view.menu.client;

import java.util.Scanner;

import com.jeffersonssousa.controller.AccountController;
import com.jeffersonssousa.controller.ClientController;
import com.jeffersonssousa.model.enums.TypeAccount;
import com.jeffersonssousa.view.util.Screen;

public class AccountDetailsView {
	
	public static int showDetails(Scanner sc) {
		
		ClientController client = new ClientController();
		AccountController account = new AccountController();
		
		System.out.println("=== DADOS DA CONTA ===");
		System.out.println("Nome: " + client.viewCustomerData(1).getFirstName() + " " + client.viewCustomerData(1).getLastName());
		System.out.println("Email: " + client.viewCustomerData(1).getEmail());
		System.out.println("CPF: " + client.viewCustomerData(1).getCpf());
		System.out.println("Data de Nascimento: " + Screen.formatLocalDate(client.viewCustomerData(1).getBirthDate()));
		System.out.println();
		System.out.println("Numero da Conta: " + account.viewAccountdetails(1).getAccountNumber());
		System.out.println("Tipo da Conta: " + TypeAccount.valueOf(account.viewAccountdetails(1).getTypeAccountId()));
		return sc.nextInt();
	}

}

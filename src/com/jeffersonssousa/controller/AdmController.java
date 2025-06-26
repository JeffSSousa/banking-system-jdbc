package com.jeffersonssousa.controller;

import com.jeffersonssousa.model.entities.Account;
import com.jeffersonssousa.model.entities.Client;
import com.jeffersonssousa.model.enums.TypeAccount;
import com.jeffersonssousa.services.AccountService;
import com.jeffersonssousa.services.ClientService;

public class AdmController {

	public void showAllAccounts() {
		ClientService clientService = new ClientService();
		AccountService accountService = new AccountService();

		for (Client client : clientService.findAllCLients()) {
			Account account = accountService.findAccountDataByClientID(client.getId());
			System.out.println("Numero da conta: " + account.getAccountNumber());
			System.out.printf("Saldo Altual: R$ %.2f", account.getBalance());
			System.out.println(" - " + TypeAccount.valueOf(account.getTypeAccountId()));
			System.out.println("Client: " + client.getFirstName() + " " + client.getLastName());
			System.out.println();
			System.out.println("-------------------------------------------------------------");
			System.out.println();

		}
	}

}

package com.jeffersonssousa.controller;

import com.jeffersonssousa.model.entities.Account;
import com.jeffersonssousa.model.entities.Client;
import com.jeffersonssousa.services.AccountService;
import com.jeffersonssousa.services.RegisterService;

public class RegisterController {

	private final RegisterService registerService = new RegisterService();
	private final AccountService accountSerivice = new AccountService();

	public int registerClientAndAccount(Client client, Account account) {
		
		try {
			int accountNumber = accountSerivice.generateUniqueAccountNumber();
			account.setAccountNumber(accountNumber);

			registerService.registerClientAndAccount(client, account);

			return 1;

		} catch (Exception e) {
			System.out.println("Erro inesperado: " + e.getMessage());
		}
		return 0;
	}

}

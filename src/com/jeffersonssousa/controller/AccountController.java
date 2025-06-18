package com.jeffersonssousa.controller;

import com.jeffersonssousa.model.entities.Account;
import com.jeffersonssousa.services.AccountService;

public class AccountController {
	private final AccountService service = new AccountService();
	
	public Account viewAccountdetails(int id) {
		return service.findAccountData(id);
	}
}

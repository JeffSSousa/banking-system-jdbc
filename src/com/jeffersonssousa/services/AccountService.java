package com.jeffersonssousa.services;

import com.jeffersonssousa.model.entities.Account;
import com.jeffersonssousa.repository.DaoFactory;

public class AccountService {
	
	public Account findAccountData(int id) {
		Account obj = DaoFactory.createAccountDao().findById(id);
		return obj;
	}

}

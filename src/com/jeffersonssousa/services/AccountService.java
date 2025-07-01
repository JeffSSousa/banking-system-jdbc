package com.jeffersonssousa.services;

import java.util.Random;

import com.jeffersonssousa.model.entities.Account;
import com.jeffersonssousa.repository.DaoFactory;

public class AccountService {

	public Account findAccountData(int id) {
		Account obj = DaoFactory.createAccountDao().findById(id);
		return obj;
	}

	public Account findAccountDataByClientID(int id) {
		Account obj = DaoFactory.createAccountDao().findByClientId(id);
		return obj;
	}

	public int generateUniqueAccountNumber() {
		int accountNumber;
		boolean exists;

		do {
			accountNumber = generateRandomNumber();
			exists = DaoFactory.createAccountDao().existsAccountNumber(accountNumber);
		} while (exists);

		return accountNumber;
	}

	private int generateRandomNumber() {
		Random random = new Random();
		return 10000 + random.nextInt(90000);
	}

}

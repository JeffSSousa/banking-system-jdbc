package com.jeffersonssousa.services;

import java.util.Random;

import com.jeffersonssousa.model.entities.Account;
import com.jeffersonssousa.model.entities.Client;
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

	public Account findAccountDataByAccountNumber(Integer accountNumber) {
		Account obj = DaoFactory.createAccountDao().findByAccountNumber(accountNumber);
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

	public boolean existsAccountNumber(Integer number) {
		return DaoFactory.createAccountDao().existsAccountNumber(number);
	}

	public void deleteAccountAndClientData(Client client, Account account) {
		try {
			DaoFactory.createAccountDao().delete(account.getId());
			DaoFactory.createClientDao().delete(client.getId());

			System.out.println("Cliente do CPF " 
			                   + client.getCpf().substring(0, 3)
			                   + ".XXX.XXX-XX Deletado com Sucesso !!");
			System.out.println("Vinculo com o DigitalBank Encerrado!!");

		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao Encerrar vinculo do cliente com o banco: " + e.getMessage());
		}

	}

}

package com.jeffersonssousa.repository;

import com.jeffersonssousa.config.connection.DBConnection;
import com.jeffersonssousa.model.entities.Account;
import com.jeffersonssousa.model.entities.Client;
import com.jeffersonssousa.model.entities.Transaction;
import com.jeffersonssousa.repository.impl.AccountRepository;
import com.jeffersonssousa.repository.impl.ClientRepository;
import com.jeffersonssousa.repository.impl.TransactionRepository;

public class DaoFactory {

	public static BaseRepository<Account> createAccountDao() {
		return new AccountRepository(DBConnection.getConnection());
	}

	public static BaseRepository<Client> createClientDao() {
		return new ClientRepository(DBConnection.getConnection());
	}

	public static BaseRepository<Transaction> createTransactionDao() {
		return new TransactionRepository(DBConnection.getConnection());
	}

}

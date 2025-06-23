package com.jeffersonssousa.repository;

import com.jeffersonssousa.config.connection.DBConnection;
import com.jeffersonssousa.model.entities.Account;
import com.jeffersonssousa.model.entities.Client;
import com.jeffersonssousa.model.entities.Transaction;
import com.jeffersonssousa.repository.impl.AccountDaoJDBC;
import com.jeffersonssousa.repository.impl.ClientDaoJDBC;
import com.jeffersonssousa.repository.impl.TransactionDaoJDBC;

public class DaoFactory {

	public static BaseRepository<Account> createAccountDao() {
		return new AccountDaoJDBC(DBConnection.getConnection());
	}

	public static BaseRepository<Client> createClientDao() {
		return new ClientDaoJDBC(DBConnection.getConnection());
	}

	public static BaseRepository<Transaction> createTransactionDao() {
		return new TransactionDaoJDBC(DBConnection.getConnection());
	}

}

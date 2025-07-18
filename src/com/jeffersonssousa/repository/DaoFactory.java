package com.jeffersonssousa.repository;

import com.jeffersonssousa.config.connection.DBConnection;
import com.jeffersonssousa.repository.impl.AccountDaoJDBC;
import com.jeffersonssousa.repository.impl.ClientDaoJDBC;
import com.jeffersonssousa.repository.impl.EmployeeDaoJDBC;
import com.jeffersonssousa.repository.impl.TransactionDaoJDBC;

public class DaoFactory {

	public static AccountRepository createAccountDao() {
		return new AccountDaoJDBC(DBConnection.getConnection());
	}

	public static ClientRepository createClientDao() {
		return new ClientDaoJDBC(DBConnection.getConnection());
	}

	public static TransactionRepository createTransactionDao() {
		return new TransactionDaoJDBC(DBConnection.getConnection());
	}
	
	public static EmployeeRepository createEmployeeDao() {
		return new EmployeeDaoJDBC(DBConnection.getConnection());
	}

}

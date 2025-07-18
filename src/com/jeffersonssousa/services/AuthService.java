package com.jeffersonssousa.services;

import com.jeffersonssousa.config.exceptions.DatabaseException;
import com.jeffersonssousa.model.entities.Account;
import com.jeffersonssousa.model.entities.Client;
import com.jeffersonssousa.model.entities.Employee;
import com.jeffersonssousa.repository.DaoFactory;

public class AuthService {

	public Account loginAccount(String cpf, String password) {
		Client client = DaoFactory.createClientDao().findByCpf(cpf);
	    if (client == null) {
	        throw new DatabaseException("Cliente do CPF " + cpf + " não foi encontrado no Banco de Dados!!");
	    }

	    Account account = DaoFactory.createAccountDao().findByClientId(client.getId());
	    if (account == null || !account.getPassword().equals(password)) {
	        throw new RuntimeException("Senha incorreta.");
	    }

	    return account;
	}
	
	public Employee loginEmployee(String cpf, String password) {
		Employee employee = DaoFactory.createEmployeeDao().findBycpf(cpf);
	    if (employee == null) {
	        throw new DatabaseException("Colaborador do CPF " + cpf + " não foi encontrado no Banco de Dados!!");
	    }

	    if (!employee.getPassword().equals(password)) {
	        throw new RuntimeException("Senha incorreta.");
	    }

	    return employee;
	}
	
}

package com.jeffersonssousa.services;

import com.jeffersonssousa.model.entities.Account;
import com.jeffersonssousa.model.entities.Client;
import com.jeffersonssousa.repository.DaoFactory;

public class AuthService {

	public Client authenticateCpf(String cpf) {
		if(DaoFactory.createClientDao().findByCpf(cpf) == null) {
			return null;
		}
		
		return DaoFactory.createClientDao().findByCpf(cpf);
	}

	public Account login(String cpf, String password) {
		Client client = authenticateCpf(cpf);
		int clientId = client.getId();
		
		Account account = DaoFactory.createAccountDao().findByClientId(clientId);
		if (account.getPassword().equals(password)) {
			System.out.println("Login Bem-Sucedido");
		return account;
		} 
		
		System.out.println("Senha Incorreta");
		return null;
	}
}

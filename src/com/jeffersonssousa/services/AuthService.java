package com.jeffersonssousa.services;

import com.jeffersonssousa.model.entities.Account;
import com.jeffersonssousa.model.entities.Client;
import com.jeffersonssousa.repository.DaoFactory;

public class AuthService {

	public boolean authenticateCpf(int id) {
		if(DaoFactory.createClientDao().findById(id) == null) {
			return false;
		}
		
		return true;
	}

	public Account login(int id, String password) {
		Client client = DaoFactory.createClientDao().findById(id);
		int clientId = client.getId();
		
		Account account = DaoFactory.createAccountDao().findById(clientId);
		if (account.getPassword().equals(password)) {
			System.out.println("Login Bem-Sucedido");
		return account;
		} 
		
		System.out.println("Senha Incorreta");
		return null;
	}
}

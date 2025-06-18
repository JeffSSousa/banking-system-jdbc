package com.jeffersonssousa.services;

import com.jeffersonssousa.model.entities.Client;
import com.jeffersonssousa.repository.DaoFactory;

public class ClientService {

	public Client findClientData(int id) {
		Client obj = DaoFactory.createClientDao().findById(id);
		return obj;
	}
	
}

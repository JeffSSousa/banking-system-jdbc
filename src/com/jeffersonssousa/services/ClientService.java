package com.jeffersonssousa.services;

import java.util.List;

import com.jeffersonssousa.model.entities.Client;
import com.jeffersonssousa.repository.DaoFactory;

public class ClientService {

	public Client findClientData(int id) {
		Client obj = DaoFactory.createClientDao().findById(id);
		return obj;
	}
	
	public Client findClientDataByCpf(String cpf) {
		Client obj = DaoFactory.createClientDao().findByCpf(cpf);
		return obj;
	}
	
	public List<Client> findAllCLients(){
		return  DaoFactory.createClientDao().findAll();
	}
	
}

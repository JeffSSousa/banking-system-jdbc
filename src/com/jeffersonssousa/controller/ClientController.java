package com.jeffersonssousa.controller;

import com.jeffersonssousa.model.entities.Client;
import com.jeffersonssousa.services.ClientService;

public class ClientController {
	private final ClientService service = new ClientService();
	
	public Client viewCustomerData(int id) {
		return service.findClientData(id);
	}
	
	public Client viewCustomerDataByCpf(String cpf) {
		return service.findClientDataByCpf(cpf);
	}
}

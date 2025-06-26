package com.jeffersonssousa.controller;

import com.jeffersonssousa.model.entities.Client;
import com.jeffersonssousa.services.ClientService;
import com.jeffersonssousa.view.util.Screen;

public class ClientController {
	private final ClientService service = new ClientService();

	public Client viewCustomerData(int id) {
		return service.findClientData(id);
	}

	public Client viewCustomerDataByCpf(String cpf) {
		return service.findClientDataByCpf(cpf);
	}

	public void showAllClients() {
		ClientService clientService = new ClientService();

		for (Client client : clientService.findAllCLients()) {
			System.out.println("Nome: " + client.getFirstName() 
										+ " " + client.getLastName() 
										+ ", Idade: " + client.getAge() + " Anos");
			System.out.println("CPF: " + client.getCpf() + " - email: " + client.getEmail());
			System.out.println("data de nascimento: " + Screen.formatLocalDate(client.getBirthDate()));
			System.out.println();
			System.out.println("----------------------------------------------------------------------");
			System.out.println();
		}
	}

}

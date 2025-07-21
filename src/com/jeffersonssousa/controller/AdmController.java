package com.jeffersonssousa.controller;

import java.util.List;

import com.jeffersonssousa.model.entities.Account;
import com.jeffersonssousa.model.entities.Client;
import com.jeffersonssousa.model.enums.TypeAccount;
import com.jeffersonssousa.services.AccountService;
import com.jeffersonssousa.services.ClientService;
import com.jeffersonssousa.services.EmployeeService;
import com.jeffersonssousa.view.util.Screen;

public class AdmController {
	private final ClientService clientService = new ClientService();
	private final AccountService accountService = new AccountService();

	public void showAllAccounts() {

		for (Client client : clientService.findAllCLients()) {
			Account account = accountService.findAccountDataByClientID(client.getId());
			showAccount(account, client);
		}
	}

	public void showClientsByName(String name) {
		EmployeeService employeeService = new EmployeeService();
		List<Client> list = employeeService.findClientsByName(name);
		if (list.isEmpty()) {
			System.out.println("Não foi encontrado nenhum cliente com esse nome: " + name);
			System.out.println();
		}
		list.forEach(c -> showClient(c));
	}

	public void showClientsByCpf(String cpf) {
		if (clientService.existsCPF(cpf)) {
			Client client = clientService.findClientDataByCpf(cpf);
			showClient(client);
		} else {
			System.out.println("Esse CPF não Está Cadastrado!!");
			System.out.println();
		}
	}

	public void showClientByEmail(String email) {
		if (clientService.existsEmail(email)) {
			Client client = clientService.findClientDataByEmail(email);
			showClient(client);
		} else {
			System.out.println("Esse Email não Está Cadastrado!!");
			System.out.println();
		}
	}

	public void showAccountByAccountNumber(Integer accountNumber) {
		if (accountService.existsAccountNumber(accountNumber)) {
			Account account = accountService.findAccountDataByAccountNumber(accountNumber);
			Client client = clientService.findClientData(account.getClientId());
			showAccount(account, client);
		} else {
			System.out.println("Esse Numero de Conta não Existe no Banco");
			System.out.println();
		}
	}

	public void showAccountByClientCpf(String cpf) {
		if(clientService.existsCPF(cpf)) {
		Client client = clientService.findClientDataByCpf(cpf);
		Account account = accountService.findAccountDataByClientID(client.getId());
		showAccount(account, client);
		}else {
			System.out.println("Esse CPF não está Cadastrado!!");
			System.out.println();
		}
	}

	private void showClient(Client client) {
		System.out.println("Nome: " + client.getFirstName() + " " + client.getLastName() + ", Idade: " + client.getAge()
				+ " Anos");
		System.out.println("CPF: " + client.getCpf() + " - email: " + client.getEmail());
		System.out.println("data de nascimento: " + Screen.formatLocalDate(client.getBirthDate()));
		System.out.println();
		System.out.println("----------------------------------------------------------------------");
		System.out.println();
	}

	private void showAccount(Account account, Client client) {
		System.out.println("Numero da conta: " + account.getAccountNumber());
		System.out.printf("Saldo Altual: R$ %.2f", account.getBalance());
		System.out.println(" - " + TypeAccount.valueOf(account.getTypeAccountId()));
		System.out.println("Client: " + client.getFirstName() + " " + client.getLastName());
		System.out.println();
		System.out.println("-------------------------------------------------------------");
		System.out.println();
	}

}

package com.jeffersonssousa.controller;

import com.jeffersonssousa.model.entities.Account;
import com.jeffersonssousa.model.entities.Employee;
import com.jeffersonssousa.services.AuthService;

public class LoginController {
	private final AuthService service = new AuthService();


	public Account validateAccount(String cpf, String password) {
		Account account = service.loginAccount(cpf, password);
		
		return account;
	}	
	
	public Employee validateEmployee(String cpf, String password) {
		Employee employee = service.loginEmployee(cpf, password);
		
		return employee;
	}		
}

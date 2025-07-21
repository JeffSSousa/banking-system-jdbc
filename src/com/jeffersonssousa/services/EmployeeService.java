package com.jeffersonssousa.services;

import java.util.List;

import com.jeffersonssousa.model.entities.Client;
import com.jeffersonssousa.model.entities.Employee;
import com.jeffersonssousa.repository.DaoFactory;

public class EmployeeService {

	public Employee findEmployeeDataByCpf(String cpf) {
		return DaoFactory.createEmployeeDao().findBycpf(cpf);
	}
	
	public List<Client> findClientsByName(String name){
		List<Client> list = DaoFactory.createClientDao().findAll();
		
		return list.stream()
				   .filter(c -> c.getFirstName().contains(name))
				   .toList();
	}

}

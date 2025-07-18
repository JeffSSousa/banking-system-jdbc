package com.jeffersonssousa.services;

import com.jeffersonssousa.model.entities.Employee;
import com.jeffersonssousa.repository.DaoFactory;

public class EmployeeService {

	public Employee findEmployeeDataByCpf(String cpf) {
		return DaoFactory.createEmployeeDao().findBycpf(cpf);
	}

}

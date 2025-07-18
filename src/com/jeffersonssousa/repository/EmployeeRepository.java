package com.jeffersonssousa.repository;

import com.jeffersonssousa.model.entities.Employee;

public interface EmployeeRepository {

	Employee findBycpf(String cpf);
	
}

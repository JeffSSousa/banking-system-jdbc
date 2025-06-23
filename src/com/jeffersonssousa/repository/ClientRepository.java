package com.jeffersonssousa.repository;

import java.util.List;

import com.jeffersonssousa.model.entities.Client;

public interface ClientRepository {

	void insert(Client obj);
	void update(Client obj);
	void delete(Integer id);
	Client findById (Integer id);
	Client findByCpf(String cpf);
	List<Client> findAll();
	
}

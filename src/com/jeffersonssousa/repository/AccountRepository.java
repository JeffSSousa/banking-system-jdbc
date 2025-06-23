package com.jeffersonssousa.repository;

import java.util.List;

import com.jeffersonssousa.model.entities.Account;

public interface AccountRepository {
	
	void insert(Account obj);
	void update(Account obj);
	void delete(Integer id);
	Account findById (Integer id);
	Account findByClientId(Integer id);
	List<Account> findAll();

}

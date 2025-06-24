package com.jeffersonssousa.repository;

import java.util.List;

import com.jeffersonssousa.model.entities.Transaction;

public interface TransactionRepository {
	
	void insert(Transaction obj);
	void update(Transaction obj);
	void delete(Integer id);
	Transaction findById (Integer id);
	List<Transaction> findAll();
	List<Transaction> findBySenderId(Integer senderId);
	List<Transaction> findByReceiverId(Integer receiverId);

}

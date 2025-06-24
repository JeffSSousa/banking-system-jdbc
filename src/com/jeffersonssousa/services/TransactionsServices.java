package com.jeffersonssousa.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.jeffersonssousa.model.entities.Transaction;
import com.jeffersonssousa.repository.DaoFactory;

public class TransactionsServices {
	
	public List<Transaction> findTransactionsBySenderId(int id){
		return DaoFactory.createTransactionDao().findBySenderId(id);
	}
	
	public List<Transaction> findTransactionsByReceiverId(int id){
		return DaoFactory.createTransactionDao().findByReceiverId(id);
	}
	
	public List<Transaction> findTransactions(int id){
		List<Transaction> senderList = DaoFactory.createTransactionDao().findBySenderId(id);
		List<Transaction> receiverList = DaoFactory.createTransactionDao().findByReceiverId(id);
		List<Transaction> list = new ArrayList<>(); // desenvolver metodo para a busca no sql
		list.addAll(senderList);
		list.addAll(receiverList);
		
		return list.stream()
			   .sorted(Comparator.comparing(Transaction::getTransactionDate))
			   .collect(Collectors.toList());
	}

}

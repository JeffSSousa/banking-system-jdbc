package com.jeffersonssousa.model.entities.transactions.exception;

public class TransactionErrorException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public TransactionErrorException(String msg) {
		super("Erro na Transação: " + msg);
	}

	
	
}

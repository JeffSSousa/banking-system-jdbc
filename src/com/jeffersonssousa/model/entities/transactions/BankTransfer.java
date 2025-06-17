package com.jeffersonssousa.model.entities.transactions;

import java.time.Instant;

import com.jeffersonssousa.model.entities.Account;
import com.jeffersonssousa.model.entities.Transaction;
import com.jeffersonssousa.model.entities.transactions.exception.TransactionErrorException;
import com.jeffersonssousa.model.enums.TypeTransaction;

public class BankTransfer extends Transaction {
	
	public BankTransfer() {
	}

	public BankTransfer(Integer id, Double amount, Instant transactionDate, Account sender, Account receiver,
			TypeTransaction typeTransaction) {
		super(id, amount, transactionDate, sender, receiver, typeTransaction);
	}

	@Override
	public boolean validate() {
		if (amount > 5000.00) {
			throw new TransactionErrorException("A Transferencia não pode exceder R$ 5.000,00");
		}
		return true;
	}

	@Override
	public Double calculateRate() {
		return amount * 0.01;
	}

}

package com.jeffersonssousa.controller;

import com.jeffersonssousa.model.entities.Account;
import com.jeffersonssousa.model.entities.Transaction;
import com.jeffersonssousa.model.enums.TypeTransaction;
import com.jeffersonssousa.services.AccountService;
import com.jeffersonssousa.services.TransactionsServices;

public class TransactionController {
	
	public void showBankStatement(int id) {
		TransactionsServices transactionService = new TransactionsServices();
		AccountService accountService = new AccountService();
		
		int count = 0;
		for(Transaction transaction: transactionService.findTransactions(id)) {
			Account receiver = accountService.findAccountData(transaction.getReceiver().getId());
			
			System.out.println("[" + transaction.getTransactionDate() + "] "
					           + TypeTransaction.valueOf(transaction.getTypeTransaction().getId())
					           + String.format(": R$ %.2f", transaction.getAmount())
					           + " - Para Conta: " + receiver.getAccountNumber() + "\n");
			count ++;
			
		}
		
		System.out.println();
		System.out.println("Total de transações: " + count);
	}

}

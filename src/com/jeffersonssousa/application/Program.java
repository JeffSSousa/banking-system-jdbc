package com.jeffersonssousa.application;

import java.time.Instant;

import com.jeffersonssousa.model.entities.Account;
import com.jeffersonssousa.model.entities.Transaction;
import com.jeffersonssousa.model.entities.transactions.BankTransfer;
import com.jeffersonssousa.model.enums.TypeTransaction;

public class Program {
	public static void main(String[] args) {

		Transaction trans1 ;
	     
		trans1 = new BankTransfer(null, 7999.9, Instant.now(), new Account(), new Account(), TypeTransaction.TRANSFERIR);

		trans1.applyRate();

		System.out.println(trans1.validate());
		System.out.println(trans1.getTax());
		System.out.println(trans1.getAmount());
	}
}
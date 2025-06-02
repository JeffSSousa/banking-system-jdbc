package com.jeffersonssousa.application;

import java.time.Instant;
import java.time.LocalDate;

import com.jeffersonssousa.model.entities.Account;
import com.jeffersonssousa.model.entities.Client;
import com.jeffersonssousa.model.entities.Transaction;
import com.jeffersonssousa.model.enums.TypeAccount;
import com.jeffersonssousa.model.enums.TypeTransaction;

public class Program {
	public static void main(String[] args) {

		Client client1 = new Client(null, "Lewis", "Hamilton", "125.956.329-15", "lewis@gmail.com",
				LocalDate.parse("1983-05-11"));

		Account ac1 = new Account(null, 2161, "1234567", 5000.0, TypeAccount.CORRENTE, client1);

		Transaction tran = new Transaction(null, 500.0, Instant.now(), ac1, ac1, TypeTransaction.TRANSFERIR);

		System.out.println("====PRINT CLIENTE");
		System.out.println(client1);
		System.out.println();
		System.out.println("====PRINT CONTA");
		System.out.println(ac1);
		System.out.println();
		System.out.println("====Transaction=====");
		System.out.println(tran);
		System.out.println();

	}
}
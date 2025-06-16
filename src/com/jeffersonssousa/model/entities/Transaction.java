package com.jeffersonssousa.model.entities;

import java.time.Instant;
import java.util.Objects;

import com.jeffersonssousa.model.enums.TypeTransaction;

public abstract class Transaction {
	protected Integer id;
	protected Double amount;
	protected Instant transactionDate;

	protected Account sender;
	protected Account receiver;
	protected TypeTransaction typeTransaction;

	protected Double tax;

	public Transaction() {
	}

	public Transaction(Integer id, Double amount, Instant transactionDate, Account sender, Account receiver,
			TypeTransaction typeTransaction) {
		this.id = id;
		this.amount = amount;
		this.transactionDate = transactionDate;
		this.sender = sender;
		this.receiver = receiver;
		this.typeTransaction = typeTransaction;
		calculateRate();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Instant getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Instant transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Account getSender() {
		return sender;
	}

	public void setSender(Account sender) {
		this.sender = sender;
	}

	public Account getReceiver() {
		return receiver;
	}

	public void setReceiver(Account receiver) {
		this.receiver = receiver;
	}

	public TypeTransaction getTypeTransaction() {
		return typeTransaction;
	}

	public void setTypeTransaction(TypeTransaction typeTransaction) {
		this.typeTransaction = typeTransaction;
	}

	public Double getTax() {
		return tax;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", amount=" + amount + ", transactionDate=" + transactionDate + ", sender="
				+ sender + ", receiver=" + receiver + ", typeTransaction=" + typeTransaction + "]";
	}

	public abstract boolean validate();

	public abstract Double calculateRate();

	public void applyRate() {
		this.tax = calculateRate();
	}
}

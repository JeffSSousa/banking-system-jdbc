package com.jeffersonssousa.model.entities;

import java.util.Objects;

import com.jeffersonssousa.model.enums.TypeAccount;

public class Account {
	private Integer id;
	private Integer accountNumber;
	private String password;
	private Double balance;

	private TypeAccount typeAccount;
	private Client client;

	public Account() {
	}

	public Account(Integer id, Integer accountNumber, String password, Double balance, TypeAccount typeAccount,
			Client client) {
		this.id = id;
		this.accountNumber = accountNumber;
		this.password = password;
		this.balance = balance;
		this.typeAccount = typeAccount;
		this.client = client;
	}

	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public TypeAccount getTypeAccount() {
		return typeAccount;
	}

	public void setTypeAccount(TypeAccount typeAccount) {
		this.typeAccount = typeAccount;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(accountNumber, other.accountNumber);
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountNumber=" + accountNumber + ", password=" + password + ", balance="
				+ balance + ", typeAccount=" + typeAccount + ", client=" + client.getCpf() + "]";
	}

	
	
}

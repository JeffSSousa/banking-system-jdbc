package com.jeffersonssousa.model.entities;

import java.util.Objects;

public class Account {
	private Integer id;
	private Integer accountNumber;
	private String password;
	private Double balance;

	private Integer typeAccountId;
	private Integer clientId;

	public Account() {
	}

	public Account(Integer id, Integer accountNumber, String password, Double balance, Integer typeAccountId,
			Integer clientId) {
		this.id = id;
		this.accountNumber = accountNumber;
		this.password = password;
		this.balance = balance;
		this.typeAccountId = typeAccountId;
		this.clientId = clientId;
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

	public Integer getTypeAccountId() {
		return typeAccountId;
	}

	public void setTypeAccountId(Integer typeAccountId) {
		this.typeAccountId = typeAccountId;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
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
				+ balance + ", typeAccountId=" + typeAccountId + ", clientId=" + clientId + "]";
	}

}

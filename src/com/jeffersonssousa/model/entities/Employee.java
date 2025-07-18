package com.jeffersonssousa.model.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
	
	private Integer Id;
	private String firstName;
	private String lastName;
	private String cpf;
	private LocalDate birthDate;
	private String password;
	private String jobTitle;
	private String corporateEmail;
	
	public Employee() {
	}

	public Employee(Integer id, String firstName, String lastName, String cpf, LocalDate birthDate, String password,
			String jobTitle, String corporateEmail) {
		Id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cpf = cpf;
		this.birthDate = birthDate;
		this.password = password;
		this.jobTitle = jobTitle;
		this.corporateEmail = corporateEmail;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getCorporateEmail() {
		return corporateEmail;
	}

	public void setCorporateEmail(String corporateEmail) {
		this.corporateEmail = corporateEmail;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(Id, other.Id);
	}
	

	
}

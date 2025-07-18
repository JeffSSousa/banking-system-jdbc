package com.jeffersonssousa.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jeffersonssousa.config.exceptions.DatabaseException;
import com.jeffersonssousa.model.entities.Employee;
import com.jeffersonssousa.repository.EmployeeRepository;

public class EmployeeDaoJDBC implements EmployeeRepository{

	private Connection conn;
	
	public EmployeeDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public Employee findBycpf(String cpf) {
		String sql = "SELECT * FROM system_bank.tb_employees" + " WHERE cpf = ?";

		try (PreparedStatement st = conn.prepareStatement(sql)) {
			st.setString(1, cpf);

			try (ResultSet rs = st.executeQuery()) {
				if (rs.next()) {
					return instantiateEmployee(rs);
				} else {
					return null;
				}
			}

		} catch (SQLException e) {
			throw new DatabaseException("Erro ao Procurar o Colaborador com o CPF: " + e.getMessage());
		}
	}

	private Employee instantiateEmployee(ResultSet rs) throws SQLException {
		Employee obj = new Employee();
		obj.setId(rs.getInt("id"));
		obj.setFirstName(rs.getString("first_name"));
		obj.setLastName(rs.getString("last_name"));
		obj.setCpf(rs.getString("cpf"));
		obj.setBirthDate(rs.getDate("birth_date").toLocalDate());
		obj.setPassword(rs.getString("password"));
		obj.setJobTitle(rs.getString("job_title"));
		obj.setCorporateEmail(rs.getString("corporate_email"));
		return obj;
	}

	
	
}

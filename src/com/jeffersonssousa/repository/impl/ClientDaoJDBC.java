package com.jeffersonssousa.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jeffersonssousa.config.exceptions.DatabaseException;
import com.jeffersonssousa.model.entities.Client;
import com.jeffersonssousa.repository.ClientRepository;

public class ClientDaoJDBC implements ClientRepository {

	private Connection conn;

	public ClientDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	private Client instantiateClient(ResultSet rs) throws SQLException {
		Client obj = new Client();
		obj.setId(rs.getInt("id"));
		obj.setFirstName(rs.getString("first_name"));
		obj.setLastName(rs.getString("last_name"));
		obj.setCpf(rs.getString("cpf"));
		obj.setEmail(rs.getString("email"));
		obj.setBirthDate(rs.getDate("birth_date").toLocalDate());
		return obj;
	}

	@Override
	public void insert(Client obj) {
		String sql = "INSERT INTO tb_client " + "(first_name, last_name, cpf, email, birth_date)" + "values"
				+ "( ?, ?, ?, ?, ?)";

		try (PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			st.setString(1, obj.getFirstName());
			st.setString(2, obj.getLastName());
			st.setString(3, obj.getCpf());
			st.setString(4, obj.getEmail());

			st.setDate(5, java.sql.Date.valueOf(obj.getBirthDate()));

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				try (ResultSet rs = st.getGeneratedKeys()) {
					if (rs.next()) {
						int id = rs.getInt(1);
						obj.setId(id);
					}
				}
			} else {
				throw new DatabaseException("Nenhuma linha foi inserida");
			}

		} catch (SQLException e) {
			throw new DatabaseException("Erro ao inserir um Cliente: " + e.getMessage());
		}
	}

	@Override
	public void update(Client obj) {
		String sql = "UPDATE tb_client" + " SET first_name = ?, last_name = ?, cpf = ?, email = ?, birth_date = ?"
				+ " WHERE id = ?";

		try (PreparedStatement st = conn.prepareStatement(sql)) {
			st.setString(1, obj.getFirstName());
			st.setString(2, obj.getLastName());
			st.setString(3, obj.getCpf());
			st.setString(4, obj.getEmail());
			st.setDate(5, java.sql.Date.valueOf(obj.getBirthDate()));
			st.setInt(6, obj.getId());

			int rowsAffected = st.executeUpdate();
			if (rowsAffected == 0) {
				throw new DatabaseException(
						"Nenhum cliente com ID: " + obj.getId() + " foi encontrado para atualização.");
			}

			System.out.println("Cliente atualizado com sucesso");

		} catch (SQLException e) {
			throw new DatabaseException("Erro ao atualizar dados do Cliente: " + e.getMessage());
		}
	}

	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM tb_client " + "WHERE id = ?";

		try (PreparedStatement st = conn.prepareStatement(sql)) {
			st.setInt(1, id);

			int rowsAffacted = st.executeUpdate();

			if (rowsAffacted == 0) {
				throw new DatabaseException(
						"Nenhum cliente com o ID: " + id + " foi encontrado para ser deletado do banco de dados");
			}

			System.out.println("Cliente deletado com sucesso");

		} catch (SQLException e) {
			throw new DatabaseException("Erro ao deletar um cliente do banco de dados: " + e.getMessage());
		}
	}

	@Override
	public Client findById(Integer id) {
		String sql = "SELECT * FROM system_bank.tb_client" + " WHERE id = ?";

		try (PreparedStatement st = conn.prepareStatement(sql)) {
			st.setInt(1, id);

			try (ResultSet rs = st.executeQuery()) {
				if (rs.next()) {
					return instantiateClient(rs);
				} else {
					throw new DatabaseException("Cliente do ID: " + id + " não foi encontrado no Banco de Dados!!");
				}
			}

		} catch (SQLException e) {
			throw new DatabaseException("Erro ao procurar cliente por Id: " + e.getMessage());
		}
	}

	@Override
	public Client findByCpf(String cpf) {
		String sql = "SELECT * FROM system_bank.tb_client" + " WHERE cpf = ?";

		try (PreparedStatement st = conn.prepareStatement(sql)) {
			st.setString(1, cpf);

			try (ResultSet rs = st.executeQuery()) {
				if (rs.next()) {
					return instantiateClient(rs);
				} else {
					return null;
				}
			}

		} catch (SQLException e) {
			throw new DatabaseException("Erro ao procurar cliente do CPF: " + e.getMessage());
		}
	}

	@Override
	public Client findByEmail(String email) {
		String sql = "SELECT * FROM system_bank.tb_client" + " WHERE email = ?";

		try (PreparedStatement st = conn.prepareStatement(sql)) {
			st.setString(1, email);

			try (ResultSet rs = st.executeQuery()) {
				if (rs.next()) {
					return instantiateClient(rs);
				} else {
					return null;
				}
			}

		} catch (SQLException e) {
			throw new DatabaseException("Erro ao procurar cliente do CPF: " + e.getMessage());
		}
	}

	@Override
	public List<Client> findAll() {
		List<Client> list = new ArrayList<Client>();

		String sql = "SELECT * FROM tb_client";

		try (PreparedStatement st = conn.prepareStatement(sql); ResultSet rs = st.executeQuery()) {

			while (rs.next()) {
				list.add(instantiateClient(rs));
			}

		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage());
		}
		return list;
	}

}

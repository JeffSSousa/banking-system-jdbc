package com.jeffersonssousa.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jeffersonssousa.config.exceptions.DatabaseException;
import com.jeffersonssousa.model.entities.Account;
import com.jeffersonssousa.repository.AccountRepository;

public class AccountDaoJDBC implements AccountRepository {

	private Connection conn;

	public AccountDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	private Account instantiateAccount(ResultSet rs) throws SQLException {
		Account obj = new Account();
		obj.setId(rs.getInt("id"));
		obj.setAccountNumber(rs.getInt("account_number"));
		obj.setPassword(rs.getString("password"));
		obj.setBalance(rs.getDouble("balance"));
		obj.setTypeAccountId(rs.getInt("type_account_id"));
		obj.setClientId(rs.getInt("tb_client_id"));
		return obj;
	}

	@Override
	public void insert(Account obj) {
		String sql = "INSERT INTO tb_account " + "(account_number, password, balance, type_account_id, tb_client_id)"
				+ "values" + "( ?, ?, ?, ?, ?)";

		try (PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			st.setInt(1, obj.getAccountNumber());
			st.setString(2, obj.getPassword());
			st.setDouble(3, obj.getBalance());
			st.setInt(4, obj.getTypeAccountId());
			st.setInt(5, obj.getClientId());

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
			throw new DatabaseException("Erro ao inserir uma Conta: " + e.getMessage());
		}
	}

	@Override
	public void update(Account obj) {
		throw new DatabaseException("Não é permitido alterar dados da Conta");
	}

	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM tb_account " + "WHERE id = ?";

		try (PreparedStatement st = conn.prepareStatement(sql)) {
			st.setInt(1, id);

			int rowsAffacted = st.executeUpdate();

			if (rowsAffacted == 0) {
				throw new DatabaseException(
						"Nenhuma Conta com o ID: " + id + " foi encontrado para ser deletado do banco de dados");
			}

		} catch (SQLException e) {
			throw new DatabaseException("Erro ao deletar uma Conta do banco de dados: " + e.getMessage());
		}
	}

	@Override
	public Account findById(Integer id) {
		String sql = "SELECT * FROM system_bank.tb_account" + " WHERE id = ?";

		try (PreparedStatement st = conn.prepareStatement(sql)) {
			st.setInt(1, id);

			try (ResultSet rs = st.executeQuery()) {
				if (rs.next()) {
					return instantiateAccount(rs);
				} else {
					throw new DatabaseException("Conta do ID: " + id + " não foi encontrado no Banco de Dados!!");
				}
			}

		} catch (SQLException e) {
			throw new DatabaseException("Erro ao procurar cliente por Id: " + e.getMessage());
		}
	}

	@Override
	public Account findByClientId(Integer id) {
		String sql = "SELECT * FROM system_bank.tb_account" + " WHERE  tb_client_id = ?";

		try (PreparedStatement st = conn.prepareStatement(sql)) {
			st.setInt(1, id);

			try (ResultSet rs = st.executeQuery()) {
				if (rs.next()) {
					return instantiateAccount(rs);
				} else {
					throw new DatabaseException(
							"Conta do Cliente com o ID: " + id + " não foi encontrado no Banco de Dados!!");
				}
			}

		} catch (SQLException e) {
			throw new DatabaseException("Erro ao procurar cliente por id: " + e.getMessage());
		}
	}
	

	@Override
	public Account findByAccountNumber(Integer accountNumber) {
		String sql = "SELECT * FROM system_bank.tb_account" + " WHERE  account_number = ?";

		try (PreparedStatement st = conn.prepareStatement(sql)) {
			st.setInt(1, accountNumber);

			try (ResultSet rs = st.executeQuery()) {
				if (rs.next()) {
					return instantiateAccount(rs);
				} else {
					return null;
				}
			}

		} catch (SQLException e) {
			throw new DatabaseException("Erro ao procurar cliente por id: " + e.getMessage());
		}
	}

	@Override
	public List<Account> findAll() {
		List<Account> list = new ArrayList<>();

		String sql = "SELECT * FROM system_bank.tb_account";

		try (PreparedStatement st = conn.prepareStatement(sql); ResultSet rs = st.executeQuery()) {

			while (rs.next()) {
				list.add(instantiateAccount(rs));
			}

		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage());
		}
		return list;
	}

	@Override
	public boolean existsAccountNumber(Integer accountnumber) {
		String sql = "SELECT COUNT(*) FROM tb_account WHERE account_number = ?";

		try (PreparedStatement st = conn.prepareStatement(sql)) {
			st.setInt(1, accountnumber);

			try (ResultSet rs = st.executeQuery()) {
				if (rs.next()) {
					return rs.getInt(1) > 0;
				}
			}

		} catch (SQLException e) {
			throw new DatabaseException("Erro ao Verificar o Numero da Conta: " + e.getMessage());
		}
		return false;
	}


}

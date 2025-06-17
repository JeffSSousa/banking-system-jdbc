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
import com.jeffersonssousa.model.entities.Transaction;
import com.jeffersonssousa.model.enums.TypeTransaction;
import com.jeffersonssousa.model.factory.TransactionFactory;
import com.jeffersonssousa.repository.BaseRepository;

public class TransactionRepository implements BaseRepository<Transaction> {

	private Connection conn;

	public TransactionRepository(Connection conn) {
		this.conn = conn;
	}

	private Transaction instantiateTransaction(ResultSet rs) throws SQLException {
		int typeTransactionId = rs.getInt("type_transaction_id");

		Transaction obj = TransactionFactory.create(typeTransactionId);

		obj.setId(rs.getInt("id"));
		obj.setAmount(rs.getDouble("amount"));
		obj.setTransactionDate(rs.getTimestamp("transaction_date").toInstant());

		Account sender = new Account();
		sender.setId(rs.getInt("sender_id"));
		obj.setSender(sender);

		Account receiver = new Account();
		receiver.setId(rs.getInt("receiver_id"));
		obj.setReceiver(receiver);

		obj.setTypeTransaction(TypeTransaction.valueOf(typeTransactionId));

		return obj;
	}

	@Override
	public void insert(Transaction obj) {
		String sql = "INSERT system_bank.tb_transaction "
				+ "(amount, transaction_date, sender_id, receiver_id, type_transaction_id) " + "values"
				+ "( ?, ?, ?, ?, ?)";

		try (PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			st.setDouble(1, obj.getAmount());
			st.setTimestamp(2, java.sql.Timestamp.from(obj.getTransactionDate()));
			st.setInt(3, obj.getSender().getId());
			st.setInt(4, obj.getReceiver().getId());
			st.setInt(5, obj.getTypeTransaction().getId());

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

			System.out.println("Transação Realizada com Sucesso");

		} catch (SQLException e) {
			throw new DatabaseException("Erro ao realizar Transação: " + e.getMessage());
		}

	}

	@Override
	public void update(Transaction obj) {
		throw new DatabaseException("Transações não podem ser alteradas!!!!");
	}

	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM system_bank.tb_transaction " + "WHERE id = ?";

		try (PreparedStatement st = conn.prepareStatement(sql)) {
			st.setInt(1, id);

			int rowsAffacted = st.executeUpdate();

			if (rowsAffacted == 0) {
				throw new DatabaseException(
						"Nenhum Transação com o ID: " + id + " foi encontrado para ser deletada do banco de dados");
			}

			System.out.println("Transação deletada com sucesso");

		} catch (SQLException e) {
			throw new DatabaseException("Erro ao deletar a transação do banco de dados: " + e.getMessage());
		}
	}

	@Override
	public Transaction findById(Integer id) {

		String sql = "SELECT * FROM system_bank.tb_transaction" + " WHERE id = ?";
		try (PreparedStatement st = conn.prepareStatement(sql)) {
			st.setInt(1, id);

			try (ResultSet rs = st.executeQuery()) {
				if (rs.next()) {
					return instantiateTransaction(rs);
				} else {
					throw new DatabaseException("Transação com ID: " + id + " não foi encontrado no Banco de Dados!!");
				}
			}

		} catch (SQLException e) {
			throw new DatabaseException("Erro ao procurar a Transação por Id: " + e.getMessage());
		}
	}

	@Override
	public List<Transaction> findAll() {
		List<Transaction> list = new ArrayList<>();

		String sql = "SELECT * FROM system_bank.tb_transaction";

		try (PreparedStatement st = conn.prepareStatement(sql); ResultSet rs = st.executeQuery()) {

			while (rs.next()) {
				list.add(instantiateTransaction(rs));
			}

		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage());
		}
		return list;
	}

}

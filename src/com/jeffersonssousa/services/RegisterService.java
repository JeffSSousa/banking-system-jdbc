package com.jeffersonssousa.services;

import java.sql.Connection;
import java.sql.SQLException;

import com.jeffersonssousa.config.connection.DBConnection;
import com.jeffersonssousa.config.exceptions.DatabaseException;
import com.jeffersonssousa.model.entities.Account;
import com.jeffersonssousa.model.entities.Client;
import com.jeffersonssousa.repository.AccountRepository;
import com.jeffersonssousa.repository.ClientRepository;
import com.jeffersonssousa.repository.impl.AccountDaoJDBC;
import com.jeffersonssousa.repository.impl.ClientDaoJDBC;
import com.jeffersonssousa.view.util.Screen;

public class RegisterService {

	public void registerClientAndAccount(Client client, Account account) {
		Connection conn = null;

		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);

			ClientRepository clientRepo = new ClientDaoJDBC(conn);
			clientRepo.insert(client);

			account.setClientId(client.getId());

			AccountRepository accountRepo = new AccountDaoJDBC(conn);
			accountRepo.insert(account);

			conn.commit();

			System.out.println("Cadastro Finalizado com Sucesso!");
			Screen.timeSleep(1000);

		} catch (Exception e) {
			try {
				if (conn != null) {
					conn.rollback();
					System.out.println("Erro no cadastro. Rollback realizado.");
				}
			} catch (SQLException ex) {
				throw new DatabaseException("Erro ao executar rollback: " + ex.getMessage());
			}

			throw new DatabaseException("Erro no cadastro: " + e.getMessage());

		} finally {
			try {
				if (conn != null) {
					conn.setAutoCommit(true);
				}
			} catch (SQLException e) {
				throw new DatabaseException("Erro ao fechar conexão: " + e.getMessage());
			}
		}
	}

}

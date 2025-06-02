package com.jeffersonssousa.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jeffersonssousa.config.connection.DBConnection;
import com.jeffersonssousa.config.entities.DatabaseException;
import com.jeffersonssousa.model.entities.Client;

public class ClientRepository implements BaseRepository<Client> {

	private Connection conn;

	public ClientRepository(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Client obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Client obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Client obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public Client findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> findAll() {
		List<Client> list = new ArrayList<Client>();
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT * FROM tb_client");
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				list.add(new Client(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("cpf"), rs.getString("email"), rs.getDate("birth_date").toLocalDate()));
			}
			
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage());
		}finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(st);
		}
		return list;
	}

}

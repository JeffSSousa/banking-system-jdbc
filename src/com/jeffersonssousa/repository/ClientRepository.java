package com.jeffersonssousa.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jeffersonssousa.config.entities.DatabaseException;
import com.jeffersonssousa.model.entities.Client;

public class ClientRepository implements BaseRepository<Client> {

	private Connection conn;

	public ClientRepository(Connection conn) {
		this.conn = conn;
	}
	
	
	private Client instantiateClient(ResultSet rs) throws SQLException{
		Client obj = new Client();
		obj.setId(rs.getInt("id"));
		obj.setFirstName(rs.getString("first_name"));
		obj.setLastName(rs.getString("last_name"));
		obj.setCpf(rs.getString("cpf"));
		obj.setEmail("email");
		obj.setBirthDate(rs.getDate("birth_date").toLocalDate());
		return obj;
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
		
		String sql = "SELECT * FROM tb_client";
		
		try (PreparedStatement st = conn.prepareStatement(sql);
			 ResultSet rs = st.executeQuery()){
			
			while(rs.next()) {
				list.add(instantiateClient(rs));
			}
			
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage());
		}
		return list;
	}

}

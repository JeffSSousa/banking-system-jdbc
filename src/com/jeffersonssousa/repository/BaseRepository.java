package com.jeffersonssousa.repository;

import java.util.List;

public interface BaseRepository<T> {

	void insert(T obj);
	void update(T obj);
	void delete(T obj);
	T findById (Integer id);
	List<T> findAll();
}

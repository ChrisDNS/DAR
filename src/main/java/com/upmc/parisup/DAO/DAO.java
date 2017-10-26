package com.upmc.parisup.DAO;

import java.util.List;

public interface DAO<T> {

	public T get(Long id);

	public void add(T obj);

	// public void update(UpdateRequest updateReq);

	public void delete(String type, String id);

	public List<T> getAll();

	public void deleteAll(String type);
}
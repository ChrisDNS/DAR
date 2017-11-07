package com.upmc.parisup.DAO;

import java.util.List;

public interface DAO<T> {

	public T get(Long id);

	public void add(T obj);

	public void update(T obj);

	public void delete(String type, String id);

	public List<T> getAll();

	public void deleteAll(String type);
}
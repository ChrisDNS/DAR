package com.upmc.parisup.DAO;

import java.util.List;

public interface DAO<T> {

	public T get(Long id);

	public void add(T obj);

	public void update(T obj);

	public List<T> getAll();
	
	public List<T> pagination(int first, int total);
}
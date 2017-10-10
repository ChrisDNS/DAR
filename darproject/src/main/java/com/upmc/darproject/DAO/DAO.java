package com.upmc.darproject.DAO;

import java.util.List;

public interface DAO<T> {
	
	public abstract T get(Long id);

	public abstract void add(T obj);

	//public abstract void update(UpdateRequest updateReq);

	public abstract void delete(String type, String id);

	public abstract List<T> getAll();

	public abstract void deleteAll(String type);
}
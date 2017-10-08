package com.upmc.darproject.DAOImpl;

import java.util.List;

import org.hibernate.Session;

import com.upmc.darproject.DAO.DAO;
import com.upmc.darproject.persistence.MySQLPersistence;

public class MySQLDAOImpl<T> implements DAO<T> {
	private MySQLPersistence sql = MySQLPersistence.getInstance();
	private Class<T> typeT;

	public MySQLDAOImpl(Class<T> t) {
		typeT = t;
	}

	public Class<T> getTypeT() {
		return typeT;
	}

	public T get(String type, String id) {
		return null;
	}

	public void add(T obj) {
		Session session = sql.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(obj);
		session.getTransaction().commit();
		sql.closeSession();
	}

	public void delete(String type, String id) {

	}

	public List<T> getAll(String type) {
		return null;
	}

	public void deleteAll(String type) {

	}
}
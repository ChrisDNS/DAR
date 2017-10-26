package com.upmc.darproject.DAO.DAOImpl;

import java.util.List;

import org.hibernate.Session;

import com.upmc.darproject.DAO.DAO;
import com.upmc.darproject.persistence.MySQLPersistence;

public class MySQLDAOImpl<T> implements DAO<T> {
	protected MySQLPersistence sql = MySQLPersistence.getInstance();
	private Class<T> typeT;

	public MySQLDAOImpl(Class<T> t) {
		typeT = t;
	}

	public Class<T> getTypeT() {
		return typeT;
	}

	public T get(Long id) {
		Session session = sql.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		T t = typeT.cast(session.get(typeT, id));
		session.getTransaction().commit();

		return t;
	}

	public void add(T obj) {
		Session session = sql.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(obj);
		session.getTransaction().commit();
	}

	public void delete(String type, String id) {

	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		Session session = sql.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<T> l = session.createCriteria(typeT).list();
		session.getTransaction().commit();

		return l;
	}

	public void deleteAll(String type) {

	}
}
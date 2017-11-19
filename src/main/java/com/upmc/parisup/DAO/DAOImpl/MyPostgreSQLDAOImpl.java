package com.upmc.parisup.DAO.DAOImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.upmc.parisup.DAO.DAO;
import com.upmc.parisup.persistence.MyPostgreSQLPersistence;

public class MyPostgreSQLDAOImpl<T> implements DAO<T> {
	protected MyPostgreSQLPersistence sql = MyPostgreSQLPersistence.getInstance();
	private Class<T> typeT;

	public MyPostgreSQLDAOImpl(Class<T> t) {
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

	public void update(T obj) {
		Session session = sql.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(obj);
		session.getTransaction().commit();
	}

	public void delete(T obj) {
		Session session = sql.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(obj);
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		Session session = sql.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<T> l = session.createCriteria(typeT).list();
		session.getTransaction().commit();

		return l;
	}

	@SuppressWarnings("unchecked")
	public List<T> getByCriteria(String restriction, String where) {
		List<T> l;
		Session session = sql.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		l = session.createCriteria(typeT).add(Restrictions.like(restriction, "%" + where + "%")).list();
		session.getTransaction().commit();

		return l;
	}

	@SuppressWarnings("unchecked")
	public List<T> pagination(int first, int total, String type, String val) {
		List<T> list;
		Session session = sql.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria query = session.createCriteria(typeT);

		query.setFirstResult(first);
		query.setMaxResults(total);

		if (type.equals("all"))
			list = query.list();
		else if (type.equals("nom"))
			list = query.addOrder(Order.asc("nom")).list();
		else
			list = query.add(Restrictions.like(type, val + "%")).list();

		session.getTransaction().commit();

		return list;
	}
}
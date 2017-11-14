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
	public List<T> getAllI() {
		Session session = sql.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<T> l = session.createCriteria(typeT).add(Restrictions.like("type_d_etablissement", "Institu%")).list();
		session.getTransaction().commit();

		return l;
	}

	@SuppressWarnings("unchecked")
	public List<T> getAllE() {
		Session session = sql.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<T> l = session.createCriteria(typeT).add(Restrictions.like("type_d_etablissement", "Ecole%")).list();
		session.getTransaction().commit();

		return l;
	}

	@SuppressWarnings("unchecked")
	public List<T> getAllUFR() {
		Session session = sql.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<T> l = session.createCriteria(typeT).add(Restrictions.like("type_d_etablissement", "Unité%")).list();
		session.getTransaction().commit();

		return l;
	}

	public List<T> getAllAUTRE() {
		Session session = sql.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<T> l = session.createCriteria(typeT).add(Restrictions.like("type_d_etablissement", "Autre%")).list();
		session.getTransaction().commit();

		return l;
	}

	public List<T> getAllRECHERCHE(String a_rechercher) {
		Session session = sql.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<T> l = session.createCriteria(typeT).add(Restrictions.like("universite", a_rechercher + "%")).list();
		session.getTransaction().commit();

		return l;
	}

	@SuppressWarnings("unchecked")
	public List<T> pagination(int first, int total) {
		Session session = sql.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria query = session.createCriteria(typeT);

		query.setFirstResult(first);
		query.setMaxResults(total);

		List<T> list = query.list();
		session.getTransaction().commit();

		return list;
	}

	@SuppressWarnings("unchecked")
	public List<T> pagination2(int first, int total) {
		Session session = sql.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria query = session.createCriteria(typeT);

		query.setFirstResult(first);
		query.setMaxResults(total);

		List<T> list = query.addOrder(Order.asc("nom")).list();
		session.getTransaction().commit();

		return list;
	}

	@SuppressWarnings("unchecked")
	public List<T> pagination3(int first, int total) {
		Session session = sql.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria query = session.createCriteria(typeT);

		query.setFirstResult(first);
		query.setMaxResults(total);

		List<T> list = query.add(Restrictions.like("type_d_etablissement", "E%")).list();
		session.getTransaction().commit();

		return list;
	}

	@SuppressWarnings("unchecked")
	public List<T> paginationINSTITUT(int first, int total) {
		Session session = sql.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria query = session.createCriteria(typeT);

		query.setFirstResult(first);
		query.setMaxResults(total);

		List<T> list = query.add(Restrictions.like("type_d_etablissement", "Institut%")).list();
		session.getTransaction().commit();

		return list;
	}

	public List<T> paginationUFR(int first, int total) {
		Session session = sql.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria query = session.createCriteria(typeT);

		query.setFirstResult(first);
		query.setMaxResults(total);

		List<T> list = query.add(Restrictions.like("type_d_etablissement", "Unité%")).list();
		session.getTransaction().commit();

		return list;
	}

	public List<T> paginationAUTRE(int first, int total) {
		Session session = sql.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria query = session.createCriteria(typeT);

		query.setFirstResult(first);
		query.setMaxResults(total);

		List<T> list = query.add(Restrictions.like("type_d_etablissement", "Autre%")).list();
		session.getTransaction().commit();

		return list;
	}

	public List<T> paginationRECHERCHE(int first, int total, String a_chercher) {
		Session session = sql.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria query = session.createCriteria(typeT);

		query.setFirstResult(first);
		query.setMaxResults(total);

		List<T> list = query.add(Restrictions.like("universite", a_chercher + "%")).list();
		session.getTransaction().commit();

		return list;
	}
}
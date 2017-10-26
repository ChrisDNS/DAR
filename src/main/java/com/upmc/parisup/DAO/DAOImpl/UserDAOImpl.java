package com.upmc.parisup.DAO.DAOImpl;

import org.hibernate.Query;
import org.hibernate.Session;

import com.upmc.parisup.DAO.UserDAO;
import com.upmc.parisup.business.User;

public class UserDAOImpl extends MySQLDAOImpl<User> implements UserDAO {

	public UserDAOImpl(Class<User> userClass) {
		super(userClass);
	}

	public User getByLogin(String login) {
		String hql = "FROM User u WHERE u.login=" + "'" + login + "'";

		Session session = sql.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		User u = null;
		if(query.list().size() == 1)
			u = (User) query.list().get(0);
		
		session.getTransaction().commit();

		return u;
	}
}
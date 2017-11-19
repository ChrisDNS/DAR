package com.upmc.parisup.DAO.DAOImpl;

import org.hibernate.Query;
import org.hibernate.Session;

import com.upmc.parisup.DAO.UserDAO;
import com.upmc.parisup.business.User;

/**
 * 
 * User DAO implementation
 *
 */
public class UserDAOImpl extends MyPostgreSQLDAOImpl<User> implements UserDAO {

	public UserDAOImpl(Class<User> userClass) {
		super(userClass);
	}

	@Override
	public User getByAttribute(String attribute, String value) {
		String req = "FROM User u WHERE u." + attribute + "=" + "'" + value + "'";

		Session session = sql.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Query query = session.createQuery(req);
		User u = null;
		if (query.list().size() == 1)
			u = (User) query.list().get(0);

		session.getTransaction().commit();

		return u;
	}
}
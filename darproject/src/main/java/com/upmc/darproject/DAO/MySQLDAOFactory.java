package com.upmc.darproject.DAO;

import com.upmc.darproject.DAO.DAOImpl.UserDAOImpl;
import com.upmc.darproject.business.User;

public class MySQLDAOFactory extends AbstractDAOFactory {

	private static class DAOHolder {
		private static final UserDAO USER_DAO = new UserDAOImpl(User.class);
	}

	@Override
	public DAO<?> getUserDAO() {
		return DAOHolder.USER_DAO;
	}
}
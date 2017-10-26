package com.upmc.parisup.DAO;

import com.upmc.parisup.DAO.DAOImpl.UserDAOImpl;
import com.upmc.parisup.business.User;

public class MySQLDAOFactory extends AbstractDAOFactory {
	
	public MySQLDAOFactory() {
		super();
	}

	private static class DAOHolder {
		private static final UserDAO USER_DAO = new UserDAOImpl(User.class);
	}

	@Override
	public DAO<?> getUserDAO() {
		return DAOHolder.USER_DAO;
	}
}
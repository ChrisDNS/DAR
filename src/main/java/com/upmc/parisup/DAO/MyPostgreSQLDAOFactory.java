package com.upmc.parisup.DAO;

import com.upmc.parisup.DAO.DAOImpl.SchoolDAOImpl;
import com.upmc.parisup.DAO.DAOImpl.UserDAOImpl;
import com.upmc.parisup.business.School;
import com.upmc.parisup.business.User;

public class MyPostgreSQLDAOFactory extends AbstractDAOFactory {

	public MyPostgreSQLDAOFactory() {
		super();
	}

	private static class DAOHolder {
		private static final UserDAO USER_DAO = new UserDAOImpl(User.class);
		private static final SchoolDAO SCHOOL_DAO = new SchoolDAOImpl(School.class);
	}

	@Override
	public DAO<?> getUserDAO() {
		return DAOHolder.USER_DAO;
	}

	@Override
	public DAO<?> getSchoolDAO() {
		return DAOHolder.SCHOOL_DAO;
	}
}
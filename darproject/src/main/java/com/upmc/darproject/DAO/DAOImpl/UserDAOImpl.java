package com.upmc.darproject.DAO.DAOImpl;

import com.upmc.darproject.DAO.UserDAO;
import com.upmc.darproject.business.User;

public class UserDAOImpl extends MySQLDAOImpl<User> implements UserDAO {
	
	public UserDAOImpl(Class<User> userClass) {
		super(userClass);
	}
}
package com.upmc.darproject.services;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import com.upmc.darproject.DAO.AbstractDAOFactory;
import com.upmc.darproject.DAO.Factory;
import com.upmc.darproject.DAO.DAOImpl.UserDAOImpl;
import com.upmc.darproject.business.User;

public class FillDB {

	public static void addUsers() throws NoSuchAlgorithmException, InvalidKeySpecException {
		User u1 = new User("chris", "dionisio", "ChriChri");
		User u2 = new User("belynda", "hamaz", "Beloche");
		User u3 = new User("marie", "laporte", "Wano");

		u1.setSalt(new AuthenticationService().generateSalt());
		u1.setPassword(new AuthenticationService().getEncryptedPassword("test", u1.getSalt()));

		u2.setSalt(new AuthenticationService().generateSalt());
		u2.setPassword(new AuthenticationService().getEncryptedPassword("test", u2.getSalt()));

		u3.setSalt(new AuthenticationService().generateSalt());
		u3.setPassword(new AuthenticationService().getEncryptedPassword("test", u3.getSalt()));

		((UserDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getUserDAO()).add(u1);
		((UserDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getUserDAO()).add(u2);
		((UserDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getUserDAO()).add(u3);
	}
}
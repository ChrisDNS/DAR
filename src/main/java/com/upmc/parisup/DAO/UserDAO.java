package com.upmc.parisup.DAO;

import com.upmc.parisup.business.User;

/**
 * 
 * User DAO
 *
 */
public interface UserDAO extends DAO<User> {

	public User getByAttribute(String attribute, String value);
	
}
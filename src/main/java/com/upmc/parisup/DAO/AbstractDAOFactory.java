package com.upmc.parisup.DAO;

public abstract class AbstractDAOFactory {
	
	public AbstractDAOFactory() {
		
	}
	
	public abstract DAO<?> getUserDAO();
	
	public static AbstractDAOFactory getFactory(Factory type) {
		if (type.equals(Factory.MYSQL_DAO_FACTORY))
			return new MySQLDAOFactory();

		return null;
	}
}
package com.upmc.parisup.DAO;

public abstract class AbstractDAOFactory {
	
	public AbstractDAOFactory() {
		
	}
	
	public abstract DAO<?> getUserDAO();
	
	public abstract DAO<?> getSchoolDAO();
	
	public abstract DAO<?> getSelectedSchoolDAO();
	
	public abstract DAO<?> getCommentDAO();

	
	public static AbstractDAOFactory getFactory(Factory type) {
		if (type.equals(Factory.MYSQL_DAO_FACTORY))
			return new MyPostgreSQLDAOFactory();

		return null;
	}
}
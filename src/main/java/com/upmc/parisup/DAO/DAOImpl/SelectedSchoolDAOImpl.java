package com.upmc.parisup.DAO.DAOImpl;

import com.upmc.parisup.DAO.SelectedSchoolDAO;
import com.upmc.parisup.business.SelectedSchool;

public class SelectedSchoolDAOImpl extends MyPostgreSQLDAOImpl<SelectedSchool> implements SelectedSchoolDAO {

	public SelectedSchoolDAOImpl(Class<SelectedSchool> t) {
		super(t);
	}
}
package com.upmc.parisup.services;

import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import com.upmc.parisup.DAO.AbstractDAOFactory;
import com.upmc.parisup.DAO.Factory;
import com.upmc.parisup.DAO.DAOImpl.SelectedSchoolDAOImpl;
import com.upmc.parisup.business.SelectedSchool;

public class SchoolService {

	public SchoolService() {

	}

	public int[] getSelectedSchools(HttpServletRequest request) {
		String[] schoolsStrings = request.getParameterValues("schools[]");
		int[] schools = {};
		if (schoolsStrings != null)
			schools = Stream.of(schoolsStrings).mapToInt(Integer::parseInt).toArray();

		return schools;
	}

	public void addNewSelectedSchools(HttpServletRequest request, long idUser) {
		int[] schools = getSelectedSchools(request);
		for (int i = 0; i < schools.length; i++) {
			long idSchool = schools[i];
			SelectedSchool selectedSchool = new SelectedSchool(idSchool, idUser);
			((SelectedSchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSelectedSchoolDAO())
					.add(selectedSchool);
		}
	}
}
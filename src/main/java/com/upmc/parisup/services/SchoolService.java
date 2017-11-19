package com.upmc.parisup.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import com.upmc.parisup.DAO.AbstractDAOFactory;
import com.upmc.parisup.DAO.Factory;
import com.upmc.parisup.DAO.DAOImpl.RatingDAOImpl;
import com.upmc.parisup.DAO.DAOImpl.SelectedSchoolDAOImpl;
import com.upmc.parisup.business.Rating;
import com.upmc.parisup.business.SelectedSchool;

/**
 * 
 * School service
 *
 */
public class SchoolService {

	public SchoolService() {

	}

	/**
	 * Retrieves all selected schools
	 * 
	 * @param request
	 * @return int[]
	 */
	public int[] getSelectedSchools(HttpServletRequest request) {
		String[] schoolsStrings = request.getParameterValues("schools[]");
		int[] schools = {};
		if (schoolsStrings != null)
			schools = Stream.of(schoolsStrings).mapToInt(Integer::parseInt).toArray();

		return schools;
	}

	/**
	 * Adds new selected schools
	 * 
	 * @param request
	 * @param idUser
	 */
	public void addNewSelectedSchools(HttpServletRequest request, long idUser) {
		int[] schools = getSelectedSchools(request);
		for (int i = 0; i < schools.length; i++) {
			long idSchool = schools[i];
			SelectedSchool selectedSchool = new SelectedSchool(idSchool, idUser);
			((SelectedSchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSelectedSchoolDAO())
					.add(selectedSchool);
		}
	}

	/**
	 * Retrieves the average rating of a school identified by the id argument
	 * 
	 * @param idSchool
	 * @return average rating
	 */
	public Long getAverageRateSchoolID(Long idSchool) {
		Long total = new Long(0);
		List<Rating> list = ((RatingDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getRatingDAO())
				.getAllByDateDescAndSchoolID(idSchool);
		List<Rating> ret = new ArrayList<Rating>();

		for (Rating r : list) {
			if (r.getIdSchool().equals(idSchool)) {
				ret.add(r);
				total += r.getRating().longValue();
			}
		}

		if (ret.size() != 0) {
			return total / ret.size();

		} else
			return total;
	}
}
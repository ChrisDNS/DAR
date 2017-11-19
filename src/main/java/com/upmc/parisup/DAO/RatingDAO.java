package com.upmc.parisup.DAO;

import java.util.List;

import com.upmc.parisup.business.Rating;

public interface RatingDAO extends DAO<Rating> {

	public List<Rating> getAllByDateDescAndSchoolID(Long idSchool);

	public Long getAverageRateSchoolID(Long idSchool);
}
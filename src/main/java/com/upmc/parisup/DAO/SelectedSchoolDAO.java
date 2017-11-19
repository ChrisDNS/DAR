package com.upmc.parisup.DAO;

import java.util.List;

import com.upmc.parisup.business.SelectedSchool;

/**
 * 
 * Favourite schools DAO
 *
 */
public interface SelectedSchoolDAO extends DAO<SelectedSchool> {

	public List<SelectedSchool> getByUserID(Long id);

}
package com.upmc.parisup.DAO;

import java.util.List;

import com.upmc.parisup.business.SelectedSchool;

public interface SelectedSchoolDAO extends DAO<SelectedSchool> {
	
	public List<SelectedSchool> getByUserID(Long id);
	
}
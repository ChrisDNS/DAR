package com.upmc.parisup.DAO;

import com.upmc.parisup.business.School;

/**
 * 
 * School DAO
 *
 */
public interface SchoolDAO extends DAO<School> {

	public School getByUAI(String uai);
}
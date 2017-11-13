package com.upmc.parisup.DAO;

import java.util.List;

import com.upmc.parisup.business.School;

public interface SchoolDAO extends DAO<School> {

	public School getByUAI(String uai);
	
	public List<School> getByKeyWords(List<String> keyWords);
}

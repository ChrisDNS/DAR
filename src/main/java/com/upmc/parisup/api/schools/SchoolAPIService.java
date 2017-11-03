package com.upmc.parisup.api.schools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.upmc.parisup.business.School;

public class SchoolAPIService {

	private SchoolAPIService() {

	}

	private static class SchoolAPIHolder {
		private static final SchoolAPIService INSTANCE = new SchoolAPIService();
	}

	public static SchoolAPIService getInstance() {
		return SchoolAPIHolder.INSTANCE;
	}

	public List<School> retrieveAllSchools() {
		Map<String, String> params = new HashMap<String, String>();
		params.put(SchoolAPIConstants.ROWS, String.valueOf(SchoolAPIConstants.PAGE_SIZE));

		String resp = null;
		List<School> schools = new ArrayList<School>();

		for (int i = 0; i < SchoolAPIConstants.NHINTS; i += SchoolAPIConstants.PAGE_SIZE) {
			params.put(SchoolAPIConstants.START, String.valueOf(i));

			resp = SchoolAPIRequestHelper.send(SchoolAPIRequestHelper.create(params));
			List<School> tmp = SchoolAPIHelper.retrieveAllSchools(resp);
			tmp.forEach(s -> {
				if (s.getUniversite() == null)
					s.setUniversite(s.getNom());
			});

			schools.addAll(tmp);
		}

		return schools;
	}
}
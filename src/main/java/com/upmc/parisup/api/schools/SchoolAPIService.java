package com.upmc.parisup.api.schools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.upmc.parisup.api.RequestHelper;
import com.upmc.parisup.business.School;

public class SchoolAPIService {

	public SchoolAPIService() {

	}

	public List<School> retrieveAllSchools() {
		Map<String, String> params = new HashMap<String, String>();
		params.put(SchoolAPIConstants.ROWS, String.valueOf(SchoolAPIConstants.PAGE_SIZE));

		String resp = null;
		List<School> schools = new ArrayList<School>();

		for (int i = 0; i < SchoolAPIConstants.NHINTS; i += SchoolAPIConstants.PAGE_SIZE) {
			System.out.println("i : " + i);
			params.put(SchoolAPIConstants.START, String.valueOf(i));

			resp = RequestHelper.send(RequestHelper.create(params));
			List<School> tmp = SchoolAPIHelper.retrieveAllSchools(resp);
			tmp.forEach(s -> {
				if (s.getUniversite() == null)
					s.setUniversite(s.getNom());
			});

			schools.addAll(tmp);
		}

		return schools;
	}

	public School retriveSchoolByUAI(String uai) {
		Map<String, String> params = new HashMap<String, String>();

		params.put(SchoolAPIConstants.Q, uai);

		String resp = RequestHelper.send(RequestHelper.create(params));
		System.out.println(resp);

		return null;
	}
}

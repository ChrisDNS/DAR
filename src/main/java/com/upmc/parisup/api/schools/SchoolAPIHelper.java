package com.upmc.parisup.api.schools;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.upmc.parisup.business.School;

public class SchoolAPIHelper {

	private SchoolAPIHelper() {

	}

	public static List<School> retrieveAllSchools(String json) {
		if (json == null || json == "")
			return null;

		JSONObject j = new JSONObject(json);
		JSONArray jArray = j.getJSONArray(SchoolAPIConstants.RECORDS);
		ObjectMapper mapper = new ObjectMapper();

		List<School> schools = new ArrayList<School>();

		JSONObject tmp;
		for (int i = 0; i < jArray.length(); i++) {
			System.out.println("i = "+i);
			tmp = jArray.getJSONObject(i).getJSONObject(SchoolAPIConstants.FIELDS);

			try {
				schools.add(mapper.readValue(tmp.toString(), School.class));

			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return schools;
	}
}
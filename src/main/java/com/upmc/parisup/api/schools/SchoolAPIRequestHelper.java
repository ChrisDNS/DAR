package com.upmc.parisup.api.schools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/**
 * 
 * Open Data Schools in Ile-de-France API request helper
 *
 */
public class SchoolAPIRequestHelper {
	
	private SchoolAPIRequestHelper() {
		
	}

	/**
	 * Creates URL from arguments.
	 * 
	 * @param params
	 * @return URL
	 */
	public static String create(Map<String, String> params) {
		String req = SchoolAPIConstants.URL;
		req += "?dataset=";
		req += SchoolAPIConstants.DATASET;

		for (Map.Entry<String, String> entry : params.entrySet())
			req += "&" + entry.getKey() + "=" + entry.getValue();

		return req;
	}

	/**
	 * Reads URL content
	 * 
	 * @param req
	 * @return URL content
	 */
	public static String send(String req) {
		StringBuffer ret = new StringBuffer();
		BufferedReader br;
		URL url;

		try {
			url = new URL(req);
			br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			ret.append(br.readLine());
			br.close();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return ret.toString();
	}
}
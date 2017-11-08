package com.upmc.parisup.services;

import java.io.IOException;
import java.security.SecureRandom;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class Util {

	public static String generateToken() {
		long token = Math.abs(new SecureRandom().nextLong());
		String random = Long.toString(token, 32);
		return random;
	}

	public static void sendJSON(HttpServletResponse response, JSONObject json) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");

		try {
			response.getWriter().print(json);
			response.getWriter().close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
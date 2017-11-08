package com.upmc.parisup.services;

import java.security.SecureRandom;

public class Util {

	public static String generateToken() {
		long token = Math.abs(new SecureRandom().nextLong());
		String random = Long.toString(token, 32);
		return random;
	}
}

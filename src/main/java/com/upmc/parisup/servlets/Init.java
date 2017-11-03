package com.upmc.parisup.servlets;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.servlet.http.HttpServlet;

import com.upmc.parisup.services.FillDB;

public class Init extends HttpServlet {
	private static final long serialVersionUID = 806820280113339687L;

	public Init() {
		try {
			FillDB.addUsers();
			FillDB.addSchools();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
	}
}
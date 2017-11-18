package com.upmc.parisup.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upmc.parisup.DAO.AbstractDAOFactory;
import com.upmc.parisup.DAO.Factory;
import com.upmc.parisup.DAO.DAOImpl.SchoolDAOImpl;
import com.upmc.parisup.DAO.DAOImpl.UserDAOImpl;
import com.upmc.parisup.business.School;
import com.upmc.parisup.business.User;
import com.upmc.parisup.services.SchoolService;
import com.upmc.parisup.services.UserService;
import com.upmc.parisup.services.Util;

public class SignUp extends HttpServlet {
	private static final long serialVersionUID = -5677200504573287154L;

	public SignUp() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Add all schools into combobox
		List<School> schools = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO())
				.getAll();
		request.setAttribute("schools", schools);
		request.setAttribute("user", null);
		request.setAttribute("selectedSchools", null);

		request.getRequestDispatcher("WEB-INF/signup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserService us = new UserService();
		SchoolService ss = new SchoolService();

		ArrayList<String> errors = new ArrayList<String>();
		JSONObject json = new JSONObject();
		User user = us.getUser(request, errors, null);

		// If no errors, then sign up
		if (user != null) {

			// Add the user to DB
			((UserDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getUserDAO()).add(user);

			// Reload the user just to get the correct ID
			user = ((UserDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getUserDAO())
					.getByAttribute("email", user.getEmail());

			// Add the selected schools to DB
			ss.addNewSelectedSchools(request, user.getId());

			ObjectMapper mapper = new ObjectMapper();
			String userToJson = mapper.writeValueAsString(user);
			json.put("user", userToJson);
		}

		json.put("success", user != null);
		json.put("message", String.join("\n", errors));

		Util.sendJSON(response, json);
	}
}
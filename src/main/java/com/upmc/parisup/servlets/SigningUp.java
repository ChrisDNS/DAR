package com.upmc.parisup.servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.upmc.parisup.DAO.AbstractDAOFactory;
import com.upmc.parisup.DAO.Factory;
import com.upmc.parisup.DAO.DAOImpl.UserDAOImpl;
import com.upmc.parisup.business.User;
import com.upmc.parisup.services.AuthenticationService;

public class SigningUp extends HttpServlet {
	private static final long serialVersionUID = -5677200504573287154L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String town = request.getParameter("town");
		String[] schoolsStrings = request.getParameterValues("schools[]");
		int[] schools;
		if (schoolsStrings.length > 0)
			schools = Stream.of(schoolsStrings).mapToInt(Integer::parseInt).toArray();
		
		JSONObject json = new JSONObject();
		User user = ((UserDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getUserDAO())
				.getByAttribute("email", email);
		if (user != null) {
			json.put("message", "Ce mail est déjà enregistré.");
			json.put("success", false);
		}
		else {
			// Add the user to DB
			/*
			user = new User(firstName, name, mail);
			try {
				user.setSalt(new AuthenticationService().generateSalt());
				user.setPassword(new AuthenticationService().getEncryptedPassword(password, user.getSalt()));
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
				e.printStackTrace();
			}
			((UserDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getUserDAO()).add(user);
			*/
			
			/*
			ObjectMapper mapper = new ObjectMapper();
			String userToJson = mapper.writeValueAsString(user);

			json.put("success", true);
			json.put("user", userToJson);
			*/
		}
		
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
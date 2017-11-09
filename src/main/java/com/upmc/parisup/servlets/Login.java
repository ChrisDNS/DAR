package com.upmc.parisup.servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

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

public class Login extends HttpServlet {
	private static final long serialVersionUID = -5677200504573287154L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		JSONObject json = new JSONObject();

		if (email == null || email.isEmpty()) {
			json.put("message", "Veuillez remplir tous les champs.");
			json.put("success", false);
		} else if (password == null || password.isEmpty()) {
			json.put("message", "Veuillez remplir tous les champs.");
			json.put("success", false);

		} else {
			User user = ((UserDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getUserDAO())
					.getByEmail(email);
			if (user == null) {
				json.put("message", "Email ou mot de passe incorrect.");
				json.put("success", false);

			} else {
				try {
					if (new AuthenticationService().authenticate(password, user.getPassword(), user.getSalt())) {
						ObjectMapper mapper = new ObjectMapper();
						String userToJson = mapper.writeValueAsString(user);

						json.put("success", true);
						json.put("user", userToJson);
					}

					else {
						json.put("success", false);
						json.put("message", "Email ou mot de passe incorrect.");
					}

				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				} catch (InvalidKeySpecException e) {
					e.printStackTrace();
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
			}
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
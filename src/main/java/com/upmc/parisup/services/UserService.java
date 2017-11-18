package com.upmc.parisup.services;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.upmc.parisup.DAO.AbstractDAOFactory;
import com.upmc.parisup.DAO.Factory;
import com.upmc.parisup.DAO.DAOImpl.UserDAOImpl;
import com.upmc.parisup.business.User;

public class UserService {

	public UserService() {

	}

	public User getCurrentUser(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("email")) {
					String email = cookie.getValue();
					return ((UserDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getUserDAO())
							.getByAttribute("email", email);
				}
			}
		}

		return null;
	}

	public User getUser(HttpServletRequest request, ArrayList<String> errors, String currentMail) {
		String firstName = request.getParameter("firstName");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String confirmationEmail = request.getParameter("confemail");
		String password = request.getParameter("password");
		String confirmationPassword = request.getParameter("confpassword");
		String address = request.getParameter("address");
		String town = request.getParameter("town");
		User user = ((UserDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getUserDAO())
				.getByAttribute("email", email);

		if (user != null && (currentMail == null || !email.equals(currentMail)))
			errors.add("Ce mail est déjà enregistré.");
		if (!email.equals(confirmationEmail))
			errors.add("Les deux emails sont différents.");
		else {
			if (!Util.testMail(email) && !Util.testMail(confirmationEmail)) {
				errors.add("Cette adresse email n'est pas valide.");
			}
		}

		if (!password.equals(confirmationPassword))
			errors.add("Les mots de passe sont différents.");
		if (firstName.isEmpty())
			errors.add("Le champ prénom ne peut pas être vide.");
		if (name.isEmpty())
			errors.add("Le champ nom ne peut pas être vide.");
		if (email.isEmpty())
			errors.add("Le champ email ne peut pas être vide.");
		if (password.isEmpty() && currentMail == null)
			errors.add("Le champ mot de passe ne peut pas être vide.");

		if (errors.isEmpty()) {
			user = new User(firstName, name, email, address, town);
			try {
				user.setSalt(new AuthenticationService().generateSalt());
				user.setPassword(new AuthenticationService().getEncryptedPassword(password, user.getSalt()));
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
				e.printStackTrace();
			}

			return user;
		}

		return null;
	}
}
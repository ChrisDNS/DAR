package com.upmc.parisup.servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.upmc.parisup.DAO.AbstractDAOFactory;
import com.upmc.parisup.DAO.Factory;
import com.upmc.parisup.DAO.UserDAO;
import com.upmc.parisup.DAO.DAOImpl.UserDAOImpl;
import com.upmc.parisup.business.User;
import com.upmc.parisup.services.AuthenticationService;
import com.upmc.parisup.services.MailService;
import com.upmc.parisup.services.Util;

public class PasswordReset extends HttpServlet {
	private static final long serialVersionUID = 625693337139608816L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getRequestURI().equals("/password_reset"))
			request.getRequestDispatcher("WEB-INF/password_reset.jsp").forward(request, response);

		else {
			String token = request.getPathInfo().substring(1);
			UserDAO udao = (UserDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getUserDAO();
			User u = null;
			if ((u = udao.getByAttribute("token", token)) != null) {
				request.setAttribute("email", u.getEmail());
				request.getRequestDispatcher("/WEB-INF/change_password.jsp").forward(request, response);

			} else {
				JSONObject json = new JSONObject();
				json.put("success", false);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		UserDAO udao = (UserDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getUserDAO();
		JSONObject json = new JSONObject();
		User u = null;

		if (request.getParameter("value").equals("reset")) {
			String email = request.getParameter("mail");
			u = udao.getByAttribute("email", email);
			if (u == null) {
				json.put("success", false);
				json.put("message", "Désolé, nous ne trouvons pas cet adresse email");
			}

			else {
				u.setToken(Util.generateToken());
				udao.update(u);

				MailService ms = new MailService("ouais", request.getRequestURL() + "/" + u.getToken());
				ms.sendTo(email);
				json.put("success", true);
				json.put("message",
						"Regardez vos emails, vous trouverez un lien pour réinitialiser votre mot de passe.");
			}

		} else if (request.getParameter("value").equals("change")) {
			String pwd = request.getParameter("pwd");
			String pwdConfirm = request.getParameter("pwdConfirm");
			if (!pwd.equals(pwdConfirm))
				json.put("success", false);

			else {
				u = udao.getByAttribute("token", request.getPathInfo().substring(1).split("/")[1]);
				if (u.getEmail().equals(request.getParameter("email"))) {
					try {
						AuthenticationService as = new AuthenticationService();
						u.setSalt(as.generateSalt());
						u.setPassword(as.getEncryptedPassword(pwd, u.getSalt()));
						u.setToken("");
						udao.update(u);

						json.put("success", true);

					} catch (NoSuchAlgorithmException e) {
						e.printStackTrace();
					} catch (InvalidKeySpecException e) {
						e.printStackTrace();
					}

				} else
					json.put("success", false);
			}
		}

		Util.sendJSON(response, json);
	}
}
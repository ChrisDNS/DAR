package com.upmc.parisup.servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upmc.parisup.DAO.AbstractDAOFactory;
import com.upmc.parisup.DAO.Factory;
import com.upmc.parisup.DAO.DAOImpl.SchoolDAOImpl;
import com.upmc.parisup.DAO.DAOImpl.SelectedSchoolDAOImpl;
import com.upmc.parisup.DAO.DAOImpl.UserDAOImpl;
import com.upmc.parisup.business.School;
import com.upmc.parisup.business.SelectedSchool;
import com.upmc.parisup.business.User;
import com.upmc.parisup.services.AuthenticationService;

public class SignUp extends HttpServlet {
	private static final long serialVersionUID = -5677200504573287154L;

	public SignUp() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Add all schools into combobox
		List<School> schools = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO()).getAll();
		request.setAttribute("schools", schools);
		request.getRequestDispatcher("WEB-INF/signup.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String confirmationEmail = request.getParameter("confemail");
		String password = request.getParameter("password");
		String confirmationPassword = request.getParameter("confpassword");
		String address = request.getParameter("address");
		String town = request.getParameter("town");
		String[] schoolsStrings = request.getParameterValues("schools[]");
		int[] schools = {};
		if (schoolsStrings != null)
			schools = Stream.of(schoolsStrings).mapToInt(Integer::parseInt).toArray();
		
		JSONObject json = new JSONObject();
		User user = ((UserDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getUserDAO())
				.getByAttribute("email", email);
		ArrayList<String> messages = new ArrayList<String>();

		if (user != null)
			messages.add("Ce mail est déjà enregistré.");
		if (!email.equals(confirmationEmail))
			messages.add("Les deux emails sont différents.");
		if (!password.equals(confirmationPassword))
			messages.add("Les deux mots de passes sont différents.");
		if (firstName.isEmpty())
			messages.add("Le champ prénom ne peut pas être vide.");
		if (name.isEmpty())
			messages.add("Le champ nom ne peut pas être vide.");
		if (email.isEmpty())
			messages.add("Le champ email ne peut pas être vide.");
		if (password.isEmpty())
			messages.add("Le champ mot de passe ne peut pas être vide.");
		
		// If no errors, then sign up
		if (messages.isEmpty()) {
			user = new User(firstName, name, email, address, town);
			try {
				user.setSalt(new AuthenticationService().generateSalt());
				user.setPassword(new AuthenticationService().getEncryptedPassword(password, user.getSalt()));
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
				e.printStackTrace();
			}
			// Add the user to DB
			((UserDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getUserDAO()).add(user);
			
			// Reload the user juste to get the correct ID
			user = ((UserDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getUserDAO())
					.getByAttribute("email", email);
			
			// Add the selected schools to DB
			for (int i = 0; i < schools.length; i++) {
				long idSchool = schools[i];
				SelectedSchool selectedSchool = new SelectedSchool(idSchool, user.getId());
				((SelectedSchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSelectedSchoolDAO()).add(selectedSchool);
			}
			
			ObjectMapper mapper = new ObjectMapper();
			String userToJson = mapper.writeValueAsString(user);

			json.put("user", userToJson);
		}
		
		json.put("success", messages.isEmpty());
		json.put("message", String.join("\n", messages));
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
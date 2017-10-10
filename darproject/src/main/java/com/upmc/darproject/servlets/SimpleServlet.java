package com.upmc.darproject.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upmc.darproject.DAO.AbstractDAOFactory;
import com.upmc.darproject.DAO.Factory;
import com.upmc.darproject.DAO.DAOImpl.UserDAOImpl;
import com.upmc.darproject.business.User;

public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = -4751096228274971485L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Servlet " + this.getServletName() + " has started");
		User u = new User();
		u.setFirstname("chris");
		u.setLastname("dionisio");

		User u2 = new User();
		u2.setFirstname("marie");
		u2.setLastname("hamaz");
		// u.setLogin("chris");
		// u.setPassword("test");

		
		
		////////////////////// TEST //////////////////////
		((UserDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getUserDAO()).add(u);
		((UserDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getUserDAO()).add(u2);

		System.out.println(
				((UserDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getUserDAO()).get(u2.getId()));

		List<User> l = ((UserDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getUserDAO()).getAll();
		System.out.println(l.size());
		for (User s : l) {
			System.out.println("caca");
			System.out.println(s);
		}
		////////////////////// TEST //////////////////////
	}

	@Override
	public void destroy() {
		System.out.println("Servlet " + this.getServletName() + " has stopped");
	}
}
package com.upmc.darproject.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upmc.darproject.DAO.AbstractDAOFactory;
import com.upmc.darproject.DAO.Factory;
import com.upmc.darproject.DAOImpl.UserDAOImpl;
import com.upmc.darproject.business.User;

public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = -4751096228274971485L;

	@Override
	protected void doGet(HttpServletRequest reqest, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("Hello World ezdezde!");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Servlet " + this.getServletName() + " has started");
		User u = new User();
		u.setFirstname("chris");
		u.setLastname("dionisio");
//		u.setLogin("chris");
//		u.setPassword("test");
		
		((UserDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getUserDAO()).add(u);
	}

	@Override
	public void destroy() {
		System.out.println("Servlet " + this.getServletName() + " has stopped");
	}
}
package com.upmc.darproject.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResetPassword extends HttpServlet {
	private static final long serialVersionUID = 625693337139608816L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Servlet " + this.getServletName() + " has started fdp");

		request.getRequestDispatcher("html/password_reset.html").forward(request, response);
	}
}
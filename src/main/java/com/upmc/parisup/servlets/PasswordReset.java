package com.upmc.parisup.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upmc.parisup.services.Mail;

public class PasswordReset extends HttpServlet {
	private static final long serialVersionUID = 625693337139608816L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/password_reset.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		new Mail().sendTo(request.getParameter("email"));
	}
}
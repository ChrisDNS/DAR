package com.upmc.parisup.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upmc.parisup.business.Message;

public class Chat extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String message = request.getParameter("message");
		
		Message m = new Message();
		m.setLogin(username);
		m.setMessage(message);
		
//		((MessageDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getMessageDAO()).add(m);
		
		

		
	}	
}
package com.upmc.parisup.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upmc.parisup.DAO.AbstractDAOFactory;
import com.upmc.parisup.DAO.Factory;
import com.upmc.parisup.DAO.RatingDAO;
import com.upmc.parisup.DAO.SchoolDAO;
import com.upmc.parisup.DAO.DAOImpl.RatingDAOImpl;
import com.upmc.parisup.DAO.DAOImpl.SchoolDAOImpl;
import com.upmc.parisup.business.Rating;
import com.upmc.parisup.business.User;
import com.upmc.parisup.services.UserService;

public class LeaveComment extends HttpServlet {
	private static final long serialVersionUID = 5288887076145694915L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService us = new UserService();

		SchoolDAO sdao = (SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO();
		RatingDAO rdao = (RatingDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getRatingDAO();
		String comment = request.getParameter("comment");
		String rating = request.getParameter("rating");

		User u = us.getCurrentUser(request);

		Rating r = new Rating();
		r.setIdSchool(sdao.getByUAI(request.getParameter("uai")).getId());
		r.setNameUser(u.getFirstname() + " " + u.getLastname().charAt(0));
		r.setIdUser(u.getId());
		r.setComment(comment);
		r.setRating(Long.parseLong(rating));

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		r.setDate(dateFormat.format(date));

		rdao.add(r);
	}
}
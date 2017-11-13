package com.upmc.parisup.servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upmc.parisup.DAO.AbstractDAOFactory;
import com.upmc.parisup.DAO.Factory;
import com.upmc.parisup.DAO.DAOImpl.SchoolDAOImpl;
import com.upmc.parisup.business.School;

public class Search extends HttpServlet {
	private static final long serialVersionUID = 8564336809015917293L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("value") != null && request.getParameter("value").equals("search")) {
			String search = request.getParameter("data");
			List<String> keyWords = Arrays.asList(search.split(" "));
			List<School> schools = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY)
					.getSchoolDAO()).getByKeyWords(keyWords);
			request.setAttribute("schoolList", schools);
			System.out.println(schools.size());
			request.getRequestDispatcher("WEB-INF/search.jsp").forward(request, response);

		} else {
			int page = 1;
			int recordsPerPage = 20;

			/* recuperer le num de la page demandee */

			if (request.getParameter("page") != null)
				page = Integer.parseInt(request.getParameter("page"));

			List<School> schools = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY)
					.getSchoolDAO()).pagination((page - 1) * recordsPerPage, recordsPerPage);

			// nombre total de page

			int noOfRecords = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO())
					.getAll().size();
			int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

			// envoyer a la view
			request.setAttribute("schoolList", schools);
			request.setAttribute("noOfPages", noOfPages);
			request.setAttribute("currentPage", page);

			request.getRequestDispatcher("WEB-INF/search.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int page = 1;
		int recordsPerPage = 20;

		/* recuperer le num de la page demandee */

		if (request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));

		List<School> schools = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO())
				.pagination((page - 1) * recordsPerPage, recordsPerPage);

		// nombre total de page

		int noOfRecords = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO())
				.getAll().size();
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		// envoyer a la view
		request.setAttribute("schoolList", schools);
		request.setAttribute("noOfPages", noOfPages);
		request.setAttribute("currentPage", page);

		request.getRequestDispatcher("WEB-INF/search.jsp").forward(request, response);
	}
}
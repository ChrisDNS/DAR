package com.upmc.parisup.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.upmc.parisup.api.schools.SchoolAPIConstants;
import com.upmc.parisup.business.School;

public class Search extends HttpServlet {
	private static final long serialVersionUID = 8564336809015917293L;

	private boolean filtering = false;
	private String button = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SchoolDAO sdao = (SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO();
		RatingDAO rdao = (RatingDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getRatingDAO();

		if (request.getParameter("id") != null) {
			Long id = Long.parseLong(request.getParameter("id"));
			School s = sdao.get(id);
			if (s != null) {
				request.setAttribute("school", s);
				request.setAttribute("ratings", rdao.getAllByDateDescAndSchoolID(s.getId()));
				request.getRequestDispatcher("WEB-INF/school.jsp").forward(request, response);
			}

			return;
		}

		int page = 1;
		int noOfPages = 0;
		int noOfRecords = 0;
		List<School> schools = null;

		if (request.getParameter("filter") != null)
			button = request.getParameter("filter");

		if (request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));

		if (request.getParameter("search") != null)
			button = request.getParameter("search");

		if (button != null) {
			filtering = true;

			if (button.equals("alpha")) {
				schools = sdao.pagination((page - 1) * SchoolAPIConstants.PAGE_SIZE, SchoolAPIConstants.PAGE_SIZE,
						"nom", "");
				noOfRecords = sdao.getAll().size();
			} else if (button.equals("note")) {
				// filter = true;
				// page = 1;
				// button = 3;
			} else if (button.equals("ecoles")) {
				schools = sdao.pagination((page - 1) * SchoolAPIConstants.PAGE_SIZE, SchoolAPIConstants.PAGE_SIZE,
						"type_d_etablissement", "Ecole");
				noOfRecords = sdao.getByCriteria("type_d_etablissement", "Ecole").size();
			} else if (button.equals("instituts")) {
				schools = sdao.pagination((page - 1) * SchoolAPIConstants.PAGE_SIZE, SchoolAPIConstants.PAGE_SIZE,
						"type_d_etablissement", "Institut");
				noOfRecords = sdao.getByCriteria("type_d_etablissement", "Institut").size();
			} else if (button.equals("ufr")) {
				schools = sdao.pagination((page - 1) * SchoolAPIConstants.PAGE_SIZE, SchoolAPIConstants.PAGE_SIZE,
						"type_d_etablissement", "Unit");
				noOfRecords = sdao.getByCriteria("type_d_etablissement", "Unit").size();
			} else if (button.equals("autre")) {
				schools = sdao.pagination((page - 1) * SchoolAPIConstants.PAGE_SIZE, SchoolAPIConstants.PAGE_SIZE,
						"type_d_etablissement", "Autre");
				noOfRecords = sdao.getByCriteria("type_d_etablissement", "Autre").size();
			} else if (button.equals("search")) {
				String value = request.getParameter("searchValue");
				schools = sdao.pagination((page - 1) * SchoolAPIConstants.PAGE_SIZE, SchoolAPIConstants.PAGE_SIZE,
						"nom", value);
				noOfRecords = sdao.getByCriteria("nom", value).size();
			} else {
				schools = sdao.pagination((page - 1) * SchoolAPIConstants.PAGE_SIZE, SchoolAPIConstants.PAGE_SIZE,
						"all", "");
				noOfRecords = sdao.getAll().size();
			}
		}

		if (!filtering) {
			schools = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO())
					.pagination((page - 1) * SchoolAPIConstants.PAGE_SIZE, SchoolAPIConstants.PAGE_SIZE, "all", "");
			noOfRecords = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO())
					.getAll().size();
		}

		Map<School, Long> ratingSchools = new HashMap<>();
		for (School s : schools)
			ratingSchools.put(s, rdao.getAverageRateSchoolID(s.getId()));


		noOfPages = (int) Math.ceil(noOfRecords * 1.0 / SchoolAPIConstants.PAGE_SIZE);

		request.setAttribute("schoolList", ratingSchools);
		request.setAttribute("noOfPages", noOfPages);
		request.setAttribute("currentPage", page);
		request.setAttribute("filter", button);

		request.getRequestDispatcher("WEB-INF/search.jsp").forward(request, response);
	}
}
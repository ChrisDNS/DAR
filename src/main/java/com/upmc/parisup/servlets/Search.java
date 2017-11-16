package com.upmc.parisup.servlets;

import java.io.IOException;
import java.util.List;

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
	int noOfRecords = 0;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SchoolDAO sdao = (SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO();

		if (request.getParameter("uai") != null) {
			String uai = request.getParameter("uai");
			RatingDAO rdao = (RatingDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getCommentDAO();
			School s = sdao.getByUAI(uai);
			if (s != null) {
				request.setAttribute("school", s);
				request.setAttribute("ratings", rdao.getAllByDateDescAndSchoolID(s.getId()));
				request.getRequestDispatcher("WEB-INF/school.jsp").forward(request, response);
			}

			return;
		}

		int page = 1;
		if (request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));

		List<School> schools = sdao.pagination((page - 1) * SchoolAPIConstants.PAGE_SIZE, SchoolAPIConstants.PAGE_SIZE,
				"all", null);
		int noOfRecords = sdao.getAll().size();
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / SchoolAPIConstants.PAGE_SIZE);

		request.setAttribute("schoolList", schools);
		request.setAttribute("noOfPages", noOfPages);
		request.setAttribute("currentPage", page);

		request.getRequestDispatcher("WEB-INF/search.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<School> schools = null;
		int page = 1;
		String button = request.getParameter("act");
		SchoolDAOImpl daoSchools = (SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY)
				.getSchoolDAO();
		if (!button.isEmpty()) {
			if (button.equals("alpha")) {
				schools = daoSchools.pagination((page - 1) * SchoolAPIConstants.PAGE_SIZE, SchoolAPIConstants.PAGE_SIZE,
						"nom", "");
				noOfRecords = daoSchools.getAll().size();
			} else if (button.equals("note")) {
				// filter = true;
				// page = 1;
				// button = 3;
			} else if (button.equals("ecoles")) {
				schools = daoSchools.pagination((page - 1) * SchoolAPIConstants.PAGE_SIZE, SchoolAPIConstants.PAGE_SIZE,
						"type_d_etablissement", "Ecole");
				noOfRecords = daoSchools.getByCriteria("type_d_etablissement", "Ecole").size();
			} else if (button.equals("instituts")) {
				schools = daoSchools.pagination((page - 1) * SchoolAPIConstants.PAGE_SIZE, SchoolAPIConstants.PAGE_SIZE,
						"type_d_etablissement", "Institut");
				noOfRecords = daoSchools.getByCriteria("type_d_etablissement", "Institut").size();
			} else if (button.equals("ufr")) {
				schools = daoSchools.pagination((page - 1) * SchoolAPIConstants.PAGE_SIZE, SchoolAPIConstants.PAGE_SIZE,
						"type_d_etablissement", "Unit");
				noOfRecords = daoSchools.getByCriteria("type_d_etablissement", "Unit").size();
			} else if (button.equals("autre")) {
				schools = daoSchools.pagination((page - 1) * SchoolAPIConstants.PAGE_SIZE, SchoolAPIConstants.PAGE_SIZE,
						"type_d_etablissement", "Autre");
				noOfRecords = daoSchools.getByCriteria("type_d_etablissement", "Autre").size();
			} else {
				schools = daoSchools.pagination((page - 1) * SchoolAPIConstants.PAGE_SIZE, SchoolAPIConstants.PAGE_SIZE,
						"all", "");
				noOfRecords = daoSchools.getAll().size();
			}

			if (request.getParameter("button_search") != null) {
				schools = daoSchools.pagination((page - 1) * SchoolAPIConstants.PAGE_SIZE, SchoolAPIConstants.PAGE_SIZE,
						"type_d_etablissement", "");
				noOfRecords = daoSchools.getByCriteria("type_d_etablissement", "").size();
			}

			if (request.getParameter("page") != null)
				page = Integer.parseInt(request.getParameter("page"));
			schools = daoSchools.pagination((page - 1) * SchoolAPIConstants.PAGE_SIZE, SchoolAPIConstants.PAGE_SIZE,
					"all", "");
			noOfRecords = daoSchools.getAll().size();
		}

		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / SchoolAPIConstants.PAGE_SIZE);
		request.setAttribute("schoolList", schools);
		request.setAttribute("noOfPages", noOfPages);
		request.setAttribute("currentPage", page);
	}
}
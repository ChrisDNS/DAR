package com.upmc.parisup.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upmc.parisup.DAO.AbstractDAOFactory;
import com.upmc.parisup.DAO.Factory;
import com.upmc.parisup.DAO.SchoolDAO;
import com.upmc.parisup.DAO.DAOImpl.SchoolDAOImpl;
import com.upmc.parisup.business.School;

public class Search extends HttpServlet {
	private static final long serialVersionUID = 8564336809015917293L;
	int page = 1;
	int recordsPerPage = 10;
	int noOfRecords = 0;
	boolean filter = false;
	List<School> schools;
	int button;
	int noOfPages;
	String a_chercher = "";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		if (request.getParameter("button1") != null) {
			filter = true;
			page = 1;
			button = 1;
		}
		if (request.getParameter("button3") != null) {
			filter = true;
			page = 1;
			button = 3;
		} else if (request.getParameter("button4") != null) {
			filter = true;
			page = 1;
			button = 4;
		} else if (request.getParameter("button5") != null) {
			filter = true;
			page = 1;
			button = 5;
		} else if (request.getParameter("button6") != null) {
			filter = true;
			page = 1;
			button = 6;
		} else if (request.getParameter("buttonrecheche") != null) {
			filter = true;
			page = 1;
			button = 7;
			a_chercher = request.getParameter("recherche");
		}
		
		if (request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));
		
		if (filter) {
			switch(button) {
			case 1 :	schools = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO())
								.pagination((page - 1) * recordsPerPage, recordsPerPage,"nom","");
						noOfRecords = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO())
								.getAll().size();
				break;
			case 3 :	schools = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO())
								.pagination((page - 1) * recordsPerPage, recordsPerPage,"type_d_etablissement","Ecole");
						noOfRecords = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO())
								.getByCriteria("type_d_etablissement", "Ecole").size(); 
				break;
			case 4 :	schools = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO())
								.pagination((page - 1) * recordsPerPage, recordsPerPage,"type_d_etablissement", "Institut");
						noOfRecords = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO())
								.getByCriteria("type_d_etablissement", "Institut").size();
				break;
			case 5 :	schools = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO())
								.pagination((page - 1) * recordsPerPage, recordsPerPage,"type_d_etablissement", "Unit");
						noOfRecords = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO())
								.getByCriteria("type_d_etablissement", "Unit").size();

				break;
			case 6 :	schools = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO())
								.pagination((page - 1) * recordsPerPage, recordsPerPage, "type_d_etablissement", "Autre");
						noOfRecords = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO())
								.getByCriteria("type_d_etablissement", "Autre").size();

				break;
			case 7 :	schools = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO())
								.pagination((page - 1) * recordsPerPage, recordsPerPage, "type_d_etablissement", a_chercher);
						noOfRecords = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO())
								.getByCriteria("type_d_etablissement", a_chercher).size();

				break;
			default:	schools = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO())
								.pagination((page - 1) * recordsPerPage, recordsPerPage, "all","");
						noOfRecords = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO())
								.getAll().size();
				break;
			}
	
		} else {
			if (request.getParameter("page") != null)
				page = Integer.parseInt(request.getParameter("page"));

			schools = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY)
					.getSchoolDAO()).pagination((page - 1) * recordsPerPage, recordsPerPage,"all","");

			noOfRecords = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO())
					.getAll().size();
		}
		
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		request.setAttribute("schoolList", schools);
		request.setAttribute("noOfPages", noOfPages);
		request.setAttribute("currentPage", page);
		request.getRequestDispatcher("WEB-INF/search.jsp").forward(request, response);

	}

}
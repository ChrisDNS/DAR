package com.upmc.parisup.servlets;

import java.io.IOException;
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
	int page = 1;
	int recordsPerPage = 10;
	int noOfRecords = 0 ;
	boolean filter = false ;
	List<School> schools;
	int button;
	int noOfPages;
	String a_chercher ="";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		filter = false ;
		/*recuperer le num de la page demandee*/
		
		//if(request.getParameter("page") != null) 
			//page = Integer.parseInt(request.getParameter("page"));
			page = 1;
		
		schools = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO()).
				pagination((page-1)*recordsPerPage, recordsPerPage);
		
		//nombre total de page 
		
		noOfRecords = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO()).getAll().size();
		noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		
		
		//envoyer a la view
		request.setAttribute("schoolList", schools);
		request.setAttribute("noOfPages", noOfPages);
		request.setAttribute("currentPage", page);
		
		
		request.getRequestDispatcher("WEB-INF/search.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("button1") != null ) {
			filter = true;
			page = 1;
			button = 1 ;
		}if(request.getParameter("button3") != null) {
			filter = true;
			page = 1;
			button = 3 ;
		}else if(request.getParameter("button4") != null) {
			filter = true;
			page = 1;
			button = 4 ;
		}else if(request.getParameter("button5") != null) {
			filter = true;
			page = 1;
			button = 5 ;
		}else if(request.getParameter("button6") != null) {
			filter = true;
			page = 1;
			button = 6 ;
		}else if(request.getParameter("buttonrecheche") != null) {
			filter = true;
			page = 1;
			button = 7 ;
			a_chercher = request.getParameter("recherche");
			System.out.println("var recherche :"+a_chercher);
		}
		
		System.out.println("filter "+filter+" var rech "+a_chercher);
		if(filter) {
			/*recuperer le num de la page demandee*/
			
			if(request.getParameter("page") != null)
				page = Integer.parseInt(request.getParameter("page"));
			if(button == 1) {
			
				schools = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO()).
					pagination2((page-1)*recordsPerPage, recordsPerPage);
			//nombre total de page 
			  noOfRecords = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO()).getAll().size();
			
			
			}else if(button == 3) {
				 schools = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO()).
						pagination3((page-1)*recordsPerPage, recordsPerPage);
				//nombre total de page 
				  noOfRecords = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO()).getAllE().size();
				
			}else  if(button == 4) {
				 schools = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO()).
							paginationINSTITUT((page-1)*recordsPerPage, recordsPerPage);
					//nombre total de page 
					 noOfRecords = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO()).getAllI().size();
					
				}else if(button == 5) {
					 schools = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO()).
								paginationUFR((page-1)*recordsPerPage, recordsPerPage);
						//nombre total de page 
						 noOfRecords = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO()).getAllUFR().size();
						
					}else if(button == 6) {
						 schools = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO()).
									paginationAUTRE((page-1)*recordsPerPage, recordsPerPage);
							//nombre total de page 
							 noOfRecords = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO()).getAllAUTRE().size();
							
						}else if(button == 7) {
							
							 schools = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO()).
										paginationRECHERCHE((page-1)*recordsPerPage, recordsPerPage,a_chercher);
								//nombre total de page 
								 noOfRecords = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO()).getAllRECHERCHE(a_chercher).size();
								
							}else{
								    schools = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO()).
									pagination2((page-1)*recordsPerPage, recordsPerPage);
									//nombre total de page 
									 noOfRecords = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO()).getAllI().size();
								
								}
				
			
			System.out.println("post");
			
			
			
			//int noOfRecords = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO()).getAll().size();
			int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
			System.out.println("nb pages"+noOfRecords);
			//envoyer a la view
			request.setAttribute("schoolList", schools);
			request.setAttribute("noOfPages", noOfPages);
			request.setAttribute("currentPage", page);
		
			request.getRequestDispatcher("WEB-INF/search.jsp").forward(request, response);
		}else {
			if(request.getParameter("page") != null)
				page = Integer.parseInt(request.getParameter("page"));
			
			List<School> schools = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO()).
					pagination((page-1)*recordsPerPage, recordsPerPage);
			
			//nombre total de page 
			
			noOfRecords = ((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO()).getAll().size();
			int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
			
			
			//envoyer a la view
			request.setAttribute("schoolList", schools);
			request.setAttribute("noOfPages", noOfPages);
			request.setAttribute("currentPage", page);
			
			
			request.getRequestDispatcher("WEB-INF/search.jsp").forward(request, response);
			
		}

	}
	
}
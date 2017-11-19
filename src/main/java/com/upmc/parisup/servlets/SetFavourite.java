package com.upmc.parisup.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.upmc.parisup.DAO.AbstractDAOFactory;
import com.upmc.parisup.DAO.Factory;
import com.upmc.parisup.DAO.SchoolDAO;
import com.upmc.parisup.DAO.SelectedSchoolDAO;
import com.upmc.parisup.DAO.DAOImpl.SchoolDAOImpl;
import com.upmc.parisup.DAO.DAOImpl.SelectedSchoolDAOImpl;
import com.upmc.parisup.business.SelectedSchool;
import com.upmc.parisup.business.User;
import com.upmc.parisup.services.UserService;
import com.upmc.parisup.services.Util;

public class SetFavourite extends HttpServlet {
	private static final long serialVersionUID = 5288887076145694915L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService us = new UserService();
		SchoolDAO sdao = (SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO();
		SelectedSchoolDAO ssdao = (SelectedSchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY)
				.getSelectedSchoolDAO();
		JSONObject json = new JSONObject();
		
		String action = request.getParameter("action");
		String uai = request.getParameter("uai");

		User u = us.getCurrentUser(request);

		List<SelectedSchool> userListSS = ssdao.getByUserID(u.getId());

		if (action.equals("fav")) {
			SelectedSchool ss = new SelectedSchool();
			ss.setIdSchool(sdao.getByUAI(uai).getId());
			ss.setIdUser(u.getId());
			ssdao.add(ss);

		} else if (action.equals("not_fav")) {
			userListSS.forEach(school -> {
				if (school.getIdSchool() == sdao.getByUAI(uai).getId()) {
					ssdao.getByUserID(u.getId()).remove(school);
					ssdao.delete(school);
				}
			});

		} else {
			for (SelectedSchool ss : userListSS) {
				if (ss.getIdSchool() != sdao.getByUAI(uai).getId())
					continue;

				json.put("success", true);
				break;
			}
		}

		Util.sendJSON(response, json);
	}
}
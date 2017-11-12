package com.upmc.parisup.DAO.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.upmc.parisup.DAO.SelectedSchoolDAO;
import com.upmc.parisup.business.SelectedSchool;

public class SelectedSchoolDAOImpl extends MyPostgreSQLDAOImpl<SelectedSchool> implements SelectedSchoolDAO {

	public SelectedSchoolDAOImpl(Class<SelectedSchool> t) {
		super(t);
	}
	
	public List<SelectedSchool> getByUserID(long id) {
		String req = "FROM SelectedSchool u WHERE u.idUser=" + id;
		Session session = sql.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery(req);
		List<SelectedSchool> l = (List<SelectedSchool>) query.list();
		session.getTransaction().commit();

		return l;
	}
}
package com.upmc.parisup.DAO.DAOImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.upmc.parisup.DAO.SchoolDAO;
import com.upmc.parisup.business.School;

public class SchoolDAOImpl extends MyPostgreSQLDAOImpl<School> implements SchoolDAO {

	public SchoolDAOImpl(Class<School> t) {
		super(t);
	}

	@Override
	public School getByUAI(String uai) {
		String req = "FROM School s WHERE s.code_uai=" + "'" + uai + "'";

		Session session = sql.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Query query = session.createQuery(req);
		School s = null;
		if (query.list().size() == 1)
			s = (School) query.list().get(0);

		session.getTransaction().commit();

		return s;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<School> getByKeyWords(List<String> keyWords) {
		List<School> list = new ArrayList<School>();

		for (String kw : keyWords) {
			String req = "FROM School s WHERE s.nom LIKE '%" + kw + "%'";

			Session session = sql.getSessionFactory().getCurrentSession();
			session.beginTransaction();

			Query query = session.createQuery(req);
			list.addAll(query.list());

			session.getTransaction().commit();
		}

		return list;
	}
}
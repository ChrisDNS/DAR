package com.upmc.parisup.DAO.DAOImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.upmc.parisup.DAO.RatingDAO;
import com.upmc.parisup.business.Rating;

public class RatingDAOImpl extends MyPostgreSQLDAOImpl<Rating> implements RatingDAO {

	public RatingDAOImpl(Class<Rating> t) {
		super(t);
	}

	@Override
	public List<Rating> getAllByDateDescAndSchoolID(Long idSchool) {
		List<Rating> list = getAllByDateDesc();

		List<Rating> ret = new ArrayList<Rating>();
		list.forEach(r -> {
			if (r.getIdSchool().equals(idSchool))
				ret.add(r);
		});

		return ret;
	}

	@SuppressWarnings("unchecked")
	public List<Rating> getAllByDateDesc() {
		List<Rating> list;
		Session session = sql.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Criteria query = session.createCriteria(Rating.class);
		list = query.addOrder(Order.desc("date")).list();

		session.getTransaction().commit();

		return list;
	}
}
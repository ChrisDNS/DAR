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
			if (r.getIdSchool() == idSchool)
				ret.add(r);
		});

		return ret;
	}

	@Override
	public Long getAverageRateSchoolID(Long idSchool) {
		Long total = new Long(0);
		List<Rating> list = getAllByDateDesc();
		List<Rating> ret = new ArrayList<Rating>();

		for (Rating r : list) {
			if (r.getId() == idSchool) {
				ret.add(r);
				total += r.getRating();
			}
		}

		if (total != 0) {
			return total / ret.size();

		} else
			return total;
	}

	@SuppressWarnings("unchecked")
	private List<Rating> getAllByDateDesc() {
		List<Rating> list;
		Session session = sql.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Criteria query = session.createCriteria(Rating.class);
		list = query.addOrder(Order.desc("date")).list();

		session.getTransaction().commit();

		return list;
	}
}
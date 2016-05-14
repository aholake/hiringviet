package vn.com.hiringviet.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dao.ProvinceDAO;
import vn.com.hiringviet.model.Province;

@Repository
@Transactional
public class ProvinceDAOImpl implements ProvinceDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean addProvince(Province province) {

		Session session = this.sessionFactory.getCurrentSession();
		Integer result = (Integer) session.save(province);
		
		if (result > 0) {
			return true;
		}
		return false;
	}

}

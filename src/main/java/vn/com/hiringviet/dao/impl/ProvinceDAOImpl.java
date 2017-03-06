package vn.com.hiringviet.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dao.ProvinceDAO;
import vn.com.hiringviet.model.Province;

// TODO: Auto-generated Javadoc
/**
 * The Class ProvinceDAOImpl.
 */
@Repository
public class ProvinceDAOImpl extends CommonDAOImpl<Province> implements
		ProvinceDAO {

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.dao.ProvinceDAO#getProvinceListByCountry(int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Province> getProvinceListByCountry(int countryID) {
		String hql = "FROM Province P WHERE P.country.id = :countryID ORDER BY P.provinceName";
		Session session = getSession();
		Query hqlQuery = session.createQuery(hql);
		hqlQuery.setParameter("countryID", countryID);
		return hqlQuery.list();
	}

}

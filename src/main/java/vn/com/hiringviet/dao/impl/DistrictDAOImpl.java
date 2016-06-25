package vn.com.hiringviet.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dao.DistrictDAO;
import vn.com.hiringviet.model.District;

@Repository
public class DistrictDAOImpl extends CommonDAOImpl<District> implements DistrictDAO{

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<District> getDistrictByProvince(int provinceID) {
		String hql = "FROM District D WHERE D.province.id = :provinceID ORDER BY D.districtName";
		Session session = getSession();
		Query hqlQuery = session.createQuery(hql);
		hqlQuery.setParameter("provinceID", provinceID);
		return hqlQuery.list();
	}

}

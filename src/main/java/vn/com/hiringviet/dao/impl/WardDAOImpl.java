package vn.com.hiringviet.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dao.WardDAO;
import vn.com.hiringviet.model.Ward;

@Repository
public class WardDAOImpl extends CommonDAOImpl<Ward> implements WardDAO{

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Ward> getWardListByDistrict(int districtID) {
		String hql = "FROM Ward W WHERE W.district.id = :districtID ORDER BY W.wardName";
		Session session = getSession();
		Query hqlQuery = session.createQuery(hql);
		hqlQuery.setParameter("districtID", districtID);
		return hqlQuery.list();
	}
	
}

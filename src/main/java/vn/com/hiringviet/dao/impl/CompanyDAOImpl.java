package vn.com.hiringviet.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.common.StatusRecordEnum;
import vn.com.hiringviet.dao.CompanyDAO;
import vn.com.hiringviet.model.Company;

@Repository
@Transactional
public class CompanyDAOImpl extends CommonDAOImpl<Company> implements CompanyDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> getListCompanyHot(Integer first, Integer max) {

		StringBuilder hql = new StringBuilder();
		hql.append("FROM Company as c ");
		hql.append("WHERE c.changeLog.status = :status ");
		hql.append("ORDER BY c.changeLog.createdDate");
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery(hql.toString());
		query.setFirstResult(first);
		query.setMaxResults(max);

		query.setParameter("status", StatusRecordEnum.ACTIVE.getValue());

		List<Company> companyList = query.list();
		return companyList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> getListCompanySuggest(Integer first, Integer max) {

		StringBuilder hql = new StringBuilder();
		hql.append("FROM Company as c ");
		hql.append("WHERE c.changeLog.status = :status ");
		hql.append("ORDER BY c.changeLog.createdDate");
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery(hql.toString());
		query.setFirstResult(first);
		query.setMaxResults(max);

		query.setParameter("status", StatusRecordEnum.ACTIVE.getValue());

		List<Company> companyList = query.list();
		return companyList;
	}
}

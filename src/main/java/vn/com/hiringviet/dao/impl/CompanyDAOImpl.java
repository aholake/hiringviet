package vn.com.hiringviet.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
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

	@Override
	public Company getCompany(boolean loadJob) {

		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Company.class, "company");

		ProjectionList projections = Projections.projectionList();
		projections.add(Projections.property("company.id"));
		projections.add(Projections.property("company.displayName"));
		projections.add(Projections.property("company.companySize"));
		projections.add(Projections.property("company.address"));
		projections.add(Projections.property("company.hostCountry"));
		projections.add(Projections.property("company.businessField"));
		projections.add(Projections.property("company.description"));
		projections.add(Projections.property("company.foundedYear"));
		projections.add(Projections.property("company.avatar"));
		projections.add(Projections.property("company.coverImage"));
		projections.add(Projections.property("company.website"));
		projections.add(Projections.property("company.country"));
		projections.add(Projections.property("company.isVip"));
		projections.add(Projections.property("company.changeLog"));
		projections.add(Projections.property("company.companyPhotoList"));

		if (loadJob) {
			projections.add(Projections.property("company.jobList"));
		} else {
			projections.add(Projections.property("company.jobPosts"));
		}

		criteria.setProjection(projections);

		Company company = (Company) criteria.uniqueResult();
		return company;
	}
}

package vn.com.hiringviet.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dao.ConnectDAO;
import vn.com.hiringviet.model.Connect;

@Repository
@Transactional
public class ConnectDAOImpl extends CommonDAOImpl<Connect> implements ConnectDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Connect getConnectByMemberId(Integer formMemberId, Integer toMemberId) {

		Session session = this.sessionFactory.getCurrentSession();

		StringBuilder hql = new StringBuilder();
		hql.append("FROM Connect ");
		hql.append("WHERE (fromMember.id = :formMemberId AND toMember.id = :toMemberId) ");
		hql.append("OR (fromMember.id = :toMemberId AND toMember.id = :formMemberId) ");

		Query query = session.createQuery(hql.toString());
		query.setParameter("formMemberId", formMemberId);
		query.setParameter("toMemberId", toMemberId);

		Connect connect = (Connect) query.uniqueResult();
		return connect;
	}

}

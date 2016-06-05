package vn.com.hiringviet.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.common.StatusRecordEnum;
import vn.com.hiringviet.dao.AccountDAO;
import vn.com.hiringviet.model.Account;

@Repository
@Transactional
public class AccountDAOImpl implements AccountDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Account checkLogin(String email, String password) {

		Session session = this.sessionFactory.getCurrentSession();

		StringBuilder hql = new StringBuilder();
		hql.append("FROM Account ");
		hql.append(" WHERE status = :status ");
		hql.append(" AND email = :email ");
		hql.append(" AND password = :password ");

		Query query = session.createQuery(hql.toString());
		query.setParameter("status", StatusRecordEnum.ACTIVE.getValue());
		query.setParameter("email", email);
		query.setParameter("password", password);

		Account account = (Account) query.uniqueResult();

		return account;
	}

}
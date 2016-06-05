package vn.com.hiringviet.dao.impl;

import java.util.List;

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

	@SuppressWarnings("unchecked")
	@Override
	public boolean isExistedAccount(String email) {
		// TODO Auto-generated method stub
		System.out.println("check email " + email);
		Session session = this.sessionFactory.getCurrentSession();
		StringBuilder sb = new StringBuilder();
		sb.append("FROM Account ");
		sb.append("WHERE email = :email");
		Query query = session.createQuery(sb.toString());
		query.setParameter("email", email);

		Account account = (Account) query.uniqueResult();
		if (account == null) {
			return false;
		}
		return true;
	}

}

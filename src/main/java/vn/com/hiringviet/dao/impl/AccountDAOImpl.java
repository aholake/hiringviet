package vn.com.hiringviet.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.common.StatusRecordEnum;
import vn.com.hiringviet.dao.AccountDAO;
import vn.com.hiringviet.model.Account;

@Repository
@Transactional
public class AccountDAOImpl extends CommonDAOImpl<Account> implements
		AccountDAO {
	private static final Logger LOGGER = Logger.getLogger(AccountDAOImpl.class);

	@Override
	public Account checkLogin(String email, String password) {
		Session session = getSession();
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
		Session session = getSession();
		StringBuilder sb = new StringBuilder();
		sb.append("FROM Account ");
		sb.append("WHERE email = :email");
		Query query = session.createQuery(sb.toString());
		query.setParameter("email", email);

		List<Account> list = query.list();
		if (list.isEmpty()) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Account getAccountByEmail(String email) {
		String hql = "FROM Account WHERE email = :email";
		Query query = getSession().createQuery(hql);
		query.setParameter("email", email);
		List<Account> accounts = query.list();
		if (accounts.isEmpty()) {
			return null;
		}
		return accounts.get(0);
	}
}

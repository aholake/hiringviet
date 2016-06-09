package vn.com.hiringviet.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.common.StatusRecordEnum;
import vn.com.hiringviet.dao.MemberDAO;
import vn.com.hiringviet.model.Member;

@Repository
@Transactional
public class MemberDAOImpl extends CommonDAOImpl<Member> implements MemberDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Member getMemberByAccountId(Integer accountId) {
		Session session = this.sessionFactory.getCurrentSession();

		StringBuilder hql = new StringBuilder();
		hql.append("FROM Member as m ");
		hql.append("WHERE m.changeLog.status = :status ");
		hql.append("AND m.account.id = :accountId ");

		Query query = session.createQuery(hql.toString());
		query.setParameter("status", StatusRecordEnum.ACTIVE.getValue());
		query.setParameter("accountId", accountId);

		Member result = (Member) query.uniqueResult();

		return result;
	}
}

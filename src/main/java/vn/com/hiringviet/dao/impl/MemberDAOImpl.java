package vn.com.hiringviet.dao.impl;

import java.util.List;

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
public class MemberDAOImpl extends CommonDAOImpl<Member> implements MemberDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public boolean isExistEmail(String email) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		StringBuilder sb = new StringBuilder();
		sb.append("FROM member");
		sb.append("WHERE account.email = :email");

		Query query = session.createQuery(sb.toString());
		query.setParameter("email", email);
		List<Member> memberList = query.list();
		if (memberList.isEmpty()) {
			return false;
		}
		return true;
	}

	// @Autowired
	// private SessionFactory sessionFactory;
	//
	// public void setSessionFactory(SessionFactory sessionFactory) {
	// this.sessionFactory = sessionFactory;
	// }
	//
	// @Override
	// public Member checkLogin(String email, String password) {
	//
	// Session session = this.sessionFactory.getCurrentSession();
	//
	// StringBuilder hql = new StringBuilder();
	// hql.append("FROM Member ");
	// hql.append(" WHERE status = :status ");
	// hql.append(" AND email = :email ");
	// hql.append(" AND password = :password ");
	//
	// Query query = session.createQuery(hql.toString());
	// query.setParameter("status", StatusRecordEnum.ACTIVE.getValue());
	// query.setParameter("email", email);
	// query.setParameter("password", password);
	//
	// Member result = (Member) query.uniqueResult();
	// return result;
	// }
	//
	// @Override
	// public boolean addMember(Member member) {
	//
	// Session session = this.sessionFactory.getCurrentSession();
	//
	// Integer result = (Integer) session.save(member);
	//
	// if (result > 0) {
	// return true;
	// }
	// return false;
	// }
	//
	// @Override
	// public boolean activeAccount(Integer memberID) {
	//
	// Session session = this.sessionFactory.getCurrentSession();
	//
	// StringBuilder hql = new StringBuilder();
	// hql.append("UPDATE Member ");
	// hql.append(" SET status = :status ");
	// hql.append(" WHERE memberID = :memberID ");
	//
	// Query query = session.createQuery(hql.toString());
	// query.setParameter("status", StatusRecordEnum.ACTIVE.getValue());
	// query.setParameter("memberID", memberID);
	//
	// Integer result = (Integer) query.uniqueResult();
	//
	// if (result > 0) {
	// return true;
	// }
	// return false;
	// }
	//
	// @Override
	// public Member getMemberByteID(Integer memberID) {
	//
	// Session session = this.sessionFactory.getCurrentSession();
	//
	// Member member = (Member) session.get(Member.class, memberID);
	// return member;
	// }
}

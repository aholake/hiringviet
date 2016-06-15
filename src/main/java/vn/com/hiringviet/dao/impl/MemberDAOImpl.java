package vn.com.hiringviet.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
		Criteria criteria = session.createCriteria(Member.class, "member");
		criteria.createAlias("member.changeLog", "changeLog");
		criteria.createAlias("member.account", "account");
		criteria.add(Restrictions.eq("changeLog.status", StatusRecordEnum.ACTIVE.getValue()));
		criteria.add(Restrictions.eq("account.id", accountId));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		Member result = (Member) criteria.uniqueResult();

		return result;
	}
}

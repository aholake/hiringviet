package vn.com.hiringviet.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dao.EndorseDAO;
import vn.com.hiringviet.model.Endorse;

@Repository
@Transactional
public class EndorseDAOImpl extends CommonDAOImpl<Endorse> implements EndorseDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean deleteByAccountId(Integer accountId, Integer skillResumeId) {

		Session session = this.sessionFactory.getCurrentSession();

		StringBuilder hql = new StringBuilder();
		hql.append("DELETE FROM endorse ");
		hql.append("WHERE account_id = :accountId ");
		hql.append("AND skill_resume_id = :skillResumeId");

		Query query = session.createSQLQuery(hql.toString());
		query.setParameter("skillResumeId", skillResumeId);
		query.setParameter("accountId", accountId);

		Integer result = query.executeUpdate();

		if (result > 0) {
			return true;
		}
		return false;
	}

}

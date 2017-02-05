package vn.com.hiringviet.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.common.StatusEnum;
import vn.com.hiringviet.dao.FollowDAO;
import vn.com.hiringviet.model.Follow;

/**
 * The Class FollowDAOImpl.
 */
@Repository
@Transactional
public class FollowDAOImpl extends CommonDAOImpl<Follow> implements FollowDAO {

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Sets the session factory.
	 *
	 * @param sessionFactory the new session factory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.dao.FollowDAO#countNumberOfFollower(java.lang.Integer)
	 */
	@Override
	public Long countNumberOfFollower(Integer accountId) {

		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Follow.class, "follow");
		criteria.createAlias("follow.toAccount", "account");
		criteria.createAlias("follow.changeLog", "changeLog");
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.add(Restrictions.eq("account.id", accountId));
		criteria.add(Restrictions.eq("changeLog.status", StatusEnum.ACTIVE));
		criteria.setProjection(Projections.projectionList().add(Projections.rowCount()));

		Long result = (Long) criteria.uniqueResult();

		if (result > 0) {
			return result;
		}
		return 0L;
	}
}

package vn.com.hiringviet.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.common.PublishResponseEnum;
import vn.com.hiringviet.common.StatusEnum;
import vn.com.hiringviet.constant.ConstantValues;
import vn.com.hiringviet.dao.CompanyDAO;
import vn.com.hiringviet.dto.CompanyDTO;
import vn.com.hiringviet.dto.PostDTO;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.model.Company;
import vn.com.hiringviet.model.Job;
import vn.com.hiringviet.model.Post;

// TODO: Auto-generated Javadoc
/**
 * The Class CompanyDAOImpl.
 */
@Repository
@Transactional
public class CompanyDAOImpl extends CommonDAOImpl<Company> implements
		CompanyDAO {

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
	 * @see vn.com.hiringviet.dao.CompanyDAO#getListCompanyHot(java.lang.Integer, java.lang.Integer)
	 */
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

		query.setParameter("status", StatusEnum.ACTIVE);

		List<Company> companyList = query.list();
		return companyList;
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.dao.CompanyDAO#getListCompanySuggest(java.lang.Integer, java.lang.Integer)
	 */
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

		query.setParameter("status", StatusEnum.ACTIVE);

		List<Company> companyList = query.list();
		return companyList;
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.dao.CompanyDAO#getListPosts(java.lang.Integer, java.lang.Integer, java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PostDTO> getListPosts(Integer first, Integer max, Integer companyId) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Post.class, "post");
		criteria.createAlias("post.company", "company");
		criteria.createAlias("post.changeLog", "changeLog");
		criteria.createAlias("post.commentSet", "commentSet", JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.eq("company.id", companyId));
		criteria.add(Restrictions.eq("changeLog.status", StatusEnum.ACTIVE));
		criteria.setProjection(Projections.projectionList()
				.add(Projections.groupProperty("post.id").as("id"))
				.add(Projections.property("post.title").as("title"))
				.add(Projections.property("post.description").as("description"))
				.add(Projections.property("post.changeLog").as("changeLog"))
				.add(Projections.count("commentSet.id").as("numberComment")));
		criteria.setFirstResult(first);
		criteria.setMaxResults(max);
		criteria.addOrder(Order.desc("changeLog.createdDate"));
		criteria.setResultTransformer(Transformers.aliasToBean(PostDTO.class));

		List<PostDTO> result = (List<PostDTO>) criteria.list();
		return result;
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.dao.CompanyDAO#getListJob(java.lang.Integer, java.lang.Integer, java.lang.Integer, boolean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Job> getListJob(Integer first, Integer max, Integer companyId, boolean getAll) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Job.class, "job");
		criteria.createAlias("job.company", "company");
		criteria.createAlias("job.changeLog", "changeLog");

		criteria.add(Restrictions.eq("company.id", companyId));
		criteria.add(Restrictions.eq("changeLog.status", StatusEnum.ACTIVE));

		if (!getAll) {
			criteria.add(Restrictions.eq("job.publish", PublishResponseEnum.PUBLISH.getValue()));
		}

		criteria.setFirstResult(first);
		criteria.setMaxResults(max);
		criteria.addOrder(Order.desc("changeLog.createdDate"));

		List<Job> result = (List<Job>) criteria.list();
		return result;
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.dao.CompanyDAO#getCompanyByAccount(vn.com.hiringviet.model.Account)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Company getCompanyByAccount(Account account) {
		String hql = "FROM Company WHERE account=:account";
		Session session = getSession();
		Query query = session.createQuery(hql);
		query.setParameter("account", account);
		List<Company> list = query.list();
		return list.isEmpty() ? null : list.get(0);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.dao.CompanyDAO#getListCompanySuggest(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CompanyDTO> getListCompanySuggest(String keywork) {

		Session session = this.sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Company.class, "company");
		criteria.createAlias("company.changeLog", "changeLog");
		criteria.createAlias("company.account", "account", JoinType.LEFT_OUTER_JOIN);
		criteria.setProjection(Projections.projectionList()
				.add(Projections.groupProperty("company.id").as("id"))
				.add(Projections.property("company.displayName").as("displayName"))
				.add(Projections.property("account.avatarImage").as("avatarImage"))
				.add(Projections.count("account.toFollows").as("numberFollower"))
				.add(Projections.property("company.companySize").as("companySize"))
				.add(Projections.property("company.businessField").as("businessField")));
		criteria.add(Restrictions.like("company.displayName", keywork + "%"));
		criteria.addOrder(Order.desc("company.isVip"));
		criteria.addOrder(Order.desc("numberFollower"));
		criteria.setMaxResults(ConstantValues.MAX_RECORD_COUNT);
		criteria.setResultTransformer(Transformers.aliasToBean(CompanyDTO.class));

		List<CompanyDTO> companyDTOs = (List<CompanyDTO>) criteria.list();
		return companyDTOs;
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.dao.CompanyDAO#getListCompanyFollow(java.lang.Integer)
	 */
	@Override
	public List<CompanyDTO> getListCompanyFollow(Integer accountId) {

		StringBuffer sb = new StringBuffer();
		sb.append("SELECT ");
		sb.append("c.id AS id, ");
		sb.append("c.display_name AS displayName, ");
		sb.append("a.avatar_image AS avatarImage ");
		sb.append("FROM company c ");
		sb.append("INNER JOIN account a ON a.id = c.account_id ");
		sb.append("LEFT JOIN follow f ON a.id = f.to_account ");
		sb.append("WHERE f.from_account = :accountId");

		Query query = getSession().createSQLQuery(sb.toString());
		query.setParameter("accountId", accountId);

		query.setResultTransformer(Transformers.aliasToBean(CompanyDTO.class));

		List<CompanyDTO> companyDTOs = query.list();
		if (companyDTOs.isEmpty()) {
			return null;
		}
		return companyDTOs;
	}
}

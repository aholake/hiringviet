package vn.com.hiringviet.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.common.SkillTypeEnum;
import vn.com.hiringviet.constant.ConstantValues;
import vn.com.hiringviet.dao.SkillDAO;
import vn.com.hiringviet.dto.SkillDTO;
import vn.com.hiringviet.model.Skill;

// TODO: Auto-generated Javadoc
/**
 * The Class SkillDAOImpl.
 */
@Repository
@Transactional
public class SkillDAOImpl extends CommonDAOImpl<Skill> implements SkillDAO {

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
	 * @see vn.com.hiringviet.dao.SkillDAO#searchSkillByKeyWord(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SkillDTO> searchSkillByKeyWord(String keyWord) {

		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Skill.class, "skill");
		criteria.setProjection(Projections.projectionList()
				.add(Projections.property("id"), "id")
				.add(Projections.property("displayName"), "displayName")
				.add(Projections.property("addingNumber"), "addingNumber"));
		criteria.add(Restrictions.like("displayName", keyWord.replace("\"", "") + "%"));
		criteria.add(Restrictions.eq("type", SkillTypeEnum.TOP.getValue()));
		criteria.setMaxResults(ConstantValues.MAX_RECORD_COUNT);
		criteria.setResultTransformer(Transformers.aliasToBean(SkillDTO.class));

		List<SkillDTO> skillDTOs = (List<SkillDTO>) criteria.list();

		return skillDTOs;
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.dao.SkillDAO#subAddingNumber(java.lang.Integer)
	 */
	@Override
	public boolean subAddingNumber(Integer skillId) {

		Session session = this.sessionFactory.getCurrentSession();

		StringBuilder hql = new StringBuilder();
		hql.append("UPDATE Skill SET addingNumber = (addingNumber - 1) WHERE id = :skillId");
		Query query = session.createSQLQuery(hql.toString());
		query.setParameter("skillId", skillId);

		if (query.executeUpdate() > 0) {
			return true;
		}

		return false;
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.dao.SkillDAO#getSkillByDisplayName(java.lang.String)
	 */
	@Override
	public Skill getSkillByDisplayName(String displayName) {

		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Skill.class, "skill");
		criteria.add(Restrictions.eq("displayName", displayName));

		Skill skill = (Skill) criteria.uniqueResult();
		return skill;
	}

}

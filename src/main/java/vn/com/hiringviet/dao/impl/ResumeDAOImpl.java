package vn.com.hiringviet.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.common.StatusEnum;
import vn.com.hiringviet.dao.ResumeDAO;
import vn.com.hiringviet.dao.SkillDAO;
import vn.com.hiringviet.model.Resume;

// TODO: Auto-generated Javadoc
/**
 * The Class ResumeDAOImpl.
 */
@Repository
@Transactional
public class ResumeDAOImpl extends CommonDAOImpl<Resume> implements ResumeDAO {

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;

	/** The Skill dao. */
	@Autowired
	private SkillDAO SkillDAO;

	/**
	 * Sets the session factory.
	 *
	 * @param sessionFactory the new session factory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.dao.ResumeDAO#getListSkillByMemberId(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getListSkillByMemberId(Integer memberId) {

		Session session = this.sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Resume.class, "resume");
		criteria.createAlias("resume.member", "member");
		criteria.createAlias("resume.changeLog", "changeLog");
		criteria.createAlias("resume.skillResumeSet", "skillResumeSet");
		criteria.add(Restrictions.eq("member.id", memberId));
		criteria.add(Restrictions.eq("changeLog.status", StatusEnum.ACTIVE));
		criteria.setProjection(Projections.projectionList().add(Projections.property("skillResumeSet.skill.id")));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Integer> skills = criteria.list();
		return skills;
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.dao.ResumeDAO#updatePhoneNumber(java.lang.Integer, java.lang.String)
	 */
	@Override
	public boolean updatePhoneNumber(Integer resumeId, String phoneNumber) {

		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE ");
		sb.append("resume ");
		sb.append("SET phone_number = :phoneNumber ");
		sb.append("WHERE id = :resumeId");
		Query query = getSession().createSQLQuery(sb.toString());
		query.setParameter("phoneNumber", phoneNumber);
		query.setParameter("resumeId", resumeId);

		if (query.executeUpdate() > 0) {
			return true;
		}

		return false;
	}

//	@Override
//	public boolean deleteSkillOfProfile(ResumeDTO resumeDTO) {
//
//		Session session = this.sessionFactory.getCurrentSession();
//
//		StringBuilder hql = new StringBuilder();
//		hql.append("DELETE FROM hiringviet.skill_resume ");
//		hql.append("WHERE resume_id = :resumeId ");
//		hql.append("AND skill_id = :skillId");
//
//		Query query = session.createSQLQuery(hql.toString());
//		query.setParameter("resumeId", resumeDTO.getResumeId());
//		query.setParameter("skillId", resumeDTO.getSkillId());
//
//		Integer result = query.executeUpdate();
//
//		if (result > 0) {
//			SkillDAO.subAddingNumber(resumeDTO.getSkillId());
//			return true;
//		}
//		return false;
//	}

}

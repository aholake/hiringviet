package vn.com.hiringviet.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.common.StatusRecordEnum;
import vn.com.hiringviet.dao.ResumeDAO;
import vn.com.hiringviet.dao.SkillDAO;
import vn.com.hiringviet.model.Resume;

@Repository
@Transactional
public class ResumeDAOImpl extends CommonDAOImpl<Resume> implements ResumeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private SkillDAO SkillDAO;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getListSkillByMemberId(Integer memberId) {

		Session session = this.sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Resume.class, "resume");
		criteria.createAlias("resume.member", "member");
		criteria.createAlias("resume.changeLog", "changeLog");
		criteria.createAlias("resume.skillResumeSet", "skillResumeSet");
		criteria.add(Restrictions.eq("member.id", memberId));
		criteria.add(Restrictions.eq("changeLog.status", StatusRecordEnum.ACTIVE.getValue()));
		criteria.setProjection(Projections.projectionList().add(Projections.property("skillResumeSet.skill.id")));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Integer> skills = criteria.list();
		return skills;
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

package vn.com.hiringviet.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.constant.ConstantValues;
import vn.com.hiringviet.dao.SkillDAO;
import vn.com.hiringviet.dto.SkillDTO;
import vn.com.hiringviet.model.Skill;

@Repository
@Transactional
public class SkillDAOImpl extends CommonDAOImpl<Skill> implements SkillDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SkillDTO> searchSkillByKeyWord(String keyWord) {

		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Skill.class, "skill");
		criteria.setProjection(Projections.projectionList()
				.add(Projections.property("id"), "id")
				.add(Projections.property("displayName"), "displayName"));
		criteria.add(Restrictions.like("displayName", keyWord.replace("\"", "") + "%"));
		criteria.setMaxResults(ConstantValues.MAX_RECORD_COUNT);
		criteria.setResultTransformer(Transformers.aliasToBean(SkillDTO.class));

		List<SkillDTO> skillDTOs = (List<SkillDTO>) criteria.list();

		return skillDTOs;
	}

}

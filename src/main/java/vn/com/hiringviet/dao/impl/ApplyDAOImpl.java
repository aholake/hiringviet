package vn.com.hiringviet.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dao.ApplyDAO;
import vn.com.hiringviet.model.Apply;
import vn.com.hiringviet.model.Job;

@Repository
@Transactional
public class ApplyDAOImpl extends CommonDAOImpl<Apply> implements ApplyDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Apply> getApplies(Job job) {
		Session session = getSession();
		Criteria criteria = session.createCriteria(Apply.class);
		criteria.add(Restrictions.eq("job", job));
		return criteria.list();
	}
	
	@Override
	public void addApplyByNativeSQL(Apply apply) {
		Session session = getSession();
		SQLQuery sqlQuery = session
				.createSQLQuery("INSERT INTO apply (curriculumVitae, disscription, job_id, member_id, accepted) VALUES (?,?,?,?,?)");
		Query hibernateQuery = sqlQuery.setParameter(0, apply.getCurriculumVitae())
				.setParameter(1, apply.getDisscription())
				.setParameter(2, apply.getJob().getId())
				.setParameter(3, apply.getMember().getId())
				.setParameter(4, apply.isAccepted());
		hibernateQuery.executeUpdate();
	}
}

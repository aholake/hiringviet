package vn.com.hiringviet.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.common.StatusRecordEnum;
import vn.com.hiringviet.dao.JobDAO;
import vn.com.hiringviet.model.Job;
import vn.com.hiringviet.model.Skill;
import vn.com.hiringviet.util.Utils;

@Repository
@Transactional
public class JobDAOImpl extends CommonDAOImpl<Job> implements JobDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Job getJobByID(Integer jobId) {

		Session session = sessionFactory.getCurrentSession();

		Job job = (Job) session.get(Job.class, jobId);

		Hibernate.initialize(job.getSkillList());

		return job;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Job> getListJobHot(Integer first, Integer max, List<Skill> skills) {

		StringBuilder hql = new StringBuilder();
		hql.append("FROM Job as j ");
		hql.append("WHERE j.changeLog.status = :status ");
		hql.append("AND expiredDate >= NOW() ");

		if (!Utils.isEmptyList(skills)) {
			hql.append(generatorQuerySkill(skills));
		}

		hql.append(generatorQueryOrderBySalary());

		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery(hql.toString());
		query.setFirstResult(first);
		query.setMaxResults(max);

		query.setParameter("status", StatusRecordEnum.ACTIVE.getValue());

		List<Job> jobList = query.list();
		return jobList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Job> getListJobSuggest(Integer first, Integer max, List<Skill> skills) {

		StringBuilder hql = new StringBuilder();
		hql.append("FROM Job as j ");
		hql.append("WHERE j.changeLog.status = :status ");
		hql.append("ORDER BY j.changeLog.createdDate");
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery(hql.toString());
		query.setFirstResult(first);
		query.setMaxResults(max);

		query.setParameter("status", StatusRecordEnum.ACTIVE.getValue());

		List<Job> jobList = query.list();
		return jobList;
	}

	public String generatorQueryOrderBySalary() {
		StringBuilder hql = new StringBuilder();
		hql.append("ORDER BY j.changeLog.createdDate DESC, ");
		hql.append("j.minSalary DESC, ");
		hql.append("j.maxSalary DESC ");
		return hql.toString();
	}

	public String generatorQuerySkill(List<Skill> skills) {
		StringBuilder hql = new StringBuilder();
		hql.append("AND j.skillList.displayName IN (");
		Integer count = 0;
		for (Skill skill : skills) {
			count++;
			if (count == skills.size()) {
				hql.append(skill.getDisplayName());
			} else {
				hql.append(skill.getDisplayName() +", ");
			}
		}
		hql.append(") ");
		return hql.toString();
	}
}

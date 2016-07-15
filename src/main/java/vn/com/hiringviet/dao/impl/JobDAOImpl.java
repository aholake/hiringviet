package vn.com.hiringviet.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.common.StatusRecordEnum;
import vn.com.hiringviet.dao.JobDAO;
import vn.com.hiringviet.model.Job;
import vn.com.hiringviet.util.DateUtil;
import vn.com.hiringviet.util.Utils;

@Repository
@Transactional
public class JobDAOImpl extends CommonDAOImpl<Job> implements JobDAO {
	@Override
	public Job getJobByID(Integer jobId) {

		Session session = getSession();

		Job job = (Job) session.get(Job.class, jobId);

		Hibernate.initialize(job.getSkillSet());

		return job;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Job> getListJobHot(Integer first, Integer max, List<Integer> skills) {

		Session session = getSession();
		Criteria criteria = session.createCriteria(Job.class, "job");
		criteria.createAlias("job.changeLog", "changeLog");
		criteria.createAlias("job.company", "company");

		if (!Utils.isEmptyList(skills)) {
			criteria.createAlias("job.skillSet", "skillSet");
		}

		criteria.add(Restrictions.eq("changeLog.status", StatusRecordEnum.ACTIVE.getValue()));
		criteria.add(Restrictions.gt("job.expiredDate", DateUtil.now()));

		if (!Utils.isEmptyList(skills)) {
			criteria.add(Restrictions.in("skillSet.id", skills));
		}

		criteria.addOrder(Order.desc("company.isVip"));
		criteria.addOrder(Order.desc("changeLog.createdDate"));
		criteria.addOrder(Order.desc("job.minSalary"));
		criteria.addOrder(Order.desc("job.maxSalary"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.setFirstResult(first);
		criteria.setMaxResults(max);

		List<Job> jobList = criteria.list();
		return jobList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Job> getListJobSuggest(Integer first, Integer max, List<Integer> skills) {

		Session session = getSession();
		Criteria criteria = session.createCriteria(Job.class, "job");
		criteria.createAlias("job.changeLog", "changeLog");
		criteria.createAlias("job.company", "company");

		if (!Utils.isEmptyList(skills)) {
			criteria.createAlias("job.skillSet", "skillSet");
		}

		criteria.add(Restrictions.eq("changeLog.status", StatusRecordEnum.ACTIVE.getValue()));
		criteria.add(Restrictions.gt("job.expiredDate", DateUtil.now()));

		if (!Utils.isEmptyList(skills)) {
			criteria.add(Restrictions.in("skillSet.id", skills));
		}

		criteria.addOrder(Order.desc("company.isVip"));
		criteria.addOrder(Order.desc("changeLog.createdDate"));
		criteria.addOrder(Order.desc("job.minSalary"));
		criteria.addOrder(Order.desc("job.maxSalary"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.setFirstResult(first);
		criteria.setMaxResults(max);

		List<Job> jobList = criteria.list();
		return jobList;
	}
}

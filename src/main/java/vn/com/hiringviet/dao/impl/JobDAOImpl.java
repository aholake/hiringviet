package vn.com.hiringviet.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.common.StatusRecordEnum;
import vn.com.hiringviet.dao.JobDAO;
import vn.com.hiringviet.dto.JobDTO;
import vn.com.hiringviet.model.Job;

@Repository
@Transactional
public class JobDAOImpl extends CommonDAOImpl<Job> implements JobDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ModelMapper modelMapper;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public JobDTO getJobByID(Integer jobID) {

		StringBuilder hql = new StringBuilder();
		hql.append("FROM Job as j ");
		hql.append("WHERE j.status = :status ");
		hql.append("AND j.jobID = :jobID");
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery(hql.toString());

		query.setParameter("status", StatusRecordEnum.ACTIVE.getValue());
		query.setParameter("jobID", jobID);

		JobDTO jobDTO = (JobDTO) query.uniqueResult();
		return jobDTO;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Job> getListJobHot(Integer first, Integer max) {

		StringBuilder hql = new StringBuilder();
		hql.append("FROM Job as j ");
		hql.append("WHERE j.status = :status ");
		hql.append("ORDER BY j.createdAt");
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery(hql.toString());
		query.setFirstResult(first);
		query.setMaxResults(max);

		query.setParameter("status", StatusRecordEnum.ACTIVE.getValue());

		List<Job> jobList = query.list();
		return jobList;
	}

}

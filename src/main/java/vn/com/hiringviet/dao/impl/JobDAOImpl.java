package vn.com.hiringviet.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.api.dto.request.LoadMoreRequestDTO;
import vn.com.hiringviet.common.StatusEnum;
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

		Hibernate.initialize(job.getCommentSet());

		return job;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Job> getListJob(LoadMoreRequestDTO loadMoreRequestDTO, Integer first, Integer max, List<Integer> skills, boolean isHotJob) {

		Session session = getSession();
		Criteria criteria = session.createCriteria(Job.class, "job");
		criteria.createAlias("job.changeLog", "changeLog");
		criteria.createAlias("job.company", "company");
		criteria.createAlias("job.jobCategory", "jobCategory");
		criteria.createAlias("job.position", "position");
		criteria.createAlias("job.workAddress", "address", JoinType.LEFT_OUTER_JOIN);
		criteria.createAlias("address.district", "district", JoinType.LEFT_OUTER_JOIN);
		criteria.createAlias("district.province", "province", JoinType.LEFT_OUTER_JOIN);

		if (skills != null) {
			criteria.createAlias("job.skillSet", "skillSet");
		}

		criteria.add(Restrictions.eq("changeLog.status", StatusEnum.ACTIVE));

		criteria.add(Restrictions.gt("job.expiredDate", DateUtil.now()));

		if (!Utils.isEmptyList(skills)) {
			criteria.add(Restrictions.in("skillSet.id", skills));
		}

		if (loadMoreRequestDTO != null) {

			if (!Utils.isEmptyList(loadMoreRequestDTO.getCategoryNameList())) {
				criteria.add(Restrictions.in("jobCategory.categoryName", loadMoreRequestDTO.getCategoryNameList()));
			}

			if (!Utils.isEmptyList(loadMoreRequestDTO.getCompanyNameList())) {
				criteria.add(Restrictions.in("company.displayName", loadMoreRequestDTO.getCompanyNameList()));
			}
	
			if (!Utils.isEmptyList(loadMoreRequestDTO.getPositionNameList())) {
				criteria.add(Restrictions.in("position.displayName", loadMoreRequestDTO.getPositionNameList()));
			}
	
			if (!Utils.isEmptyList(loadMoreRequestDTO.getProvinceNameList())) {
				criteria.add(Restrictions.in("province.provinceName", loadMoreRequestDTO.getProvinceNameList()));
			}
	
//			if (!Utils.isEmptyList(loadMoreRequestDTO.getSkillNameList())) {
//				criteria.add(Restrictions.in("skillSet.displayName", loadMoreRequestDTO.getSkillNameList()));
//			}

			if (!Utils.isEmptyNumber(loadMoreRequestDTO.getMaxSalary())) {
				criteria.add(Restrictions.between("job.maxSalary", loadMoreRequestDTO.getMinSalary(), loadMoreRequestDTO.getMaxSalary()));
			}

			if (!Utils.isEmptyNumber(loadMoreRequestDTO.getDateAgo())) {
				criteria.add(Restrictions.between("job.postDate", DateUtil.getDateAgo(loadMoreRequestDTO.getDateAgo()), DateUtil.now()));
			}
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

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Job> getListJobSuggest(Integer first, Integer max, List<Integer> skills) {
//
//		Session session = getSession();
//		Criteria criteria = session.createCriteria(Job.class, "job");
//		criteria.createAlias("job.changeLog", "changeLog");
//		criteria.createAlias("job.company", "company");
//
//		if (!Utils.isEmptyList(skills)) {
//			criteria.createAlias("job.skillSet", "skillSet");
//		}
//
//		criteria.add(Restrictions.eq("changeLog.status", StatusEnum.ACTIVE.getValue()));
//		criteria.add(Restrictions.gt("job.expiredDate", DateUtil.now()));
//
//		if (!Utils.isEmptyList(skills)) {
//			criteria.add(Restrictions.in("skillSet.id", skills));
//		}
//
//		criteria.addOrder(Order.desc("company.isVip"));
//		criteria.addOrder(Order.desc("changeLog.createdDate"));
//		criteria.addOrder(Order.desc("job.minSalary"));
//		criteria.addOrder(Order.desc("job.maxSalary"));
//		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
//		criteria.setFirstResult(first);
//		criteria.setMaxResults(max);
//
//		List<Job> jobList = criteria.list();
//		return jobList;
//	}
}

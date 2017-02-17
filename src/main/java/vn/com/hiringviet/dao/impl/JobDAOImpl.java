package vn.com.hiringviet.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.api.dto.request.LoadMoreRequestDTO;
import vn.com.hiringviet.common.PublishResponseEnum;
import vn.com.hiringviet.common.SearchEnum;
import vn.com.hiringviet.common.StatusEnum;
import vn.com.hiringviet.constant.ConstantValues;
import vn.com.hiringviet.dao.JobDAO;
import vn.com.hiringviet.dto.JobDTO;
import vn.com.hiringviet.dto.SearchDTO;
import vn.com.hiringviet.model.ChangeLog;
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
	public List<Job> getListJob(LoadMoreRequestDTO loadMoreRequestDTO,
			Integer first, Integer max, List<Integer> skills, boolean isHotJob,
			String mode, String keyValue) {

		Session session = getSession();
		Criteria criteria = session.createCriteria(Job.class, "job");
		criteria.createAlias("job.changeLog", "changeLog");
		criteria.createAlias("job.company", "company");
		criteria.createAlias("job.jobCategory", "jobCategory");
		criteria.createAlias("job.position", "position");
		criteria.createAlias("job.workAddress", "address");
		criteria.createAlias("address.district", "district", JoinType.LEFT_OUTER_JOIN);
		criteria.createAlias("district.province", "province", JoinType.LEFT_OUTER_JOIN);

		if (skills != null
				&& (Utils.isEmptyString(mode)
						|| SearchEnum.ALL.getStatus().equals(mode) || SearchEnum.SKILL
						.getStatus().equals(mode))) {
			criteria.createAlias("job.skillSet", "skillSet");
		}

		criteria.add(Restrictions.eq("changeLog.status", StatusEnum.ACTIVE));

		criteria.add(Restrictions.eq("job.publish", PublishResponseEnum.PUBLISH.getValue()));
		criteria.add(Restrictions.gt("job.expiredDate", DateUtil.now()));

		if (!Utils.isEmptyList(skills)) {
			criteria.add(Restrictions.in("skillSet.id", skills));
		}

		if (SearchEnum.SKILL.getStatus().equals(mode)) {

		}

		if (loadMoreRequestDTO != null) {

			if (!Utils.isEmptyList(loadMoreRequestDTO.getCategoryNameList())) {
				criteria.add(Restrictions.in("jobCategory.categoryName",
						loadMoreRequestDTO.getCategoryNameList()));
			}

			if (!Utils.isEmptyList(loadMoreRequestDTO.getCompanyNameList())) {
				criteria.add(Restrictions.in("company.displayName",
						loadMoreRequestDTO.getCompanyNameList()));
			}

			if (!Utils.isEmptyList(loadMoreRequestDTO.getPositionNameList())) {
				criteria.add(Restrictions.in("position.displayName",
						loadMoreRequestDTO.getPositionNameList()));
			}

			if (!Utils.isEmptyList(loadMoreRequestDTO.getProvinceNameList())) {
				criteria.add(Restrictions.in("province.provinceName",
						loadMoreRequestDTO.getProvinceNameList()));
			}

			// if (!Utils.isEmptyList(loadMoreRequestDTO.getSkillNameList())) {
			// Disjunction disjunction = Restrictions.disjunction();
			// for (String skillName : loadMoreRequestDTO.getSkillNameList()) {
			// disjunction.add(Restrictions.or(Restrictions.sqlRestriction
			// ("FIND_IN_SET('" + skillName + "', skillSet)")));
			// }
			// criteria.add(disjunction);
			// }

			if (!Utils.isEmptyNumber(loadMoreRequestDTO.getMaxSalary())) {
				criteria.add(Restrictions.between("job.maxSalary",
						loadMoreRequestDTO.getMinSalary(),
						loadMoreRequestDTO.getMaxSalary()));
			}

			if (!Utils.isEmptyNumber(loadMoreRequestDTO.getDateAgo())) {
				criteria.add(Restrictions.between("job.postDate",
						DateUtil.getDateAgo(loadMoreRequestDTO.getDateAgo()),
						DateUtil.now()));
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

	@SuppressWarnings("unchecked")
	@Override
	public List<JobDTO> searchJobByKeyWord(String keyWord) {

		Session session = getSession();

		Criteria criteria = session.createCriteria(Job.class, "job");
		criteria.setProjection(Projections.projectionList()
				.add(Projections.property("id"), "id")
				.add(Projections.property("title"), "title"));
		criteria.add(Restrictions.eq("job.publish", PublishResponseEnum.PUBLISH.getValue()));
		criteria.add(Restrictions.like("title", "%" + keyWord.replace("\"", "")
				+ "%"));
		criteria.setMaxResults(ConstantValues.MAX_RECORD_COUNT);
		criteria.setResultTransformer(Transformers.aliasToBean(JobDTO.class));

		List<JobDTO> skillDTOs = (List<JobDTO>) criteria.list();

		return skillDTOs;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<JobDTO> getNewJobs(Integer companyId) {

		Session session = getSession();

		Criteria criteria = session.createCriteria(Job.class, "job");
		criteria.createAlias("job.changeLog", "changeLog", JoinType.LEFT_OUTER_JOIN);
		criteria.createAlias("job.company", "company", JoinType.LEFT_OUTER_JOIN);
		criteria.setProjection(Projections.projectionList()
				.add(Projections.property("id"), "id")
				.add(Projections.property("title"), "title")
				.add(Projections.property("postDate"), "postDate")
				.add(Projections.property("job.workAddress"), "address"));
		criteria.add(Restrictions.eq("company.id", companyId));
		criteria.add(Restrictions.eq("changeLog.status", StatusEnum.ACTIVE));
		criteria.add(Restrictions.eq("job.publish", PublishResponseEnum.PUBLISH.getValue()));
		criteria.setMaxResults(ConstantValues.MAX_RECORD_COUNT);
		criteria.setResultTransformer(Transformers.aliasToBean(JobDTO.class));
		criteria.addOrder(Order.desc("changeLog.createdDate"));
		List<JobDTO> skillDTOs = (List<JobDTO>) criteria.list();

		return skillDTOs;
	}

	@Override
	public boolean updateDescription(Integer jobId, String description) {
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE ");
		sb.append("job ");
		sb.append("SET description = :description ");
		sb.append("WHERE id = :jobId");
		Query query = getSession().createSQLQuery(sb.toString());
		query.setParameter("description", description);
		query.setParameter("jobId", jobId);

		if (query.executeUpdate() > 0) {
			return true;
		}

		return false;
	}

	@Override
	public boolean updateRequirement(Integer jobId, String requirement) {

		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE ");
		sb.append("job ");
		sb.append("SET requirement = :requirement ");
		sb.append("WHERE id = :jobId");
		Query query = getSession().createSQLQuery(sb.toString());
		query.setParameter("requirement", requirement);
		query.setParameter("jobId", jobId);

		if (query.executeUpdate() > 0) {
			return true;
		}

		return false;
	}

	@Override
	public boolean updateCompanyPolicies(Integer jobId, String cultureDescription) {

		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE ");
		sb.append("job ");
		sb.append("SET culture_description = :cultureDescription ");
		sb.append("WHERE id = :jobId");
		Query query = getSession().createSQLQuery(sb.toString());
		query.setParameter("cultureDescription", cultureDescription);
		query.setParameter("jobId", jobId);

		if (query.executeUpdate() > 0) {
			return true;
		}

		return false;
	}

	@Override
	public long countApplies(Job job) {
		Session session = getSession();
		Query query = session.createQuery("SELECT count(*) FROM Apply a WHERE a.job = ?");
		query.setParameter(0, job);
		return (long) query.uniqueResult();
	}

	@Override
	public boolean updateVisited(Integer jobId) {

		Query query = null;
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE job SET number_visited = (number_visited + 1) WHERE id = :jobId");
		query = getSession().createSQLQuery(sql.toString());
		query.setParameter("jobId", jobId);

		if (query.executeUpdate() <= 0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean setPublish(Integer jobId, Integer isPublish) {

		Query query = null;
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE job SET is_publish = :isPublish WHERE id = :jobId");
		query = getSession().createSQLQuery(sql.toString());
		query.setParameter("jobId", jobId);
		query.setParameter("isPublish", isPublish);

		if (query.executeUpdate() <= 0) {
			return false;
		}
		return true;
	}

	@Override
	public List<Job> searchJob(Integer first, Integer max, SearchDTO searchDTO) {

		Session session = getSession();
		Criteria criteria = session.createCriteria(Job.class, "job");
		criteria.createAlias("job.changeLog", "changeLog");
		criteria.createAlias("job.company", "company");
		criteria.createAlias("job.jobCategory", "jobCategory");
		criteria.createAlias("job.position", "position");
		criteria.createAlias("job.workAddress", "address");
		criteria.createAlias("address.district", "district", JoinType.LEFT_OUTER_JOIN);
		criteria.createAlias("district.province", "province", JoinType.LEFT_OUTER_JOIN);
		criteria.createAlias("job.skillSet", "skillSet");

		if (searchDTO.getSkillId() != null) {
			criteria.add(Restrictions.eq("skillSet.id", searchDTO.getSkillId()));
		}

		if (!StringUtils.isEmpty(searchDTO.getJobTitle())) {
			criteria.add(Restrictions.like("job.title", searchDTO.getJobTitle(), MatchMode.ANYWHERE));
		}

		if (!StringUtils.isEmpty(searchDTO.getSkill())) {
			criteria.add(Restrictions.like("skillSet.displayName", searchDTO.getSkill(), MatchMode.ANYWHERE));
		}

		criteria.add(Restrictions.eq("changeLog.status", StatusEnum.ACTIVE));
		criteria.add(Restrictions.eq("job.publish", PublishResponseEnum.PUBLISH.getValue()));
		criteria.add(Restrictions.gt("job.expiredDate", DateUtil.now()));

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

	@Override
	public boolean insertJobSkill(Integer jobId, List<String> skills) {

		Query query = null;
		StringBuffer insertJobSkillSQL = null;
		for(String skillId : skills) {
			insertJobSkillSQL = new StringBuffer();
			insertJobSkillSQL.append("INSERT INTO job_skill (job_id, skill_id) VALUES (:jobId, :skillId)");
			query = getSession().createSQLQuery(insertJobSkillSQL.toString());
			query.setParameter("jobId", jobId);
			query.setParameter("skillId", Integer.parseInt(skillId));
			if (query.executeUpdate() < 0) {
				return false;
			}
		}

		return true;
	}
	
	

	// @SuppressWarnings("unchecked")
	// @Override
	// public List<Job> getListJobSuggest(Integer first, Integer max,
	// List<Integer> skills) {
	//
	// Session session = getSession();
	// Criteria criteria = session.createCriteria(Job.class, "job");
	// criteria.createAlias("job.changeLog", "changeLog");
	// criteria.createAlias("job.company", "company");
	//
	// if (!Utils.isEmptyList(skills)) {
	// criteria.createAlias("job.skillSet", "skillSet");
	// }
	//
	// criteria.add(Restrictions.eq("changeLog.status",
	// StatusEnum.ACTIVE.getValue()));
	// criteria.add(Restrictions.gt("job.expiredDate", DateUtil.now()));
	//
	// if (!Utils.isEmptyList(skills)) {
	// criteria.add(Restrictions.in("skillSet.id", skills));
	// }
	//
	// criteria.addOrder(Order.desc("company.isVip"));
	// criteria.addOrder(Order.desc("changeLog.createdDate"));
	// criteria.addOrder(Order.desc("job.minSalary"));
	// criteria.addOrder(Order.desc("job.maxSalary"));
	// criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
	// criteria.setFirstResult(first);
	// criteria.setMaxResults(max);
	//
	// List<Job> jobList = criteria.list();
	// return jobList;
	// }
}

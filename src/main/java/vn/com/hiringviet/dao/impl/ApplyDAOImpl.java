package vn.com.hiringviet.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dao.ApplyDAO;
import vn.com.hiringviet.dto.ApplyDTO;
import vn.com.hiringviet.model.Apply;
import vn.com.hiringviet.model.ChangeLog;
import vn.com.hiringviet.model.Job;
import vn.com.hiringviet.model.Message;
import vn.com.hiringviet.util.Utils;

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
		Query query = null;
		StringBuffer insertChangeLogSQL = new StringBuffer();
		ChangeLog changeLog = Utils.createDefaultChangeLog();
		insertChangeLogSQL.append("INSERT INTO change_log (created_date, status, updated_date) VALUES (:createdDate, 1, :updatedDate)");
		query = getSession().createSQLQuery(insertChangeLogSQL.toString());
		query.setParameter("createdDate", changeLog.getCreatedDate());
		query.setParameter("updatedDate", changeLog.getUpdatedDate());
		query.executeUpdate();

		StringBuffer getLastIdSQL = new StringBuffer();
		getLastIdSQL.append("SELECT change_log.id FROM change_log ORDER BY id desc LIMIT 0,1");
		query = getSession().createSQLQuery(getLastIdSQL.toString());
		Integer clId = (Integer) query.uniqueResult();

		Session session = getSession();
		SQLQuery sqlQuery = session
				.createSQLQuery("INSERT INTO apply (change_log_id, curriculum_vitae, description, job_id, member_id) VALUES (:change_log_id,:curriculum_vitae,:description,:job_id,:member_id)");
		sqlQuery.setParameter("change_log_id", clId)
				.setParameter("curriculum_vitae", apply.getCurriculumVitae())
				.setParameter("description", apply.getDisscription())
				.setParameter("job_id", apply.getJob().getId())
				.setParameter("member_id", apply.getMember().getId())
				.executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ApplyDTO> getAllApplyByJobId(Integer jobId) {

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("CONCAT(mb.first_name, ' ', mb.last_name) as memberName, ");
		sql.append("ac.email as memberEmail, ");
		sql.append("re.phone_number as memberPhoneNumber, ");
		sql.append("ap.curriculum_vitae as curriculumVitae ");
		sql.append("FROM apply ap ");
		sql.append("LEFT JOIN member mb ON ap.member_id = mb.id ");
		sql.append("LEFT JOIN account ac ON mb.account_id = ac.id ");
		sql.append("LEFT JOIN resume re ON mb.id = re.member_id ");
		sql.append("WHERE ap.job_id = :jobId");
		Query query = getSession().createSQLQuery(sql.toString());
		query.setParameter("jobId", jobId);
		query.setResultTransformer(Transformers.aliasToBean(ApplyDTO.class));

		List<ApplyDTO> applyDTOs = (List<ApplyDTO>) query.list();
		return applyDTOs;
	}
}

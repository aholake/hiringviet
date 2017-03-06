package vn.com.hiringviet.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dto.ApplyDTO;
import vn.com.hiringviet.model.Apply;
import vn.com.hiringviet.model.Job;

// TODO: Auto-generated Javadoc
/**
 * The Interface ApplyDAO.
 */
@Repository
@Transactional
public interface ApplyDAO extends CommonDAO<Apply>{
	
	/**
	 * Gets the applies.
	 *
	 * @param job the job
	 * @return the applies
	 */
	List<Apply> getApplies(Job job);

	/**
	 * Adds the apply by native sql.
	 *
	 * @param apply the apply
	 */
	void addApplyByNativeSQL(Apply apply);

	/**
	 * Gets the all apply by job id.
	 *
	 * @param jobId the job id
	 * @return the all apply by job id
	 */
	List<ApplyDTO> getAllApplyByJobId(Integer jobId);
}

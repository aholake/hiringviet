package vn.com.hiringviet.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.api.dto.request.LoadMoreRequestDTO;
import vn.com.hiringviet.dto.JobDTO;
import vn.com.hiringviet.dto.SearchDTO;
import vn.com.hiringviet.model.Job;

// TODO: Auto-generated Javadoc
/**
 * The Interface JobDAO.
 */
@Repository
@Transactional
public interface JobDAO extends CommonDAO<Job> {

	/**
	 * Gets the job by id.
	 *
	 * @param jobID the job id
	 * @return the job by id
	 */
	public Job getJobByID(Integer jobID);

	/**
	 * Gets the list job.
	 *
	 * @param loadMoreRequestDTO the load more request dto
	 * @param first the first
	 * @param max the max
	 * @param skills the skills
	 * @param isHotJob the is hot job
	 * @param mode the mode
	 * @param keyValue the key value
	 * @return the list job
	 */
	public List<Job> getListJob(LoadMoreRequestDTO loadMoreRequestDTO,
			Integer first, Integer max, List<Integer> skills, boolean isHotJob,
			String mode, String keyValue);

	/**
	 * Search job.
	 *
	 * @param first the first
	 * @param max the max
	 * @param searchDTO the search dto
	 * @return the list
	 */
	public List<Job> searchJob(Integer first, Integer max, SearchDTO searchDTO);

	/**
	 * Search job by key word.
	 *
	 * @param keyWord the key word
	 * @return the list
	 */
	public List<JobDTO> searchJobByKeyWord(String keyWord);

	/**
	 * Gets the new jobs.
	 *
	 * @param companyId the company id
	 * @return the new jobs
	 */
	public List<JobDTO> getNewJobs(Integer companyId);

	/**
	 * Update description.
	 *
	 * @param jobId the job id
	 * @param description the description
	 * @return true, if successful
	 */
	public boolean updateDescription(Integer jobId, String description);

	/**
	 * Update requirement.
	 *
	 * @param jobId the job id
	 * @param requirement the requirement
	 * @return true, if successful
	 */
	public boolean updateRequirement(Integer jobId, String requirement);

	/**
	 * Update company policies.
	 *
	 * @param jobId the job id
	 * @param cultureDescription the culture description
	 * @return true, if successful
	 */
	public boolean updateCompanyPolicies(Integer jobId, String cultureDescription);
	
	/**
	 * Count applies.
	 *
	 * @param job the job
	 * @return the long
	 */
	long countApplies(Job job);

	/**
	 * Update visited.
	 *
	 * @param jobId the job id
	 * @return true, if successful
	 */
	boolean updateVisited(Integer jobId);

	/**
	 * Sets the publish.
	 *
	 * @param jobId the job id
	 * @param isPublish the is publish
	 * @return true, if successful
	 */
	boolean setPublish(Integer jobId, Integer isPublish);

	/**
	 * Insert job skill.
	 *
	 * @param jobId the job id
	 * @param skills the skills
	 * @return true, if successful
	 */
	public boolean insertJobSkill(Integer jobId, List<String> skills);

}

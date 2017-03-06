package vn.com.hiringviet.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.api.dto.request.LoadMoreRequestDTO;
import vn.com.hiringviet.dto.JobAdminTableDTO;
import vn.com.hiringviet.dto.JobDTO;
import vn.com.hiringviet.dto.SearchDTO;
import vn.com.hiringviet.model.Job;

// TODO: Auto-generated Javadoc
/**
 * The Interface JobService.
 */
@Service("jobService")
@Transactional
public interface JobService {

	/**
	 * Adds the job.
	 *
	 * @param job the job
	 * @return the int
	 */
	public int addJob(Job job);

	/**
	 * Gets the job list.
	 *
	 * @param loadMoreRequestDTO the load more request dto
	 * @param first the first
	 * @param max the max
	 * @param isHotJob the is hot job
	 * @param skills the skills
	 * @param mode the mode
	 * @param keyValue the key value
	 * @return the job list
	 */
	public List<Job> getJobList(LoadMoreRequestDTO loadMoreRequestDTO,
			Integer first, Integer max, boolean isHotJob, List<Integer> skills,
			String mode, String keyValue);

	/**
	 * Gets the job by id.
	 *
	 * @param id the id
	 * @return the job by id
	 */
	public Job getJobById(Integer id);

	/**
	 * Gets the job by id.
	 *
	 * @param id the id
	 * @return the job by id
	 */
	public Job getJobByID(Integer id);

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
	 * Gets the jobs for admin table.
	 *
	 * @return the jobs for admin table
	 */
	public List<JobAdminTableDTO> getJobsForAdminTable();

	/**
	 * Update description.
	 *
	 * @param jobId the job id
	 * @param discription the discription
	 * @return true, if successful
	 */
	public boolean updateDescription(Integer jobId, String discription);

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
	 * Search job.
	 *
	 * @param first the first
	 * @param max the max
	 * @param searchDTO the search dto
	 * @return the list
	 */
	public List<Job> searchJob(Integer first, Integer max, SearchDTO searchDTO);

	/**
	 * Insert job skill.
	 *
	 * @param jobId the job id
	 * @param skills the skills
	 * @return true, if successful
	 */
	public boolean insertJobSkill(Integer jobId, List<String> skills);
}

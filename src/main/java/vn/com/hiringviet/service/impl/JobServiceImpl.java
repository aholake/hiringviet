package vn.com.hiringviet.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.api.dto.request.LoadMoreRequestDTO;
import vn.com.hiringviet.converter.JobConverter;
import vn.com.hiringviet.dao.JobDAO;
import vn.com.hiringviet.dto.JobAdminTableDTO;
import vn.com.hiringviet.dto.JobDTO;
import vn.com.hiringviet.dto.SearchDTO;
import vn.com.hiringviet.model.Job;
import vn.com.hiringviet.service.JobService;

// TODO: Auto-generated Javadoc
/**
 * The Class JobServiceImpl.
 */
@Service("jobService")
@Transactional
public class JobServiceImpl implements JobService {

	/** The job dao. */
	@Autowired
	private JobDAO jobDAO;

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.JobService#getJobList(vn.com.hiringviet.api.dto.request.LoadMoreRequestDTO, java.lang.Integer, java.lang.Integer, boolean, java.util.List, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Job> getJobList(LoadMoreRequestDTO loadMoreRequestDTO,
			Integer first, Integer max, boolean isHotJob, List<Integer> skills,
			String mode, String keyValue) {

		return jobDAO.getListJob(loadMoreRequestDTO, first, max, skills, isHotJob, mode, keyValue);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.JobService#getJobById(java.lang.Integer)
	 */
	@Override
	public Job getJobById(Integer id) {

		return jobDAO.findOne(id);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.JobService#addJob(vn.com.hiringviet.model.Job)
	 */
	@Override
	public int addJob(Job job) {
		return jobDAO.create(job);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.JobService#getJobByID(java.lang.Integer)
	 */
	@Override
	public Job getJobByID(Integer id) {
		return jobDAO.getJobByID(id);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.JobService#searchJobByKeyWord(java.lang.String)
	 */
	@Override
	public List<JobDTO> searchJobByKeyWord(String keyWord) {
		return jobDAO.searchJobByKeyWord(keyWord);
	}


	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.JobService#getNewJobs(java.lang.Integer)
	 */
	public List<JobDTO> getNewJobs(Integer companyId) {
		return jobDAO.getNewJobs(companyId);
	}
	
	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.JobService#getJobsForAdminTable()
	 */
	@Override
	public List<JobAdminTableDTO> getJobsForAdminTable() {
		List<JobAdminTableDTO> jobAdminTableDTOs = new ArrayList<JobAdminTableDTO>();
		List<Job> jobs = jobDAO.findAll();
		for (Job job : jobs) {
			jobAdminTableDTOs.add(JobConverter.convert(job));
		}
		return jobAdminTableDTOs;

	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.JobService#updateDescription(java.lang.Integer, java.lang.String)
	 */
	@Override
	public boolean updateDescription(Integer jobId, String description) {

		return jobDAO.updateDescription(jobId, description);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.JobService#updateRequirement(java.lang.Integer, java.lang.String)
	 */
	@Override
	public boolean updateRequirement(Integer jobId, String requirement) {

		return jobDAO.updateRequirement(jobId, requirement);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.JobService#updateCompanyPolicies(java.lang.Integer, java.lang.String)
	 */
	@Override
	public boolean updateCompanyPolicies(Integer jobId, String cultureDescription) {

		return jobDAO.updateCompanyPolicies(jobId, cultureDescription);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.JobService#countApplies(vn.com.hiringviet.model.Job)
	 */
	@Override
	public long countApplies(Job job) {
		return jobDAO.countApplies(job);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.JobService#updateVisited(java.lang.Integer)
	 */
	@Override
	public boolean updateVisited(Integer jobId) {
		// TODO Auto-generated method stub
		return jobDAO.updateVisited(jobId);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.JobService#setPublish(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public boolean setPublish(Integer jobId, Integer isPublish) {
		// TODO Auto-generated method stub
		return jobDAO.setPublish(jobId, isPublish);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.JobService#searchJob(java.lang.Integer, java.lang.Integer, vn.com.hiringviet.dto.SearchDTO)
	 */
	@Override
	public List<Job> searchJob(Integer first, Integer max, SearchDTO searchDTO) {

		return jobDAO.searchJob(first, max, searchDTO);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.JobService#insertJobSkill(java.lang.Integer, java.util.List)
	 */
	@Override
	public boolean insertJobSkill(Integer jobId, List<String> skills) {
		// TODO Auto-generated method stub
		return jobDAO.insertJobSkill(jobId, skills);
	}
}

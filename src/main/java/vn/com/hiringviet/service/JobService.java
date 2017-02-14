package vn.com.hiringviet.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.api.dto.request.LoadMoreRequestDTO;
import vn.com.hiringviet.dto.JobAdminTableDTO;
import vn.com.hiringviet.dto.JobDTO;
import vn.com.hiringviet.dto.SearchDTO;
import vn.com.hiringviet.model.Job;

@Service("jobService")
@Transactional
public interface JobService {

	public int addJob(Job job);

	public List<Job> getJobList(LoadMoreRequestDTO loadMoreRequestDTO,
			Integer first, Integer max, boolean isHotJob, List<Integer> skills,
			String mode, String keyValue);

	public Job getJobById(Integer id);

	public Job getJobByID(Integer id);

	public List<JobDTO> searchJobByKeyWord(String keyWord);


	public List<JobDTO> getNewJobs(Integer companyId);

	
	public List<JobAdminTableDTO> getJobsForAdminTable();

	public boolean updateDescription(Integer jobId, String discription);

	public boolean updateRequirement(Integer jobId, String requirement);

	public boolean updateCompanyPolicies(Integer jobId, String cultureDescription);
	
	long countApplies(Job job);

	boolean updateVisited(Integer jobId);

	boolean setPublish(Integer jobId, Integer isPublish);

	public List<Job> searchJob(Integer first, Integer max, SearchDTO searchDTO);
}

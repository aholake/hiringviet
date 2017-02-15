package vn.com.hiringviet.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.api.dto.request.LoadMoreRequestDTO;
import vn.com.hiringviet.dto.JobDTO;
import vn.com.hiringviet.dto.SearchDTO;
import vn.com.hiringviet.model.Job;

@Repository
@Transactional
public interface JobDAO extends CommonDAO<Job> {

	public Job getJobByID(Integer jobID);

	public List<Job> getListJob(LoadMoreRequestDTO loadMoreRequestDTO,
			Integer first, Integer max, List<Integer> skills, boolean isHotJob,
			String mode, String keyValue);

	public List<Job> searchJob(Integer first, Integer max, SearchDTO searchDTO);

	public List<JobDTO> searchJobByKeyWord(String keyWord);

	public List<JobDTO> getNewJobs(Integer companyId);

	public boolean updateDescription(Integer jobId, String description);

	public boolean updateRequirement(Integer jobId, String requirement);

	public boolean updateCompanyPolicies(Integer jobId, String cultureDescription);
	
	long countApplies(Job job);

	boolean updateVisited(Integer jobId);

	boolean setPublish(Integer jobId, Integer isPublish);
}

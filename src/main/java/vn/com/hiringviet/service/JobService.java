package vn.com.hiringviet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.dto.JobDTO;

@Service("jobService")
public interface JobService {

	public JobDTO getJobByID(Integer jobID);

	public List<JobDTO> getListJobHot(Integer first, Integer max);

	public List<JobDTO> getListJobSuggest(Integer first, Integer max);
}

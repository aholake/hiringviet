package vn.com.hiringviet.service;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.dto.JobDTO;

@Service("jobService")
public interface JobService {

	public JobDTO getJobByID(Integer jobID);
}

package vn.com.hiringviet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.model.Job;

@Service("jobService")
public interface JobService {

	public Job getJobByID(Integer jobID);

	public List<Job> getListJobHot(Integer first, Integer max);

	public List<Job> getListJobSuggest(Integer first, Integer max);
}

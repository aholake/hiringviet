package vn.com.hiringviet.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.model.Job;
import vn.com.hiringviet.service.JobService;

@Service("jobService")
public class JobServiceImpl implements JobService {

	@Override
	public Job getJobByID(Integer jobID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Job> getListJobHot(Integer first, Integer max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Job> getListJobSuggest(Integer first, Integer max) {
		// TODO Auto-generated method stub
		return null;
	}

}

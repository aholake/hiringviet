package vn.com.hiringviet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dao.JobDAO;
import vn.com.hiringviet.model.Job;
import vn.com.hiringviet.service.JobService;

@Service("JobService")
@Transactional
public class JobServiceImpl implements JobService {

	@Autowired
	private JobDAO jobDAO;

	@Override
	public List<Job> getJobList(Integer first, Integer max, boolean isJobHot,
			List<Integer> skills) {

		if (isJobHot) {
			return jobDAO.getListJobHot(first, max, skills);
		} else {
			return jobDAO.getListJobSuggest(first, max, skills);
		}
	}

	@Override
	public Job getJobById(Integer id) {

		return jobDAO.findOne(id);
	}

	@Override
	public int addJob(Job job) {
		// TODO Auto-generated method stub
		return jobDAO.create(job);
	}
}

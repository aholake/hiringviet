package vn.com.hiringviet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.api.dto.request.LoadMoreRequestDTO;
import vn.com.hiringviet.dao.JobDAO;
import vn.com.hiringviet.dto.JobDTO;
import vn.com.hiringviet.model.Job;
import vn.com.hiringviet.service.JobService;

@Service("JobService")
@Transactional
public class JobServiceImpl implements JobService {

	@Autowired
	private JobDAO jobDAO;

	@Override
	public List<Job> getJobList(LoadMoreRequestDTO loadMoreRequestDTO,
			Integer first, Integer max, boolean isHotJob, List<Integer> skills) {

		return jobDAO.getListJob(loadMoreRequestDTO, first, max, skills, isHotJob);
	}

	@Override
	public Job getJobById(Integer id) {

		return jobDAO.findOne(id);
	}

	@Override
	public int addJob(Job job) {
		return jobDAO.create(job);
	}

	@Override
	public Job getJobByID(Integer id) {
		return jobDAO.getJobByID(id);
	}

	@Override
	public List<JobDTO> searchJobByKeyWord(String keyWord) {
		return jobDAO.searchJobByKeyWord(keyWord);
	}
}

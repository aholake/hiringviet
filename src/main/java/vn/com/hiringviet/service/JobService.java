package vn.com.hiringviet.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.api.dto.request.LoadMoreRequestDTO;
import vn.com.hiringviet.model.Job;

@Service("JobService")
@Transactional
public interface JobService {

	public int addJob(Job job);

	public List<Job> getJobList(LoadMoreRequestDTO loadMoreRequestDTO,Integer first, Integer max, boolean isJobHot,
			List<Integer> skills);

	public Job getJobById(Integer id);

	public Job getJobByID(Integer id);
}

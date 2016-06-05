package vn.com.hiringviet.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.model.Job;

@Service("JobService")
@Transactional
public interface JobService {

	public List<Job> getJobList(Integer first, Integer max);

	public Job getJobById(Integer id);
}

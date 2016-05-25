package vn.com.hiringviet.service.impl;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.JobDAO;
import vn.com.hiringviet.dto.JobDTO;
import vn.com.hiringviet.model.Job;
import vn.com.hiringviet.service.JobService;

import com.google.common.reflect.TypeToken;

@Service("jobService")
public class JobServiceImpl implements JobService {

	@Autowired
	private JobDAO jobDAO;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public JobDTO getJobByID(Integer jobID) {

		return  jobDAO.getJobByID(jobID);
	}

	@SuppressWarnings("serial")
	@Override
	public List<JobDTO> getListJobHot(Integer first, Integer max) {

		List<Job> jobList = jobDAO.getListJobHot(first, max);
		Type type = new TypeToken<List<Job>>() {}.getType();
		List<JobDTO> jobDTOList = modelMapper.map(jobList, type);
		return jobDTOList;
	}
}

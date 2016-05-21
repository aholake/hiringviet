package vn.com.hiringviet.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.JobDAO;
import vn.com.hiringviet.dto.JobDTO;
import vn.com.hiringviet.model.Job;
import vn.com.hiringviet.service.JobService;

@Service("jobService")
public class JobServiceImpl implements JobService {

	@Autowired
	private JobDAO jobDAO;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public JobDTO getJobByID(Integer jobID) {

		JobDTO jobDTO = new JobDTO();
		Job job = jobDAO.findOne(jobID);
		try {
			BeanUtils.copyProperties(jobDTO, job);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return jobDTO;
	}
}

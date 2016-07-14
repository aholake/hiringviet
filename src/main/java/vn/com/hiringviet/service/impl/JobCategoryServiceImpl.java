package vn.com.hiringviet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.JobCategoryDAO;
import vn.com.hiringviet.model.JobCategory;
import vn.com.hiringviet.service.JobCategoryService;

@Service("jobCategoryService")
public class JobCategoryServiceImpl implements JobCategoryService {
	@Autowired
	private JobCategoryDAO jobCategoryDAO;

	@Override
	public List<JobCategory> getJobCategoryList() {
		return jobCategoryDAO.findAll();
	}

}

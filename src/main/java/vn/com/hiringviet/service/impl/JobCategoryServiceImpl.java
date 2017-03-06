package vn.com.hiringviet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.JobCategoryDAO;
import vn.com.hiringviet.model.JobCategory;
import vn.com.hiringviet.service.JobCategoryService;

// TODO: Auto-generated Javadoc
/**
 * The Class JobCategoryServiceImpl.
 */
@Service("jobCategoryService")
public class JobCategoryServiceImpl implements JobCategoryService {
	
	/** The job category dao. */
	@Autowired
	private JobCategoryDAO jobCategoryDAO;

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.JobCategoryService#getJobCategoryList()
	 */
	@Override
	public List<JobCategory> getJobCategoryList() {
		return jobCategoryDAO.findAll();
	}

}

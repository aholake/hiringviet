package vn.com.hiringviet.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dao.JobCategoryDAO;
import vn.com.hiringviet.model.JobCategory;

@Repository
@Transactional
public class JobCategoryDAOImpl extends CommonDAOImpl<JobCategory> implements
		JobCategoryDAO {

}

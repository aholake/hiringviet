package vn.com.hiringviet.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.model.Job;

@Repository
@Transactional
public interface JobDAO extends CommonDAO<Job> {

	public Job getJobByID(Integer jobID);

	public List<Job> getListJobHot(Integer first, Integer max);

	public List<Job> getListJobSuggest(Integer first, Integer max);
}

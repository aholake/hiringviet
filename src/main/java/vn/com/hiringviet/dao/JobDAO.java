package vn.com.hiringviet.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dto.JobDTO;
import vn.com.hiringviet.model.Job;

@Repository
@Transactional
public interface JobDAO extends CommonDAO<Job> {

	public JobDTO getJobByID(Integer jobID);

	public List<Job> getListJobHot(Integer first, Integer max);
}

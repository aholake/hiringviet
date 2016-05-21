package vn.com.hiringviet.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.model.Job;

@Repository
@Transactional
public interface JobDAO extends CommonDAO<Job> {

}

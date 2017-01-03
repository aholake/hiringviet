package vn.com.hiringviet.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.model.Apply;
import vn.com.hiringviet.model.Job;

@Repository
@Transactional
public interface ApplyDAO extends CommonDAO<Apply>{
	List<Apply> getApplies(Job job);
}

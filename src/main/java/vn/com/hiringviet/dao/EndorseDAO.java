package vn.com.hiringviet.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.model.Endorse;

@Repository
@Transactional
public interface EndorseDAO extends CommonDAO<Endorse> {

	public boolean deleteByAccountId(Integer accountId, Integer skillResumeId);
}
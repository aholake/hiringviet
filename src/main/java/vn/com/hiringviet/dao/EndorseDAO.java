package vn.com.hiringviet.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.model.Endorse;

// TODO: Auto-generated Javadoc
/**
 * The Interface EndorseDAO.
 */
@Repository
@Transactional
public interface EndorseDAO extends CommonDAO<Endorse> {

	/**
	 * Delete by account id.
	 *
	 * @param accountId the account id
	 * @param skillResumeId the skill resume id
	 * @return true, if successful
	 */
	public boolean deleteByAccountId(Integer accountId, Integer skillResumeId);
}

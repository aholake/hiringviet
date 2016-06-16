package vn.com.hiringviet.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * The Interface FollowDAO.
 */
@Repository
@Transactional
public interface FollowDAO {

	/**
	 * Count number of follower.
	 *
	 * @param accountId the account id
	 * @return the integer
	 */
	public Long countNumberOfFollower(Integer accountId);
}

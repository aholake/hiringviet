package vn.com.hiringviet.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.model.Follow;

// TODO: Auto-generated Javadoc
/**
 * The Interface FollowDAO.
 */
@Repository
@Transactional
public interface FollowDAO extends CommonDAO<Follow>  {

	/**
	 * Count number of follower.
	 *
	 * @param accountId the account id
	 * @return the integer
	 */
	public Long countNumberOfFollower(Integer accountId);
}
